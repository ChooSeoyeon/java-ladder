# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구사항

- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.

## 수업

### 서론

- 컨벤션 잘 못지킴
    - 정성의 문제
- 컨벤션 지키면 좋은 점
    - 리뷰 받을 때, 컨벤션 안 지키면 컨벤션 리뷰를 받게 됨
    - 컨벤션 지키면, 보다 양질의 리뷰를 받을 수 있음
      [양질의 코드리뷰를 받을 수 있는 문서]
      https://www.oracle.com/java/technologies/javase/codeconventions-fileorganization.html
    - https://google.github.io/styleguide/javaguide.html
        1. 클래스/인터페이스가 포함된 **문서 주석 및 설명** (Class/interface documentation comment)
        2. 클래스/인터페이스 선언부 (class or interface statement)
        3. 클래스/인터페이스에 대한 주석 및 설명 (Class/interface implementation comment, if necessary)
        4. 클래스 정적 변수 (Class `static` variables)
        5. 인스턴스 변수 (Instance variables)
        6. 생성자 (Constructors)
        7. 메서드 (Methods)

### 본론: 사다리 미션

- 사다리 미션 받으면 뭐부터 해야 하는가?
    - 요구사항 분석

- 가장 중요한 것
    - 사다리

- tdd로 구현하는 게 핵심이었음
    - 모든 것은 tdd로 구현한다

- 어디부터 시작했는가
    - 클래스 기능 설계? <- 어떤 클래스부터 시작?
    - 이름부터 생성

- 이름, 발판 같은 게 나오게 된 게 가장 작은 단위라서임
    - 또한, 내가 생각할 수 있는 객체라서임
    - 사다리가 핵심인데,이름은 중요한 게 아님
    - 이름부터 시작한 건 대부분

- 우선순위 높은 거부터 해보자
    - 발판부터 시작 -----

- 작은 단위의 객체 찾는 게 지금 규모에선 쉽지만
    - 비즈니스 로직 복잡해질 수록 작은 단위 객체 찾는 게 힘들어짐
    - 그러면, 어디서부터 시작해야 할까?

- 가장 작은 단위의 객체를 도출 못하겠다.
    - 그냥 큰 거부터?
    - 가장 큰 거부터 필요한게 뭔지 생각해보기

- 이해한 내용 코드로 작성해보자.

- LadderGameTest

```
package ladder;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
/*
0 -> 0
1 -> 3
2 -> 2
3 -> 1

    |-----|     |-----|
    |     |-----|     |
    |-----|     |     |
    |     |-----|     |
    |-----|     |-----|
     */
    @Test
    void name() {
        Assertions.assertThat(LadderGame.start(0)).isEqualTo(1);
        Assertions.assertThat(LadderGame.start(1)).isEqualTo(0);
        Assertions.assertThat(LadderGame.start(1)).isEqualTo(0);
        Assertions.assertThat(LadderGame.start(1)).isEqualTo(0);
    }

    public static class LadderGame {
        /*
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|

        |-----|     |-----| <- 객체로 분리할 수 있겠다. <- 역할을 가지고 있다. 책임을 가지고 있다.
        - 사다리의 인덱스를 받고, 연결이 되어 있으면 움직인다.

        |-----| or |     | <- 객체로 분리할 수 있겠다.
        - 각 포인트가 움직일 수 있는지 결정한다.
         */
        private static final List<List<Boolean>> value = List.of(
                List.of(true, false, true, false)
        );

        static int start(final int startIndex) {
            if (value.get(0).get(startIndex)) {
                return startIndex + 1;
            }
            if (value.get(0).get(startIndex - 1)) {
                return startIndex - 1;
            }
            return startIndex;
        }
    }
}
```

- 리팩토링 시 주의할 점
    - 언제든 어떤 일이 치고 들어올 지 모르기에
    - 작은 단위로 점진적으로 교체

- 이미 move2 메서드가 제대로 구현이 안되어 있는데, 나갈 순 없음
- 깃에 올린다 해도 제약이 크기에. stash 한 것들이 많이 쌓이기에

- 과도기적인 상태가 존재하는 채로 개선이 된다!

- 음수가 들어왔을 때, 간단하게 테스트 추가할 수 있을 거 같으니 테스트 추가해보자,.

## 수업 0229

- 접근 방식 : 우리는 Out In 방식으로 구현했음
    - Out -> In :  도메인 지식이 없거나 요구사항을 객체로 도출할 수 없는 경우 적합
    - In -> Out : 도메인 지식이 있거나 요구사항을 객체로 도출할 수 있는 경우 적합

- Out In 방식으로 구현한 방식 요약
    - Ladder를 생성하는 부분과 생성한 Ladder를 실행(사다리 타기)하는 부분을 분리
    - TDD 구현시 특정 상태를 분리해 시작하는 것이 중요
    - Ladder를 생성하는 부분은 무시하고, Ladder를 실행(설계에서 move)하는 부분에서 시작
    - 테스트하기 어려움. 바로 포기
    - 기존 코드를 삭제하고 Line move()에서 다시 시작
    - 도메인 지식을 쌓은 후 더 작은 단위로 분리할 객체는 없을까?

- 애플리케이션 개발 단계에서 Out -> In, In -> Out 방식 중 하나만 사용되지 않는다.
  두 방식이 핑퐁처럼 주고 받으며 개발이 진행된다.
    - 매몰되지 말자. 디자인패턴처럼.
    - 망치 들면 다 못으로 보인다
    - 상황에 따라서 유연하게 선택하기

- Out In 으로 시작할 땐
    - 설계할 수 있는 부분까지 설계
    - 가장 마지막 노드(의존성을 가지는 객체가 하나도 없는 객체)부터 구현을 시작하는 것이 목적이었음
    - 더 이상 객체를 분리할 수 없는 가장 작은 단계까지 객체를 분리한 후 In -> Out 방식으로 구현
    - 페어가 동의해주면 힘이 생긴다

- 답해보기는 미션 끝나고 봐보기

- 원시값 어디까지 알아야 할까? 네오는 Line은 인덱스 알아야 한다 생각함

private Function<Index, Index> function;

// LadderGame이 우승상품과 참여자 받아서 매핑해줌
