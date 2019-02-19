package equation.parser.exception;

public class EquationWithoutOperatorException extends RuntimeException {
    public EquationWithoutOperatorException(String message) {
        super(message);
    }
}
