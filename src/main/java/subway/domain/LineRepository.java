package subway.domain;

import static subway.utils.exception.ErrorMessage.NOT_EXIST_LINE;
import static subway.utils.exception.ErrorMessage.REGISTERED_STATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.utils.exception.SubwayException;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                lines.remove(line);
                return;
            }
        }
        throw new SubwayException(NOT_EXIST_LINE);
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

        boolean registered = false;
        for (Line line : lines) {
            if (line.checkRegistered(name)) {
                registered = true;
            }
        }

        if (registered) {
            throw new SubwayException(REGISTERED_STATION);
        }
    }

    public static boolean existLine(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

