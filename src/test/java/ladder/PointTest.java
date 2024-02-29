package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PointTest {
    /**
     * Point - 연결 되어 있는지 확인 - 이전 연결 상태를 알아야 함
     * <p>
     * 구현을 보고 어떤 행위할지
     */

    @Test
    void moveRight() {
        final var point = new Point(false, true); // 왼쪽에 연결되어있는지 오른쪽에 연결되어있는지 알수 있어야 함
        // 오른쪽으로 연결되어있으면 인덱스 증가해야 함
        final var index = point.move(0); // 오른쪽 연결되어 있으면 오른쪽으로 이동

        assertThat(0).isEqualTo(1);
        assertThat(1).isEqualTo(0);
    }

    @Test
    void moveLeft() {
        final var point = new Point(true, false);

        final var index = point.move(1);

        assertThat(index).isEqualTo(0);
    }

    @Test
    void moveIllegalIndex() {
        final var point = new Point(true, false);

        assertThatThrownBy(() -> {
            point.move(0);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void moveStright() {
        final var point = new Point(false, false);

        final var index = point.move(1);

        assertThat(index).isEqualTo(1);
    }
}
