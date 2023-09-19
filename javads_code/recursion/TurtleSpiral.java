public class TurtleSpiral {
    public static void main(String[] args)
    {
      World habitat = new World(300, 300);
      Turtle yertle = new Turtle(habitat);

      yertle.setDelay(0.1);
      habitat.setVisible(true);
      drawSpiral(yertle, 100);
      yertle.hide();
    }

    public static void drawSpiral(Turtle myTurtle, int lineLength) {
        if (lineLength > 0) {
            myTurtle.forward(lineLength);
            myTurtle.turnRight(90);
            drawSpiral(myTurtle, lineLength - 5);
        }
    }

}
