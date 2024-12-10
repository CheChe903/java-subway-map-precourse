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

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;


    public SubwayController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeSubway();
    }

    public void run() throws IOException {
        StationController stationController = new StationController(inputView, outputView);
        LineController lineController = new LineController(inputView, outputView);
        SectionController sectionController = new SectionController(inputView, outputView);
        try {
            String mainInput = inputView.mainInput();

            if (mainInput.equals("1")) {
                stationController.stationManaging();
                run();
            }
            if (mainInput.equals("2")) {
                lineController.lineManaging();
                run();
            }
            if (mainInput.equals("3")) {
                sectionController.sectionManaging();
                run();
            }
            if (mainInput.equals("4")) {
                outputView.printSubwayRouteMap(LineRepository.lines());
                run();
            }

            if (mainInput.equals("Q")) {
                return;
            }
            throw new SubwayException(KEY_ERROR);
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

        initialLineTwo();
        initialLineThree();
        initialLineShinbundangLine();
    }

    private void initialLineTwo() {
        List<Station> stations = new ArrayList<>();
        stations.add(StationRepository.findStationByName("교대역"));
        stations.add(StationRepository.findStationByName("강남역"));
        stations.add(StationRepository.findStationByName("역삼역"));
        LineRepository.addLine(new Line("2호선", stations));
    }

    private void initialLineThree() {
        List<Station> stations = new ArrayList<>();
        stations.add(StationRepository.findStationByName("교대역"));
        stations.add(StationRepository.findStationByName("남부터미널역"));
        stations.add(StationRepository.findStationByName("양재역"));
        stations.add(StationRepository.findStationByName("매봉역"));
        LineRepository.addLine(new Line("3호선", stations));
    }

    private void initialLineShinbundangLine() {
        List<Station> stations = new ArrayList<>();
        stations.add(StationRepository.findStationByName("강남역"));
        stations.add(StationRepository.findStationByName("양재역"));
        stations.add(StationRepository.findStationByName("양재시민의숲역"));
        LineRepository.addLine(new Line("신분당선", stations));

    }
}
