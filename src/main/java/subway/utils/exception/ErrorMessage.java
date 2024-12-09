package subway.utils.exception;

public enum ErrorMessage {

    NOT_EXIST_STATION("존재하지 않는 역입니다."),
    NOT_EXIST_LINE("존재하지 않는 노선입니다."),
    DUPLICATE_STATION_NAME("이미 존재하는 역입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
