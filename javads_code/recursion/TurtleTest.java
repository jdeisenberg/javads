import java.util.*;
import java.awt.*;

public class TurtleTest
{
    
      public static void dropBreadCrumb(Turtle t, Color color) {
        double saveHeading = t.getHeading();
        Color saveColor = t.getColor();
        t.penUp();
        t.setColor(color);
        t.setFillColor(color);
        t.beginFill();
        t.setHeading(0);
        t.forward(0.1);
        t.turnRight(45);
        t.penDown();
        for (int i = 0; i < 4; i++) {
            t.forward(0.141);
            t.turnLeft(90);
        }
        t.endFill();
        t.setColor(saveColor);
        t.setHeading(saveHeading);
    }

  public static void main(String[] args)
  {
      World habitat = new World(300,300);
      Turtle yertle = new Turtle(habitat);
      yertle.setDelay(0.1);
      
      habitat.setVisible(true);
      

      yertle.beginFill();
      yertle.setFillColor(Color.RED);
      yertle.forward();
      yertle.turnLeft(90);
      yertle.forward();
      yertle.turnLeft(90);
      yertle.forward();
      yertle.turnLeft(90);
      yertle.forward();
      yertle.turnLeft(90);
      yertle.endFill();
      yertle.penUp();
      yertle.goTo(100, 100);
      habitat.setUpdating(false);
      dropBreadCrumb(yertle, Color.BLUE);
      habitat.setUpdating(true);
      yertle.hide();
  }
}
