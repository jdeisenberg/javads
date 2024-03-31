import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.io.File;

public class Maze {
    
    static final String START = "S";
    static final String OBSTACLE = "+";
    static final String TRIED = ".";
    static final String DEAD_END = "-";
    static final String PART_OF_PATH = "O";
    
    World habitat;
    Turtle t;

    int rowsInMaze;
    int columnsInMaze;
    int startRow;
    int startColumn;
    
    ArrayList<String[]> mazeList;
    
    double xTranslate;
    double yTranslate;
    
    public Maze(String mazeFileName) {
        File inFile = new File(mazeFileName);
        try (Scanner input = new Scanner(inFile)) {
            String line;
            int row = 0;
            this.mazeList = new ArrayList<String[]>();
            while (input.hasNextLine()) {
                line = input.nextLine();
                int sCol = line.indexOf(START);
                if (sCol >= 0) {
                    startRow = row;
                    startColumn = sCol;
                }
                this.mazeList.add(line.split(""));
                row = row + 1;
            }
            this.rowsInMaze = this.mazeList.size();
            this.columnsInMaze = (this.mazeList.get(0)).length;
            this.xTranslate = -this.columnsInMaze / 2.0;
            this.yTranslate = this.rowsInMaze / 2.0;
            this.habitat = new World(600, 600, Color.WHITE,
                -(this.columnsInMaze - 1) / 2.0 - 0.5,
                -(this.rowsInMaze - 1) / 2.0 - 0.5,
                (this.columnsInMaze - 1) / 2.0 + 0.5,
                (this.rowsInMaze -1) / 2.0 + 0.5);
            this.t = new Turtle(habitat);
            t.hide();
        }
        catch (Exception ex) {
            this.mazeList = null;
        }
        
    }
    
    public void drawMaze() {
        t.setDelay(0);
        this.habitat.setUpdating(false);
        for (int y = 0; y < this.rowsInMaze; y++) {
            for (int x = 0; x < this.columnsInMaze; x++) {
                if (this.mazeList.get(y)[x].equals(OBSTACLE)) {
                    this.drawCenteredBox(x + this.xTranslate,
                        -y + this.yTranslate, new Color(184,134,11));
                }
                t.setColor(Color.BLACK);
            }
        }
        this.habitat.setUpdating(true);
        t.setDelay(0.04);
    }

    public void drawCenteredBox(double x, double y, Color color) {
        t.penUp();
        t.setColor(Color.BLACK);
        t.setFillColor(color);
        t.beginFill();
        t.goTo(x + 1, y - 1);
        t.setHeading(-90);
        t.penDown();
        for (int i = 0; i < 4; i++) {
            t.forward(1);
            t.turnLeft(90);
        }
        t.endFill();
    }
    
    public void updatePosition(int row, int col, String value) {
        moveTurtle(col, row);
        if (value != null) {
            mazeList.get(row)[col] = value;
        
            Color color = null;
            if (value.equals(PART_OF_PATH)) {
                color = new Color(0, 192, 0);  //bright green
            } else if (value.equals(OBSTACLE)) {
                color = Color.RED;
            } else if (value.equals(TRIED)) {
                color = Color.BLACK;
            } else if (value.equals(DEAD_END)) {
                color = Color.RED;
            }
            
            if (color != null) {
                dropBreadCrumb(color);
            }
        }
    }

    public void moveTurtle(double x, double y) {
        t.penUp();
        t.show();
        t.setHeading(t.towards(x + this.xTranslate, -y + this.yTranslate));
        t.goTo(x + xTranslate + 0.5, -y + this.yTranslate - 0.5);
    }
    
    public void dropBreadCrumb(Color color) {
        Color saveColor = t.getColor();
        t.setColor(color);
        t.drawDot(0.25);
        t.setColor(saveColor);
    }
        
    public boolean isExit(int row, int col) {
        return (
            row == 0 ||
            row == rowsInMaze - 1 ||
            col == 0 ||
            col == columnsInMaze -1
        );
    }
    
    public boolean searchFrom(int startRow, int startColumn) {
        /*
         * try each of the four directions from this point until we find
         * a way out.
         */
        updatePosition(startRow, startColumn, null);
        
        /*
         *  Base case return values:
         *  1. We have run into an obstacle; return false
         */
        String value = getItem(startRow, startColumn);
        if (value.equals(OBSTACLE)) {
            return false;
        }
        
        /* 2. We have found a square that has already been explored */
        if (value.equals(TRIED) || value.equals(DEAD_END)) {
            return false;
        }
            
        /* 3. We have found an outside edge not occupied by an obstacle */
        if (isExit(startRow, startColumn)) {
            updatePosition(startRow, startColumn, PART_OF_PATH);
            return true;
        }
        
        updatePosition(startRow, startColumn, TRIED);
        
        /*
         * Otherwise, use logical short circuiting to try each direction
         * in turn (if needed)
         */
        boolean found = (
            searchFrom(startRow - 1, startColumn)
            || searchFrom(startRow + 1, startColumn)
            || searchFrom(startRow, startColumn - 1)
            || searchFrom(startRow, startColumn + 1)
        );
    
        if (found) {
            updatePosition(startRow, startColumn, PART_OF_PATH);
        } else {
            updatePosition(startRow, startColumn, DEAD_END);
        }
        return found;
    }
    
    public String getItem(int row, int col) {
        return mazeList.get(row)[col];
    }

    public static void main(String[] args) {
        Maze myMaze = new Maze("maze2.txt");
        myMaze.drawMaze();
        myMaze.updatePosition(myMaze.startRow, myMaze.startColumn, null);
        myMaze.searchFrom(myMaze.startRow, myMaze.startColumn);
        myMaze.t.setHeading(90);
    }
}
