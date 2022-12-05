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
        cars.stream().forEach(Car::move);
    }

    public String getWinners() {
        StringJoiner result = new StringJoiner(", ");
        List<Car> winners = findWinners();
        winners.stream().map(Car::getName).forEach(result::add);
        return result.toString();
    }

    private List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().getAsInt();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cars.stream().forEach(car -> result.append(car.getResult()));
        return result.toString();
    }
}
