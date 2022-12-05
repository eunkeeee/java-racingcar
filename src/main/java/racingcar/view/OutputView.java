package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private enum ConsoleMessage {
        OUTPUT_RESULT("실행 결과"),
        OUTPUT_FINAL_WINNER("최종 우승자 : ");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printResult(){
        System.out.println(ConsoleMessage.OUTPUT_RESULT.message);
    }
    public void printMoving(Cars cars){
        System.out.println(cars);
    }
}
