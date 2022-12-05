package racingcar.util.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.util.ExceptionMessage;
import racingcar.util.Util;

public class CarNamesValidator extends Validator {

    private enum Constants {
        CAR_NAME_LENGTH(6), MIN_NUMBER_OF_CARS(2);

        private final int value;

        Constants(int value) {
            this.value = value;
        }
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> carNames = Arrays.asList(Util.removeSpace(input).split(","));
        validateNumberOfCars(carNames);
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() >= Constants.CAR_NAME_LENGTH.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateNumberOfCars(List<String> carNames) {
        if (carNames.size() < Constants.MIN_NUMBER_OF_CARS.value) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
        }
    }
}
