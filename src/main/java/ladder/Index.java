package ladder;

import java.util.Objects;

public class Index {
    private final int value;

    Index() {
        this(0);
    }

    public Index(final int value) {
        this.value = value;
    }

    public Index increment() {
        return new Index(1);
    }

    public Index decrement() {
        if (value < 1) {
            throw new IllegalStateException("");
        }
        return new Index(value - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Index index = (Index) o;
        return value == index.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int toInt() {
        return value;
    }
}
