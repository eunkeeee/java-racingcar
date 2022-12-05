package racingcar.controller;

import java.util.stream.IntStream;
import java.util.stream.Stream;
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
            Cars cars = Cars.by(inputView.readCarNames());
            moveCars(cars);
            printWinners(cars);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void moveCars(Cars cars) {
        int numberOfTrials = inputView.readNumberOfTrials();
        outputView.printResult();
        for (int trial = 0; trial < numberOfTrials; trial++) {
            moveCarsOnce(cars);
        }
    }

    private void moveCarsOnce(Cars cars) {
        cars.move();
        outputView.printMoving(cars);
    }

    private void printWinners(Cars cars) {
        outputView.printWinners(cars);
    }
}