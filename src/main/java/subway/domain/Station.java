package subway.domain;

import static subway.utils.exception.ErrorMessage.DUPLICATE_STATION_NAME;
import static subway.utils.exception.ErrorMessage.MUST_BE_LONG_THAN_TWO;

import subway.utils.exception.SubwayException;

public class Station {
    private String name;

    public Station(String name) {
        validateDuplicateStationName(name);
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateDuplicateStationName(String name) {
        if (StationRepository.existStation(name)) {
            throw new SubwayException(DUPLICATE_STATION_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new SubwayException(MUST_BE_LONG_THAN_TWO);
        }
    }
}
