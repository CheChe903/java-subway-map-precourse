package subway.controller;

import static subway.utils.exception.ErrorMessage.KEY_ERROR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private final InputView inputView;
    private final OutputView outputView;

    public LineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void lineManaging() throws IOException {

        String lineManagementInput = inputView.lineManagementInput();

        if (lineManagementInput.equals("1")) {
            String lineName = inputView.lineRegisterInput();
            List<Station> stations = new ArrayList<>();
            stations.add(StationRepository.findStationByName(inputView.lineUpBoundTerminalInput()));
            stations.add(StationRepository.findStationByName(inputView.lineDownBoundTerminalInput()));
            Line line = new Line(lineName, stations);
            LineRepository.addLine(line);
            outputView.printRegisterLine();
            return;
        }
        if (lineManagementInput.equals("2")) {
            LineRepository.deleteLineByName(inputView.lineDeleteInput());
            outputView.printDeleteLine();
            return;
        }
        if (lineManagementInput.equals("3")) {
            outputView.printLines(LineRepository.lines());
            return;
        }
        if (lineManagementInput.equals("B")) {
            return;
        }
        
        throw new SubwayException(KEY_ERROR);

    }
}
