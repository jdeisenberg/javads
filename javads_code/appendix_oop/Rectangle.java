public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calcArea() {
        return this.width * this.height;
    }

    public double calcPerimeter() {
        return 2.0 * (this.width + this.height);
    }

    public String toString() {
        return String.format("Rectangle: %s [%.1f x %.1f]", super.toString(),
            this.width, this.height);
    }
}
