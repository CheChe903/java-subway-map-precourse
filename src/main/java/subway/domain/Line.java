package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name) {
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
}
