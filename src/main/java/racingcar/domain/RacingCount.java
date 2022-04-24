package racingcar.domain;

import racingcar.exception.InvalidParameterError;
import racingcar.message.ErrorMessage;

public class RacingCount {
    private final int racingCount;

    public RacingCount(String inputRacingCount) {
        validateRangeOfNumber(inputRacingCount);
        this.racingCount = Integer.parseInt(inputRacingCount);
    }

    private void validateRangeOfNumber(String inputRacingCount) {
        final String NUMBER_VALID_REGEX = "^[1-9]+$";
        if (inputRacingCount.matches(NUMBER_VALID_REGEX)) {
            return;
        }

        throw new InvalidParameterError(ErrorMessage.RANGE_ERROR);
    }

    public int getRacingCount() {
        return this.racingCount;
    }
}
