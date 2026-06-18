public class Triangle extends Shape {

    private double a, b, c;   // the three sides

    // ------------------- constructors
    public Triangle(double a, double b, double c) {
        this("white", false, a, b, c);
    }

    public Triangle(String color, boolean filled,
                    double a, double b, double c) {
        super(color, filled);

        // 1. All sides must be positive
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new InvalidShapeException(
                "All triangle sides must be positive, got: "
                + a + ", " + b + ", " + c);
        }
        // 2. Triangle inequality: each side < sum of the other two
        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new InvalidShapeException(
                "Sides " + a + ", " + b + ", " + c
                + " violate the triangle inequality.");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    // ------------------ accessors
    public double getSideA() { return a; }
    public double getSideB() { return b; }
    public double getSideC() { return c; }

    // -------------- Shape contract

    /** Heron's formula: area = sqrt(s(s-a)(s-b)(s-c)) where s = semi-perimeter */
    @Override
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    /** Scales all three sides by {@code factor}. */
    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException(
                "Resize factor must be positive, got: " + factor);
        }
        a *= factor;
        b *= factor;
        c *= factor;
    }

    @Override
    public String toString() {
        return "Triangle[color=" + color
             + ", filled=" + filled
             + ", sides="  + String.format("%.2f", a) + "/"
                           + String.format("%.2f", b) + "/"
                           + String.format("%.2f", c)
             + ", area="   + String.format("%.2f", getArea())
             + ", perimeter=" + String.format("%.2f", getPerimeter())
             + "]";
    }
}
