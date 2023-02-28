# java-line

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구 사항

- 사다리
  - [x] 사다리의 높이는 1에서 10 사이이다.
  - [x] 가로라인은 이어지면 안된다.
  - [x] 가로 줄의 최소 0개 최대 인원수의 절반이다. 
    - [x] 소수가 나올경우 내림처리 한다.
  - [x] 가로 줄의 길이(-)는 5개로 고정한다.
  - [X] 사다리를 생성한다.
  - [x] 사다리 게임을 진행한다.
- 유저
  - [x] 유저의 이름은 최소 한글자 최대 다섯글자 이다.
  - [x] 사람의 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 유저는 최소 2명에서 10명 사이이다.
  - [x] 이름이 공백으로만 이루어진 경우 예외 처리 한다.
- 사다리 게임
  - [x] 에러 발생시 발생 지점 부터 다시 입력을 받는다.
- 결과
  - [x] 게임 결과는 유저 수와 같은 숫자로 들어와야 한다.
    - 구분은 쉼표로 한다.
  - [x] all이 입력될 경우 모든 플레이어의 결과를 알려준다.
    - 결과 출력 후, 게임을 종료한다.
  - [x] 결과를 알고 싶은 유저가 실제 게임에 참여했는지 확인한다.
    - [x] 존재할 경우, 해당 플레이어의 게임 결과를 알려준다.
  - [x] 게임 결과는 1~5자리만 입력가능하다.
  - [x] 각각의 게임결과는 공백으로만 이루어져선 안된다.
