package teampearl.cvgenerator.back_end.presentation_layer.exceptions;

public class DateIsInFutureException extends RuntimeException {
    public DateIsInFutureException() {
        super("The input date can only be in the past or now. Not in the future.");
    }
}
