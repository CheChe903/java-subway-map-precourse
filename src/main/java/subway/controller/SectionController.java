package subway.controller;

import static subway.utils.exception.ErrorMessage.KEY_ERROR;

import java.io.IOException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Converter;
import subway.utils.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private final InputView inputView;
    private final OutputView outputView;

    public SectionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void sectionManaging() throws IOException {
        String sectionManagementInput = inputView.sectionInput();
        if (sectionManagementInput.equals("1")) {
            String registerSectionOfLine = inputView.registerSectionOfLine();
            Line line = LineRepository.findLineByName(registerSectionOfLine);
            String registerSectionOfStation = inputView.registerSectionOfStation();
            line.checkAlreadyRegistered(registerSectionOfStation);
            Station station = StationRepository.findStationByName(registerSectionOfStation);
            int position = Converter.toInteger(inputView.registerSectionPosition());
            line.addStationWithPosition(station, position);

            outputView.printRegisterSection();
            return;
        }
        if (sectionManagementInput.equals("2")) {
            String deleteSectionOfLine = inputView.deleteSectionOfLine();
            String deleteSectionOfStation = inputView.deleteSectionOfStation();

            Line line = LineRepository.findLineByName(deleteSectionOfLine);

            Station station = line.findStationByName(deleteSectionOfStation);

            line.deleteStation(station.getName());

            outputView.printDeleteSection();
            return;
        }

        if (sectionManagementInput.equals("B")) {
            return;
        }

        throw new SubwayException(KEY_ERROR);
    }
}
