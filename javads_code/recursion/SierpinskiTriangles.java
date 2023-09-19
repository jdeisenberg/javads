import java.awt.Color;
import java.awt.geom.Point2D;

public class SierpinskiTriangles {
    
    public static void drawTriangle(Point2D.Double[] points, Color color, Turtle t) {
        t.penUp();
        t.goTo(points[0].x, points[0].y);
        t.penDown();
        t.setFillColor(color);
        t.beginFill();
        t.goTo(points[1].x, points[1].y);
        t.goTo(points[2].x, points[2].y);
        t.goTo(points[0].x, points[0].y);
        t.endFill();
    }
    
    public static Point2D.Double midpoint(Point2D.Double p1, Point2D.Double p2) {
        return new Point2D.Double((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0);
    }
    
    public static Color[] colorMap = {
        Color.BLUE, Color.RED, Color.GREEN,
        Color.WHITE, Color.YELLOW, Color.MAGENTA, Color.ORANGE};
    
    public static void sierpinski(Point2D.Double[] points, int level, Turtle t) {
        drawTriangle(points, colorMap[level], t);
        if (level > 0) {
            
            Point2D.Double[] triangle1 = {
                points[0], midpoint(points[0], points[1]),
                midpoint(points[0], points[2]) };
            
            sierpinski(triangle1, level -1, t);

            Point2D.Double[] triangle2 = {
                points[1], midpoint(points[0], points[1]),
                midpoint(points[1], points[2])
            };
            
            sierpinski(triangle2, level -1, t);
            
            Point2D.Double[] triangle3 = {
                points[2], midpoint(points[2], points[1]),
                midpoint(points[0], points[2])
            };
            
            sierpinski(triangle3, level -1, t);
        }
    }
    
    public static void main(String[] args) {
        World habitat = new World(400, 400);
        Turtle t = new Turtle(habitat);
        
        t.setDelay(0.05);
        
        Point2D.Double[] points = {
            new Point2D.Double(-180, -150),
            new Point2D.Double(0, 150),
            new Point2D.Double(180, -150)
        };
        
        sierpinski(points, 5, t);
        t.hide();
    }
}


