package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameRule 클래스 테스트 시작")
public class GameRuleTest {
    @Test
    @DisplayName("0~9사이의 랜덤 숫자를 생성했으면 성공")
    public void checkRandomNumber() {
        GameRule gameRule = new GameRule();
        assertThat(gameRule.getRandomNumber()).isGreaterThanOrEqualTo(0);
        assertThat(gameRule.getRandomNumber()).isLessThanOrEqualTo(9);
    }
}
