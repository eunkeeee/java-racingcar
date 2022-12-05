package racingcar.util.validator;

import java.util.regex.Pattern;
import racingcar.util.ExceptionMessage;
import racingcar.util.Util;

public class NumberOfTrialsValidator extends Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    @Override
    public void validate(String input) throws IllegalArgumentException {
        String numberOfTrials = Util.removeSpace(input);
        validateNumeric(numberOfTrials);
        validateRange(numberOfTrials);
    }

    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_OUT_OF_INT_RANGE.getMessage(), exception);
        }
    }
}
