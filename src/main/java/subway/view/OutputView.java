package subway.view;

import java.util.List;
import subway.domain.Station;

public class OutputView {
    private static final String PREFIX = "[INFO] ";

    public void printStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.print(PREFIX);
            System.out.println(station.getName());
        }
    }

}
