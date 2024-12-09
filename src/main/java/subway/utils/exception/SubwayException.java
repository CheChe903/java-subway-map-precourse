package subway.utils.exception;

public class SubwayException extends IllegalArgumentException {

    public SubwayException(ErrorMessage message) {
        super(message.toString());
    }
}
