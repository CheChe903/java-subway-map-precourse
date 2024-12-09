package subway.domain;

import static subway.utils.exception.ErrorMessage.NOT_EXIST_STATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.exception.SubwayException;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean existStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Station findStationByName(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }

        throw new SubwayException(NOT_EXIST_STATION);
    }
}
