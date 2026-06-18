/**
 * Unchecked exception thrown when a shape receives an invalid dimension
 * or an invalid resize factor.
 *
 * WHY UNCHECKED (extends RuntimeException)?
 *   Invalid dimensions are programming errors – the caller passed a bad
 *   value (e.g. a negative radius). These are analogous to
 *   IllegalArgumentException and do NOT represent recoverable conditions
 *   that every caller must be forced to handle.  Making it checked would
 *   pollute every method signature with "throws InvalidShapeException"
 *   for no real safety benefit.  The Java convention (endorsed by
 *   Effective Java Item 70) is: use checked exceptions for recoverable
 *   conditions, unchecked for programming errors.
 */
public class InvalidShapeException extends RuntimeException {

    public InvalidShapeException(String message) {
        super(message);
    }
}
