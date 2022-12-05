package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.validator.CarNameValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_TRIALS("시도할 회수는 몇회인가요?");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public List<String> readCarNames() {
        System.out.println(ConsoleMessage.INPUT_CAR_NAMES.message);
        String input = Console.readLine();
        new CarNameValidator().validate(input);
        return Arrays.asList(input.split(","));
    }
}