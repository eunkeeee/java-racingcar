package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private enum Constants {
        MIN_RANGE(0), MAX_RANGE(9), BOUNDARY_VALUE(4);

        private final int value;

        Constants(int value) {
            this.value = value;
        }
    }

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(Constants.MIN_RANGE.value, Constants.MAX_RANGE.value);
        if (randomNumber >= Constants.BOUNDARY_VALUE.value) {
            this.position++;
        }
    }

    public String getResult() {
        return String.format("%s : %s%n", name, getPositionDisplay());
    }

    private StringBuilder getPositionDisplay() {
        StringBuilder positionDisplay = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionDisplay.append("-");
        }
        return positionDisplay;
    }
}
