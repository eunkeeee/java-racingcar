package racingcar.view;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printResult() {
        System.out.println(ConsoleMessage.OUTPUT_RESULT.message);
    }

    public void printMoving(Cars cars) {
        System.out.println(joinResults(cars));
    }

    private String joinResults(Cars cars) {
        return cars.getCars().stream().map(this::formatResult).collect(Collectors.joining());
    }

    private String formatResult(Car car) {
        return String.format(ConsoleMessage.OUTPUT_MOVING.message, car.getName(),
                getPositionDisplay(car.getPosition()));
    }

    private String getPositionDisplay(int position) {
        return IntStream.rangeClosed(1, position).mapToObj(element -> "-").collect(Collectors.joining());
    }

    public void printWinners(Cars cars) {
        System.out.println(String.format(ConsoleMessage.OUTPUT_FINAL_WINNER.message, cars.getWinners()));
    }

    private enum ConsoleMessage {
        OUTPUT_RESULT("실행 결과"),
        OUTPUT_MOVING("%s : %s%n"),
        OUTPUT_FINAL_WINNER("최종 우승자 : %s");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }
}
