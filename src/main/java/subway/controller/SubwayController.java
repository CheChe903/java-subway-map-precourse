package subway.controller;

import java.io.IOException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Converter;
import subway.utils.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;


    public SubwayController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeSubway();
    }

    public void run() throws IOException {
        try {
            int mainInput = Converter.toInteger(inputView.mainInput());

            if (mainInput == 1) {

                String stationManagementInput = inputView.stationManagementInput();

                if (stationManagementInput.equals("1")) {
                    StationRepository.addStation(new Station(inputView.stationRegisterInput()));
                    outputView.printRegisterStation();
                    run();
                }

                if (stationManagementInput.equals("2")) {
                    String deleteStationName = inputView.stationDeleteInput();
                    LineRepository.checkRegistered(deleteStationName);
                    StationRepository.deleteStation(deleteStationName);
                    outputView.printDeleteStation();
                    run();
                }
                if (stationManagementInput.equals("3")) {
                    outputView.printStations(StationRepository.stations());
                    run();
                }

                if (stationManagementInput.equals("B")) {
                    run();
                }
            }
            if (mainInput == 2) {
                String lineManagementInput = inputView.lineManagementInput();

                if (lineManagementInput.equals("1")) {
                    String lineName = inputView.lineRegisterInput();
                    LineRepository.addLine(new Line(lineName));

                    Line line = LineRepository.findLineByName(lineName);

                    line.addStation(new Station(inputView.lineUpBoundTerminalInput()));
                    line.addStation(new Station(inputView.lineDownBoundTerminalInput()));

                    outputView.printRegisterLine();
                    run();
                }

                if (lineManagementInput.equals("2")) {
                    LineRepository.deleteLineByName(inputView.lineDeleteInput());
                    outputView.printDeleteLine();
                    run();
                }

                if (lineManagementInput.equals("3")) {
                    outputView.printLines(LineRepository.lines());
                    run();
                }

                if (lineManagementInput.equals("B")) {
                    run();
                }

            }

            if (mainInput == 3) {
                String sectionManagement = inputView.sectionInput();

                if (sectionManagement.equals("1")) {
                    String registerSectionOfLine = inputView.registerSectionOfLine();
                    String registerSectionOfStation = inputView.registerSectionOfStation();
                    Line line = LineRepository.findLineByName(registerSectionOfLine);
                    Station station = line.findStationByName(registerSectionOfStation);

                    line.addStation(station);

                    outputView.printRegisterSection();
                    run();
                }

                if (sectionManagement.equals("2")) {
                    String deleteSectionOfLine = inputView.deleteSectionOfLine();
                    String deleteSectionOfStation = inputView.deleteSectionOfStation();

                    Line line = LineRepository.findLineByName(deleteSectionOfLine);

                    Station station = line.findStationByName(deleteSectionOfStation);

                    line.deleteStation(station.getName());

                    outputView.printDeleteSection();
                    run();
                }

                if (sectionManagement.equals("B")) {
                    run();
                }
            }

            if (mainInput == 4) {
                outputView.printSubwayRouteMap(LineRepository.lines());
                run();
            }
        } catch (SubwayException e) {
            System.out.println(e.getMessage());
            run();
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
        line.addStation(StationRepository.findStationByName("양재시민의숲역"));
    }
}
