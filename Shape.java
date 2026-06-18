
public abstract class Shape {

    // ----------------- fields
    protected String  color  = "white";
    protected boolean filled;

    // ----------------- constructors
    public Shape() { }

    public Shape(String color, boolean filled) {
        this.color  = color;
        this.filled = filled;
    }

    // --------------- abstract methods
    /** Returns the area of this shape. */
    public abstract double getArea();

    /** Returns the perimeter of this shape. */
    public abstract double getPerimeter();

    /**
     * Scales every linear dimension by {@code factor}.
     * @throws InvalidShapeException if factor <= 0
     */
    public abstract void resize(double factor);

    // ------------- concrete method
    @Override
    public String toString() {
        return getClass().getSimpleName()
             + "[color=" + color
             + ", filled=" + filled
             + ", area="      + String.format("%.2f", getArea())
             + ", perimeter=" + String.format("%.2f", getPerimeter())
             + "]";
    }
}
