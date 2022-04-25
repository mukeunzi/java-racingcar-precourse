package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.CarName;
import racingcar.domain.Round;
import racingcar.view.Input;
import racingcar.view.Print;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private CarGroup carGroup;
    private Round round;

    public void run() {
        initializeCarGroup();
        initializeRound();
        startGame();
    }

    private void startGame() {
        List<List<Car>> resultByRound = carGroup.playGame(round.getRound());
        System.out.println();
        Print.printResultByRound(resultByRound);
        Print.printWinner();
    }

    public void initializeCarGroup() {
        String inputCarNames = Input.inputCarNames();

        List<Car> carNames = new ArrayList<>();
        for (String carName : inputCarNames.trim().split(",")) {
            carNames.add(new Car(new CarName(carName.trim())));
        }
        this.carGroup = new CarGroup(carNames);
    }

    public void initializeRound() {
        String inputRound = Input.inputRound();
        this.round = new Round(inputRound);
    }
}
