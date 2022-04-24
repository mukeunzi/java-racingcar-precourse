package racingcar.domain;

import racingcar.util.RandomNumber;

public class GameRule {
    private static final int MIN_CRITERIA = 0;
    private static final int MAX_CRITERIA = 9;

    public int getRandomNumber() {
        return RandomNumber.generateNumberWithinRange(MIN_CRITERIA, MAX_CRITERIA);
    }
}
