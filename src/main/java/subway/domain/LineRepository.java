package subway.domain;

import static subway.utils.exception.ErrorMessage.NOT_EXIST_LINE;
import static subway.utils.exception.ErrorMessage.REGISTERED_STATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.utils.exception.SubwayException;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLineByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }

        throw new SubwayException(NOT_EXIST_LINE);
    }

    public static void checkRegistered(String name) {
        for (Line line : lines) {
            if (line.checkRegistered(name)) {
                throw new SubwayException(REGISTERED_STATION);
            }
        }
    }
}
