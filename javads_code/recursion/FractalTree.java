import java.awt.Color;

public class FractalTree {
    public static void main(String[] args)
    {
        World habitat = new World(300, 300);
        Turtle t = new Turtle(habitat);
        
        final Color DARK_GREEN = new Color(0.0, 0.5, 0.0);
        t.setDelay(0.1);
        
        t.turnLeft(90);
        t.penUp(); // do not draw a trace
        t.backward(100);
        t.penDown();
        t.setColor(DARK_GREEN);
        drawTree(75, t);
    }

    public static void drawTree(int branchLen, Turtle t) {
        if (branchLen > 5) {
            t.forward(branchLen);
            t.turnRight(20);
            drawTree(branchLen - 15, t);
            t.turnLeft(40);
            drawTree(branchLen - 15, t);
            t.turnRight(20);
            t.backward(branchLen);
        }
    }

}
