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
            int numberOfTrials = inputView.readNumberOfTrials();

            Cars cars = Cars.by(carNames);

            outputView.printResult();
            for (int trial = 0; trial < numberOfTrials; trial++) {
                cars.move();
                outputView.printMoving(cars);
            }


        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}