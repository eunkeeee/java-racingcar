package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars by(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getResult());
        }
        return result.toString();
    }
}
