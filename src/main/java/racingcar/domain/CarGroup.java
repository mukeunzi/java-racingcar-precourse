package racingcar.domain;

import racingcar.exception.InvalidParameterError;
import racingcar.message.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarGroup {
    private final List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        validUnique();
        this.carGroup = carGroup;
    }

    private void validUnique() {
        HashSet<String> carNames = new HashSet<>(getCarNames());
        if (this.carGroup.size() == carNames.size()) {
            return;
        }

        throw new InvalidParameterError(ErrorMessage.CAR_NAME_DUPLICATED_ERROR);
    }

    private List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : carGroup) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
