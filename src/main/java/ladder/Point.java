package ladder;

public class Point {
    enum Direction {
        LEFT,
        RIGHT,
        STRAIGHT;
    }

    private final boolean left;
    private final boolean right;
    private Direction direction;


    // 맨 처음은 왼쪽으로 연결될 일이 없다.
    // 다음 연결은 이전 연결의 오른쪽 연결이 있으면 왼쪽으로 연결된다.
    // 마ㅣ막 연결은 오른쪽으로 연결될 일이 없다.
    public Point(final boolean left, final boolean right) {
        if (right && left) {

        }
        this.left = left;
        this.right = right;
        if (left) {
            direction = Direction.LEFT;
        } else if (right) {
            direction = Direction.RIGHT;
        } else {
            direction = Direction.STRAIGHT;
        }
    }

    public Point(final boolean right) {  // 맨 처음은 왼쪽으로 연결될 일이 없다.
        this(false, right);
    }

    Point next(final boolean right) { // 다음 연결은 이전 연결의 오른쪽 연결이 있으면 왼쪽으로 연결된다.
        return new Point(this.right, right);
    }

    Point end() {  // 마ㅣ막 연결은 오른쪽으로 연결될 일이 없다.
        return new Point(this.right, false);
    }

    // TODO: index 분리
    public int move(final int index) {
        if (right) {
            return index + 1;
        }
        if (left) {
            if (index < 1) {
                throw new IllegalArgumentException("음수는 허용하지 않습니다.");
            }
            return index - 1;
        }
        return index;
    }

    public int move(final Index index) {
        if (right) {
            return index.increment().toInt();
        }
        if (left) {
            return index.decrement().toInt();
        }
        return index.toInt();
    }
}
