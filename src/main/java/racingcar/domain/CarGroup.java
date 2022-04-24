package racingcar.domain;

import racingcar.exception.InvalidParameterError;
import racingcar.message.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarGroup {
    private final List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        validUnique(carGroup);
        this.carGroup = carGroup;
    }

    private void validUnique(List<Car> carGroup) {
        HashSet<String> carNames = new HashSet<>(getCarNames(carGroup));
        if (carGroup.size() == carNames.size()) {
            return;
        }

        throw new InvalidParameterError(ErrorMessage.CAR_NAME_DUPLICATED_ERROR);
    }

    private List<String> getCarNames(List<Car> carGroup) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carGroup) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
