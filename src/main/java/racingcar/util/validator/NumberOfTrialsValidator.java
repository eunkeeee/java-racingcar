package racingcar.util.validator;

import racingcar.util.Util;

public class NumberOfTrialsValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        String numberOfTrials = Util.removeSpace(input);
        validateNumeric(numberOfTrials);
        validateRange(numberOfTrials);
    }
}
