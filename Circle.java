public class Circle extends Shape {

    private double radius;

    // --------------------------------------------------------------- constructors
    public Circle(double radius) {
        this("white", false, radius);
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException(
                "Circle radius must be positive, got: " + radius);
        }
        this.radius = radius;
    }

    // -------------------------------------------------------------- accessors
    public double getRadius() { return radius; }

    // ---------------------------------------------------------- Shape contract
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {          // circumference
        return 2 * Math.PI * radius;
    }

    /**
     * Scales the radius by {@code factor}.
     * Area grows by factor², perimeter grows by factor.
     */
    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException(
                "Resize factor must be positive, got: " + factor);
        }
        radius *= factor;
    }

    @Override
    public String toString() {
        return "Circle[color=" + color
             + ", filled=" + filled
             + ", radius=" + String.format("%.2f", radius)
             + ", area="   + String.format("%.2f", getArea())
             + ", perimeter=" + String.format("%.2f", getPerimeter())
             + "]";
    }
}
