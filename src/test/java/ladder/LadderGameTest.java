package ladder;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    /*
    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
    */
    @Test
    void name() {
        final var ladderGame = new LadderGame(List.of(
                new Line(true, false, true, false),
                new Line(false, true, false, false),
                new Line(true, false, false, false),
                new Line(false, true, false, false),
                new Line(true, false, true, false)
        ));

        Assertions.assertThat(ladderGame.climb(0)).isEqualTo(0);
        Assertions.assertThat(ladderGame.climb(1)).isEqualTo(3);
        Assertions.assertThat(ladderGame.climb(2)).isEqualTo(2);
        Assertions.assertThat(ladderGame.climb(3)).isEqualTo(1);
    }

    // 원시값 포장해보기 <- 역할을 나눈다
    // boolean 값으로 상태가 있는게 왠지 불안
    // 마지막으로 false가 오지 않아도 구현되게 해보기
    //

    class LadderGame {
        private final List<Line> lines;

        public LadderGame(List<Line> lines) {
            this.lines = lines;
        }

        int climb(final int startIndex) {
            int index = startIndex;
            for (final Line line : lines) {
                index = line.move(index);
            }
            return index;
        }
    }
}
