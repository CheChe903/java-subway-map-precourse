package subway.controller;

import static subway.utils.exception.ErrorMessage.KEY_ERROR;

import java.io.IOException;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {

    private final InputView inputView;
    private final OutputView outputView;

    public StationController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void stationManaging() throws IOException {
        String stationManagementInput = inputView.stationManagementInput();
        if (stationManagementInput.equals("1")) {
            StationRepository.addStation(new Station(inputView.stationRegisterInput()));
            outputView.printRegisterStation();
            return;
        }
        if (stationManagementInput.equals("2")) {
            String deleteStationName = inputView.stationDeleteInput();
            LineRepository.checkRegistered(deleteStationName);
            StationRepository.deleteStation(deleteStationName);
            outputView.printDeleteStation();
            return;
        }
        if (stationManagementInput.equals("3")) {
            outputView.printStations(StationRepository.stations());
            return;
        }

        if (stationManagementInput.equals("B")) {
            return;
        }

        throw new SubwayException(KEY_ERROR);

    }
}
