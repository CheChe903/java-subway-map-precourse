package subway.controller;

import java.io.IOException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Converter;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;


    public SubwayController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IOException {
        initializeSubway();
        int mainInput = Converter.toInteger(inputView.mainInput());

        if (mainInput == 1) {
            int stationManagementInput = Converter.toInteger(inputView.stationManagementInput());

            if (stationManagementInput == 1) {
                StationRepository.addStation(new Station(inputView.input()));
            }

            if (stationManagementInput == 2) {
                String deleteStationName = inputView.input();
                LineRepository.checkRegistered(deleteStationName);
                StationRepository.deleteStation(deleteStationName);
            }
        }
    }

    private void initializeSubway() {
        String[] stations = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }

        String[] lines = {"2호선", "3호선", "신분당선"};

        for (String line : lines) {
            LineRepository.addLine(new Line(line));
        }
        initialLineTwo();
        initialLineThree();
        initialLineShinbundangLine();
    }

    private void initialLineTwo() {
        Line line = LineRepository.findLineByName("2호선");
        line.addStation(StationRepository.findStationByName("교대역"));
        line.addStation(StationRepository.findStationByName("강남역"));
        line.addStation(StationRepository.findStationByName("역삼역"));
    }

    private void initialLineThree() {
        Line line = LineRepository.findLineByName("3호선");
        line.addStation(StationRepository.findStationByName("교대역"));
        line.addStation(StationRepository.findStationByName("남부터미널역"));
        line.addStation(StationRepository.findStationByName("양재역"));
        line.addStation(StationRepository.findStationByName("매봉역"));
    }

    private void initialLineShinbundangLine() {
        Line line = LineRepository.findLineByName("신분당선");
        line.addStation(StationRepository.findStationByName("강남역"));
        line.addStation(StationRepository.findStationByName("양재역"));
        line.addStation(StationRepository.findStationByName("양재시민숲역"));
    }
}
