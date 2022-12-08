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
        if (isMoveForward()) {
            this.position++;
        }
    }

    private boolean isMoveForward() {
        return generateRandomNumber() >= Constants.BOUNDARY_VALUE.value;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_RANGE.value, Constants.MAX_RANGE.value);
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
