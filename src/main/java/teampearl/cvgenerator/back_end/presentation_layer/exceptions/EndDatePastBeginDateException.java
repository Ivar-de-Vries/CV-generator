package teampearl.cvgenerator.back_end.presentation_layer.exceptions;

public class EndDatePastBeginDateException extends RuntimeException{
    public EndDatePastBeginDateException() {
        super("The end date can't be before the begin date. That's impossible.");
    }
}
