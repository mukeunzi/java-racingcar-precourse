package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingCount 클래스 테스트 시작")
public class RacingCountTest {
    @Test
    @DisplayName("racingCount을 문자열로 생성할 경우 오류 발생")
    public void checkRacingCountType() {
        assertThatThrownBy(() -> {
            new RacingCount("a");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 시도할 횟수에는 1~9만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("racingCount을 0으로 생성할 경우 오류 발생")
    public void checkRacingCountZero() {
        assertThatThrownBy(() -> {
            new RacingCount("0");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 시도할 횟수에는 1~9만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("racingCount을 2로 생성할 경우 통과")
    public void checkRacingCount() {
        assertThat(new RacingCount("2").getRacingCount()).isEqualTo(2);
    }
}
