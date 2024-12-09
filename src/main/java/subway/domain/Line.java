package subway.domain;

import static subway.utils.exception.ErrorMessage.DUPLICATE_LINE_NAME;
import static subway.utils.exception.ErrorMessage.MUST_BE_LONG_THAN_TWO;
import static subway.utils.exception.ErrorMessage.NOT_EXIST_STATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.exception.SubwayException;

public class Line {
    private String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        validateNameLength(name);
        validateDuplicateName(name);
        this.name = name;
    }

    public void addStation(Station station) {
        stations.add(station);
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
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }


    private void validateNameLength(String name) {
        if (name.length() < 2) {
            throw new SubwayException(MUST_BE_LONG_THAN_TWO);
        }
    }

    private void validateDuplicateName(String name) {
        if (LineRepository.existLine(name)) {
            throw new SubwayException(DUPLICATE_LINE_NAME);
        }
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
}
