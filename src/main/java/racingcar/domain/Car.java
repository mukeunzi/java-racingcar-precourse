package racingcar.domain;

public class Car {
    private final CarName name;
    private final int distance;

    public Car(CarName name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return distance;
    }
}
