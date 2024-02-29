package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points;
    private List<Point> points2; // 제네릭은 컴파일타임에 지어져서 구분 못함

    Line(final Boolean... points) {
        this(List.of(points));
    }

    Line(final List<Boolean> points) {
        if (points.size() > 0 && points.get(points.size() - 1)) {
            throw new IllegalArgumentException("마지막 포인트는 연결되어 있을 수 없습니다.");
        }
        this.points = points;
    }

    public static Line ofPoint(final List<Point> points) {
        var line = new Line();
        line.points2 = points;
        return line;
    }

    public static Line of(final List<Boolean> points) {
        var line = new Line();
        line.points2 = new ArrayList<>();
        line.points2.add(new Point(points.get(0)));
        for (int i = 1; i < points.size() - 1; i++) {
            final var prev = line.points2.get(i - 1);
            prev.next(points.get(i));
            line.points2.add(prev.next(points.get(i)));
        }
        line.points2.add(line.points2.get(line.points2.size() - 1).end());
        return line;
    }

    /**
     * 역할, 의미 인덱스에 대한 역할과 포인트 움직이는 역할 나눌 수 있을 거 같음 의미 명확하지 않단 건 포인트가 사다리에서 여러 가지 검증 하고 있는데, (이전 포인트와 현재 포인트 알아야 함) 포인트를
     * 분리해보자 포인트란건 어떤 역할과 의미 가져야 할까? Point - 연결 되어 있느지 확인 - 이전 연결 상태를 알아야 함
     */
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

    int move2(final int index) {
        return points2.get(index).move(index);
    }
}
