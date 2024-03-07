package controller.exceptions;

public class OptionNotExistsException extends RuntimeException {
    public OptionNotExistsException(String message) {
        super(message);
    }
}
