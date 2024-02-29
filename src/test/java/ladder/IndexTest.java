package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/*
*       if (right) {
            return index + 1;
        }
        *
        if (left) {
            if (index < 1) {
                throw new IllegalArgumentException("음수는 허용하지 않습니다.");
            }
            *
            return index - 1;
        }
* */
public class IndexTest {
    @Test
    void increment() {
        final var index = new Index();

        assertThat(index.increment()).isEqualTo(new Index(1));
    }

    @Test
    void decrement() {
        final var index = new Index(1);

        assertThat(index.decrement()).isEqualTo(new Index(0));
    }

    @Test
    void decrementIllegal() {
        final var index = new Index(0);

        assertThrows(IllegalStateException.class, () -> {
            index.decrement();
        });
    }
}
