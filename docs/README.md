## 기능 요구사항

### UI

- 입력 
  - [x] 참여할 사람 이름 입력 문구
  - [x] 최대 사다리 높이 입력 문구
- 출력
  - [x] `실행 결과` 출력
  - [x] 참여자 목록 출력
  - [x] 사다리 게임 결과 출력

### 기능
- **플레이어**
- [x] 플레이어의 이름을 최소 1자, 최대 5자까지 입력받을 수 있다.
- [x] 플레이어는 최소 2명 이상 참여해야 한다.


- **사다리**
- [x] 사다리 높이 입력을 통해 사다리를 생성한다.
  - [x] 사다리 발판을 랜덤으로 생성한다.
  - [x] 만약 만드려는 사다리 발판의 왼쪽에 발판이 있는 경우 해당 위치의 발판은 만들지 않는다.

### 예외 사항
- **플레이어**
- [x] 플레이어 이름이 1자 미만이거나 5자 초과이면 예외가 발생한다.
- [x] 플레이어 수가 1명 이하인 경우 예외가 발생한다.


- **사다리**
- [x] 사다리의 높이가 `(플레이어 수) - 1`이상이 아닌 경우 예외가 발생한다.


---

### 1단계 변경사항
- [x] 내려가기 규칙에 의해 메소드 선언 순서 조정
- [x] 추상화 수준에 맞게 메소드 분리(#Players)
- [x] 랜덤 값을 위한 플래그로만 사용되던 필드 제거(#Block) 
  - [x] 매번 Block 객체가 생성되지 않도록 Block 캐싱(#RandomBlockGenerator)
- [x] 변수 및 상수 선언 시 modifier 순서 컨벤션에 맞도록 조정
- [x] Line, Ladder 객체가 스스로 상태를 관리하도록 변경

### 1단계 고민사항
- [ ] Block의 status 필드가 랜덤 값만을 위한 필드였기에 제거했는데, <br>
  따라서 ***랜덤하게 Block을 가져오려면*** Blocks.values() 에서 가져와야 했음. <br>
  매번 Blocks.values()로 접근할 바에, RandomBlockGenerator에 캐싱함! 괜찮은 방법인가? <br>
<br>
- [ ] 서브웨이가 말해주신 것처럼, 시스템이 핵심 ***도메인 로직 - Maker 로직*** 으로 분리되어 있다. <br>
  즉, 사다리 게임의 규칙을 어기는 Line, Ladder가 언제든지 탄생할 수 있다는 점도 문제이고, 핵심 도메인 객체가 <br>
  스스로 상태를 관리하지 못하는 것도 문제이다. 그러면 Builder 안의 로직을 Line, Ladder 안으로 옮기면 안되나? <br>
  왜 난 Builder를 만들었을까 생각해보니, 랜덤이 포함되어 있기 때문이다. 랜덤을 핵심 도메인 객체가 다뤄서는 테스트가 어렵고 <br>
  결국 랜덤 값을 외부에서 주입받는 형태가 되어야 하는데 .. 핵심 도메인 객체가 프로퍼티나 파라미터로 BlockGenerator를 받는 것도 <br>
  이상한 구조가 아닐까? <br>
<br>


  