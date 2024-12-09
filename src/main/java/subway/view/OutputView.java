package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    private static final String PREFIX = "[INFO] ";

    public void printStations(List<Station> stations) {
        System.out.println("## 역 목록");
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

    public void printRegisterLine() {
        System.out.println(PREFIX + "지하철 노선이 등록되었습니다.");
    }

    public void printDeleteLine() {
        System.out.println(PREFIX + "지하철 노선이 삭제되었습니다.");
    }


    public void printLines(List<Line> lines) {
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.print(PREFIX);
            System.out.println(line.getName());
        }
    }

    public void printDeleteSection() {
        System.out.println(PREFIX + "구간이 삭제되었습니다.");
    }

    public void printRegisterSection() {
        System.out.println(PREFIX + "구간이 등록되었습니다.");
    }

    public void printSubwayRouteMap(List<Line> lines) {

        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            System.out.print(PREFIX);
            System.out.println(line.getName());
            System.out.print(PREFIX);
            System.out.println("--- ");

            for (Station station : line.stations()) {
                System.out.print(PREFIX);
                System.out.println(station.getName());
            }
            System.out.println();
        }
    }
}
