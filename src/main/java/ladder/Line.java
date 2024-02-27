package ladder;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    Line(final Boolean... points) {
        this(List.of(points));
    }

    Line(final List<Boolean> points) {
        if (points.get(points.size() - 1)) {
            throw new IllegalArgumentException("마지막 포인트는 연결되어 있을 수 없습니다.");
        }
        this.points = points;
    }

    int move(final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        if (points.get(index)) {
            return index + 1;
        }
        if (index > 0 && points.get(index - 1)) {
            return index - 1;
        }
        return index;
    }
}
