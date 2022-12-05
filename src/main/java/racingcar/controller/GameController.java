package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {

            List<String> carNames = new ArrayList<>(inputView.readCarNames());
            System.out.println(carNames);

            int numberOfTrials = inputView.readNumberOfTrials();
            System.out.println(numberOfTrials);

            Cars cars =  Cars.by(carNames);

        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}