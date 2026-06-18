public class ShapeDriver {

    public static void printAreas(Shape[] shapes) {
        System.out.println("=== Areas (dynamic binding) ===");
        for (Shape s : shapes) {
            System.out.printf("%-12s -> area = %.2f%n",
                s.getClass().getSimpleName(), s.getArea());
        }
    }

    //------------- (d) largest
    
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            throw new IllegalArgumentException("Array must not be empty.");
        }
        Shape best = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > best.getArea()) {
                best = shapes[i];
            }
        }
        return best;
    }

    // ----------------------- main
    public static void main(String[] args) {

        // ---- (c) Demonstrate catching InvalidShapeException ----
        System.out.println("=== Exception Demo ===");

        // Valid triangle – should succeed
        try {
            Triangle t = new Triangle(3, 4, 5);
            System.out.println("Valid triangle created: " + t);
        } catch (InvalidShapeException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        // Invalid triangle: sides 1, 2, 10 violate triangle inequality
        try {
            Triangle bad = new Triangle(1, 2, 10);   // 10 >= 1+2 → invalid
            System.out.println("Should not reach here: " + bad);
        } catch (InvalidShapeException e) {
            System.out.println("Caught InvalidShapeException: " + e.getMessage());
        }

        // Invalid circle
        try {
            Circle bad = new Circle(-5);
        } catch (InvalidShapeException e) {
            System.out.println("Caught InvalidShapeException: " + e.getMessage());
        }

        // Invalid resize factor
        try {
            Circle c = new Circle(3);
            c.resize(-2);
        } catch (InvalidShapeException e) {
            System.out.println("Caught InvalidShapeException: " + e.getMessage());
        }

        System.out.println();

        // ---- Build a valid array of shapes ----
        Shape[] shapes = {
            new Circle("red",   true,  5),
            new Rectangle("blue", false, 4, 6),
            new Triangle("green", true,  3, 4, 5)
        };

        // ---- (d) printAreas ----
        printAreas(shapes);
        System.out.println();

        // ---- (d) largest ----
        Shape big = largest(shapes);
        System.out.println("=== Largest shape ===");
        System.out.println(big);
        System.out.println();

        // ---- Demonstrate resize ----
        System.out.println("=== Resize Demo (factor 2) ===");
        Circle c = new Circle("red", true, 5);
        System.out.println("Before: " + c);
        c.resize(2);
        System.out.println("After : " + c);
        System.out.println();

        // ---- toString via superclass reference ----
        System.out.println("=== toString via superclass reference ===");
        for (Shape s : shapes) {
            System.out.println(s);   
        }
    }
}
