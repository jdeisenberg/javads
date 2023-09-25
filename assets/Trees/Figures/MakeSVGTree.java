import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Build a Binary Search Tree Diagram from a text description
 * 
 * Each line in the text file describes a level in the tree,
 * starting with the first line as the root.
 * 
 * The line has two parts, separated by a colon:
 *    The node positions
 *    The node values
 * 
 * In the node part, we use:
 *    B  for a node that has both right/left child
 *    L  for a node that has a left child only
 *    R  for a node that has a right child only
 *    N  for a node that has no children (a leaf node)
 *
 * If the letter is upper case, the node is filled in light gray;
 * if the letter is lower case, the node is filled in white.
 * 
 * Here are a couple of lines as an example:
 * <.><L><.N<.><.><.><.><.>   <.><L><.N<.><.><.><.><.>: 9 16    9 16
 * <.R<.><.><.><.><.><.><.>   <.N<.><.><.><.><.><.><.>: 7 8
 * 
 * The <.> are ignored while processing the tree; they are there to
 * help me visually align the node positions.
 * 
 * The output (which goes to a terminal) is an SVG file.
 * In the build process, I used Inkscape to convert each SVG to PDF,
 * which I then imported into LibreOffice Draw for adding arrows
 * and notations.
 */

public class MakeSVGTree {

    static int X_SPACING = 15;
    static int Y_SPACING = 70;
    static int RADIUS = 20;

    public static void makeSVGHeader(int width, int height) {
        System.out.printf("""
<?xml version="1.0"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
    "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">

<svg width="%d" height="%d" xmlns="http://www.w3.org/2000/svg">
    <style type="text/css"><![CDATA[
    .white {fill: white;}
    .gray {fill: #ddd;}
    text {
       stroke: none;
       text-anchor: middle;
       dominant-baseline: central;
       font-family: sans-serif;
       font-size: 16pt;
       }
    ]]></style>

    <g style="stroke:black; stroke-width: 2;">
    """, width * X_SPACING + RADIUS, height * Y_SPACING + RADIUS);
    }

    public static void endSVG() {
        System.out.printf("</g>%n</svg>%n");
    }

    public static int findNode(String[] line, int col, int step) {
        // System.err.printf("row %s ", Arrays.toString(line));
        while (col >= 0 && col < line.length &&
            !Character.isLetter(line[col].charAt(0))) {
            col += step;
        }
        // System.err.printf("Found col %d step %d%n", col, step);
        return col;
    }

    public static void emitLine(int x1, int y1, int x2, int y2) {
        System.out.printf("   <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\"/>%n",
            x1, y1, x2, y2);
    }

    public static void makeDiagram(ArrayList<String[]> nodes, ArrayList<String[]> values,
      int nLines, int widestLine) {
        makeSVGHeader(widestLine, nLines);
        /* Draw the lines */
        final int BASE_X = RADIUS / 2;
        for (int row = 0; row < nodes.size() - 1; row++) {
            int cy = row * Y_SPACING + RADIUS * 3 / 2;
            String[] line = nodes.get(row);
            String[] nextLine = nodes.get(row + 1);
            for (int col = 0; col < line.length; col++) {
                int cx = BASE_X + col * X_SPACING + RADIUS;
                int destY = cy + Y_SPACING;
                int destX;
                if (line[col].equalsIgnoreCase("B") || line[col].equalsIgnoreCase("L")) {
                    // System.err.printf("Line %d, col %d %s: ", row, col, line[col]);
                    destX = BASE_X + findNode(nextLine, col - 1, -1) * X_SPACING + RADIUS;
                    emitLine(cx, cy, destX, destY);
                }
                if (line[col].equalsIgnoreCase("B") || line[col].equalsIgnoreCase("R")) {
                    // System.err.printf("Line %d, col %d %s: ", row, col, line[col]);
                    destX = BASE_X + findNode(nextLine, col + 1, 1) * X_SPACING + RADIUS;
                    emitLine(cx, cy, destX, destY);
                }
            }
        }
        /* Now draw the circles */
        for (int row = 0; row < nodes.size(); row++) {
            int valueIndex = 0;
            int cy = row * Y_SPACING + RADIUS * 3 / 2;
            String[] line = nodes.get(row);
            String[] contents = values.get(row);
            String style = "";
            for (int col = 0; col < line.length; col++) {
                int cx = BASE_X + col * X_SPACING + RADIUS;
                char ch = line[col].charAt(0);
                if (Character.isLetter(ch))  {
                    if (Character.isLowerCase(ch)) {
                        style="white";
                    } else {
                        style="gray";
                    }
                    System.out.printf("<circle class=\"%s\" cx=\"%d\" cy=\"%d\" r=\"%d\"/>%n",
                        style, cx, cy, RADIUS);
                    System.out.printf("<text x=\"%d\" y=\"%d\">%s</text>%n",
                        cx, cy, contents[valueIndex]);
                    valueIndex++;
                }
            }
        }
        endSVG();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String filename = args[0];
            int widestLine = 0;
            int nLines = 0;
            ArrayList<String[]> nodes = new ArrayList<>();
            ArrayList<String[]> values = new ArrayList<>();

            File inFile = new File(filename);
            try (Scanner input = new Scanner(inFile)) {
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] parts = line.split(":");

                    nodes.add(parts[0].trim().split(""));
                    values.add(parts[1].trim().split("\\s+"));

                    widestLine = Math.max(widestLine, parts[0].trim().length());
                }
                nLines = nodes.size();
                // System.err.printf("%d lines (widest %d chars)%n", nLines, widestLine);
                makeDiagram(nodes, values, nLines, widestLine);
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            System.out.println("Usage: java MakeSVGTree filename");
        }
    }

}
