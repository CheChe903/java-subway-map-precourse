package subway.utils.exception;

public enum ErrorMessage {

    NOT_EXIST_STATION("존재하지 않는 역입니다."),
    NOT_EXIST_LINE("존재하지 않는 노선입니다."),
    DUPLICATE_STATION_NAME("이미 존재하는 역입니다."),
    REGISTERED_STATION("노선에 등록된 역입니다."),
    MUST_BE_LONG_THAN_TWO("역 이름은 2보다 길어야 합니다."),
    DUPLICATE_LINE_NAME("이미 존재하는 노선입니다."),
    STATIONS_MUST_BE_BIG_THAN_TWO("노선을 만들기 위해서는 역이 두개 이상이여야 합니다."),
    ALREADY_REGISTERED_STATION("이미 등록된 역입니다.");

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
