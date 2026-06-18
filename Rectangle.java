public class Rectangle extends Shape {

    private double width;
    private double height;

    //---------------- constructors
    public Rectangle(double width, double height) {
        this("white", false, width, height);
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        if (width <= 0) {
            throw new InvalidShapeException(
                "Rectangle width must be positive, got: " + width);
        }
        if (height <= 0) {
            throw new InvalidShapeException(
                "Rectangle height must be positive, got: " + height);
        }
        this.width  = width;
        this.height = height;
    }

    //-------------------- accessors
    public double getWidth()  { return width;  }
    public double getHeight() { return height; }

    // ---------------- Shape contract
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    /** Scales both width and height by {@code factor}. */
    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException(
                "Resize factor must be positive, got: " + factor);
        }
        width  *= factor;
        height *= factor;
    }

    @Override
    public String toString() {
        return "Rectangle[color=" + color
             + ", filled=" + filled
             + ", width="  + String.format("%.2f", width)
             + ", height=" + String.format("%.2f", height)
             + ", area="   + String.format("%.2f", getArea())
             + ", perimeter=" + String.format("%.2f", getPerimeter())
             + "]";
    }
}
