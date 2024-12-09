package subway.domain;

import static subway.utils.exception.ErrorMessage.ALREADY_REGISTERED_STATION;
import static subway.utils.exception.ErrorMessage.DUPLICATE_LINE_NAME;
import static subway.utils.exception.ErrorMessage.MUST_BE_LONG_THAN_TWO;
import static subway.utils.exception.ErrorMessage.NOT_EXIST_STATION;
import static subway.utils.exception.ErrorMessage.STATIONS_MUST_BE_BIG_THAN_TWO;

import java.util.Collections;
import java.util.List;
import subway.utils.exception.SubwayException;

public class Line {
    private final String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        validateNameLength(name);
        validateDuplicateLineName(name);
        validateStationsSize(stations);
        this.name = name;
        this.stations = stations;
    }

    public void addStationWithPosition(Station station, int pos) {
        stations.add(pos, station);
    }

    public String getName() {
        return name;
    }

    public boolean checkRegistered(String name) {

        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Station findStationByName(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new SubwayException(NOT_EXIST_STATION);
    }

    public void deleteStation(String name) {
        validateStationsSize(stations);
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                stations.remove(station);
                return;
            }
        }
        throw new SubwayException(NOT_EXIST_STATION);
    }

    public void checkAlreadyRegistered(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                throw new SubwayException(ALREADY_REGISTERED_STATION);
            }
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new SubwayException(MUST_BE_LONG_THAN_TWO);
        }
    }

    private void validateDuplicateLineName(String name) {
        if (LineRepository.existLine(name)) {
            throw new SubwayException(DUPLICATE_LINE_NAME);
        }
    }

    private void validateStationsSize(List<Station> stations) {
        if (stations.size() < 2) {
            throw new SubwayException(STATIONS_MUST_BE_BIG_THAN_TWO);
        }
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
}
