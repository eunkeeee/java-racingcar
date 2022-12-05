package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Util;
import racingcar.util.validator.CarNamesValidator;
import racingcar.util.validator.NumberOfTrialsValidator;

public class InputView {
    public List<String> readCarNames() {
        System.out.println(ConsoleMessage.INPUT_CAR_NAMES.message);
        String input = Console.readLine();
        new CarNamesValidator().validate(input);
        return Arrays.asList(Util.removeSpace(input).split(","));
    }

    public int readNumberOfTrials() {
        System.out.println(ConsoleMessage.INPUT_TRIALS.message);
        String input = Console.readLine();
        new NumberOfTrialsValidator().validate(input);
        return Integer.parseInt(input);
    }

    private enum ConsoleMessage {
        INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"), INPUT_TRIALS("시도할 회수는 몇회인가요?");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }


}