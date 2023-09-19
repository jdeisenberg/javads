import java.util.*;
import java.awt.*;

public class TurtleTest
{
    
      public static void dropBreadCrumb(Turtle t, Color color) {
        t.setFillColor(color);
        t.setColor(color);
        t.drawDot(10);
    
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
