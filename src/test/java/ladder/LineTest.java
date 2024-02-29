package ladder;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("Line 객체를 생성할 수 있다.")
    @Test
    void createLine() {
        Assertions.assertThatCode(() -> {
            new Line(true, false);
        }).doesNotThrowAnyException();
    }

    // 상태보다는 어떤 역할 가지는지부터 접근해보자.
    @DisplayName("발판이 있으면 이동한다.") // 이동한다로 변경할지 결정해야 함
    @Test
    void move() {
        final var line = Line.of(List.of(
                new Point(true), new Point(true).end()
        ));
        // 생성의 역할을 외부로 위임
        // 이 Point를 생성하는 개발자는 Point의 이해도가 높아야 한다

        final var index = line.move2(0);

        Assertions.assertThat(index).isEqualTo(1);
    }

    @DisplayName("발판이 없으면 이동하지 않는다.")
    @Test
    void notMove() {
        final var line = new Line(false);

        Assertions.assertThat(line.move(0)).isEqualTo(0);
    }

//    @DisplayName("여러 발판이 있을 때 움직인다.")
//    @Test
//    void moveMultiple() {
//        final var line = new Line(true, false, true, false);
//
//        assertAll(
//                () -> Assertions.assertThat(line.move(0)).isTrue(),
//                () -> Assertions.assertThat(line.move(1)).isFalse(),
//                () -> Assertions.assertThat(line.move(2)).isTrue(),
//                () -> Assertions.assertThat(line.move(3)).isFalse()
//        );
//    }

    @DisplayName("발판이 오른쪽으로 연결되어 있으면 오른쪽으로 이동한다.")
    @Test
    void moveConnected() {
        final var line = Line.of(List.of(
                new Point(true),
                new Point(true).next(false),
                new Point(true).next(false).next(true),
                new Point(true).next(false).next(true).end()
        ));

        assertAll(
                () -> Assertions.assertThat(line.move2(0)).isEqualTo(1),
                () -> Assertions.assertThat(line.move2(1)).isEqualTo(0),
                () -> Assertions.assertThat(line.move2(2)).isEqualTo(3),
                () -> Assertions.assertThat(line.move2(3)).isEqualTo(2)
        );
    }

    @DisplayName("여러 발판 중 특정 위치에 발판이 있으면 이동한다.")
    @Test
    void moveByIndex() {
//        final var line = Line.of(List.of(
//                new Point(false, true),
//                new Point(false, true),
//                new Point(false, true)
//        ));
//
//        Assertions.assertThat(line.move2(1)).isEqualTo(2);
    }

    @DisplayName("발판이 없으면 이동하지 않는다.")
    @Test
    void negativeIndex() {
//        assertThrows(new Line(false))
//                .
    }
}
