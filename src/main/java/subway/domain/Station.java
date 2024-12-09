package subway.domain;

import static subway.utils.exception.ErrorMessage.DUPLICATE_STATION_NAME;

import subway.utils.exception.SubwayException;

public class Station {
    private String name;

    public Station(String name) {
        validateDuplicateStationName(name);
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
}
