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

    public void printRegisterStation() {
        System.out.println(PREFIX + "지하철 역이 등록되었습니다.");
    }

    public void printDeleteStation() {
        System.out.println(PREFIX + "지하철 역이 삭제되었습니다.");
    }

}
