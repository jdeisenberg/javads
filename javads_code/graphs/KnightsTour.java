import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KnightsTour {
    
    public static Graph<Integer> makeKnightGraph(int boardSize) {
        Graph<Integer> knightGraph = new Graph<Integer>();

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                int nodeId = row * boardSize + col;
                ArrayList<Integer> newPositions = generateLegalMoves(row, col,
                    boardSize);
                for (int position = 0; position < newPositions.size();
                  position += 2) {
                    
                    int otherNodeId =
                      newPositions.get(position) * boardSize +
                      newPositions.get(position + 1);
                    knightGraph.addEdge(nodeId, otherNodeId);
                }
            }
        }
        return knightGraph;
    }
    
    /*
     * Return an ArrayList of pairs of rows and columns as a
     * single-dimensional list (even index is row, odd index is column)
     */
    public static ArrayList<Integer> generateLegalMoves(int row, int col, int boardSize) {
        ArrayList<Integer> legalMoves = new ArrayList<>();
        int[][] moveOffsets = {
            {-1, -2},  // left-down-down
            {-1, 2},   // left-up-up
            {-2, -1},  // left-left-down
            {-2, 1},   // left-left-up
            {1, -2},   // right-down-down
            {1, 2},    // right-up-up
            {2, -1},   // right-right-down
            {2, 1},    // right-right-up
        };
        for (int[] offset: moveOffsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            
            if (newRow >= 0 && newRow < boardSize &&
                newCol >= 0 && newCol < boardSize) {
                legalMoves.add(newRow);
                legalMoves.add(newCol);
            }
        }
        return legalMoves;
    }
    
    public static long nIterations = 0;
    
    public static boolean knightTour(int currentDepth, ArrayList<Vertex<Integer>> path,
        Vertex<Integer> vertex, int nodesInPath) {
        boolean done;
        
        /*System.out.println("Entering at depth " + currentDepth +
            " vertex: " + vertex + " path size: " + path.size());*/
        vertex.color = VertexColor.GRAY;
        path.add(vertex);
        
        if (currentDepth < nodesInPath) {
            ArrayList<Vertex<Integer>> neighbors =
              new ArrayList<>(vertex.getNeighbors());
            Collections.sort(neighbors);
            int i = 0;
            done = false;
            while (i < neighbors.size() && !done) {
                if (neighbors.get(i).color == VertexColor.WHITE) {
                    done = knightTour(currentDepth + 1, path,
                        neighbors.get(i), nodesInPath);
                }
                i = i + 1;
                nIterations++;
            }
            if (!done) { // prepare to backtrack
                path.remove(path.size() - 1);
                vertex.setColor(VertexColor.WHITE);
            }
        } else {
            done = true;
        }
        return done;
        
    }
    
    public static void main(String[] args) {
        Graph<Integer> knightGraph = makeKnightGraph(8);
        ArrayList<Vertex<Integer>> path = new ArrayList<>();
        knightTour(0, path, knightGraph.getVertex(0), 63);
        System.out.println("Path size: " + path.size());
        boolean[] encountered = new boolean[path.size()];
        String result = "";
        for (int i = 0; i < path.size(); i++) {
            Vertex<Integer> v = path.get(i);
            if (encountered[i]) {
                System.out.println("Node " + i + " visited twice?");
            }
            encountered[i] = true;
            result = result + (v.key + ", ");
        }
        for (int i = 0; i < path.size(); i++) {
            if (!encountered[i]) {
                System.out.println("Never visited square " + i);
            }
        }
        System.out.println(result.substring(0, result.length() - 2));
    }
}

