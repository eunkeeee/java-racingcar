package racingcar.model;

import java.util.List;
import java.util.StringJoiner;
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

    public String getWinners() {
        StringJoiner result = new StringJoiner(", ");
        int maxValue = cars.stream().mapToInt(car -> car.getPosition()).max().getAsInt();
        System.out.println("MAX VALUE: " + maxValue);
        List<Car> winners = cars.stream().filter(car -> car.getPosition() == maxValue).collect(Collectors.toList());
        winners.stream().map(car -> car.getName()).forEach(result::add);
        return result.toString();
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
