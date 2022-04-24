package racingcar.message;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR]";
    public static final String RANGE_ERROR = String.format("%s 시도할 횟수에는 1~9만 입력할 수 있습니다.", ERROR_PREFIX);
}
