package ladder.exceptionMessage;

public enum ExceptionMessage {
    /*InputView*/
    EXCEPTION_DUPLICATED_NAME("이름은 중복될 수 없습니다."),
    EXCEPTION_INVALID_BIG_HEIGHT("사다리 높이가 너무 높습니다. 사다리 높이는 100 이하여야 합니다."),
    EXCEPTION_NOT_INTEGER("정수가 아닙니다."),

    /*Player*/
    EXCEPTION_INVALID_NAME_LENGTH("플레이어 이름은 1자 이상 5자 이하여야 합니다."),
    EXCEPTION_INVALID_NAME("사용할 수 없는 이름이 포함되어 있습니다."),

    /*Players*/
    EXCEPTION_INVALID_PLAYER_COUNT("플레이어 수는 2명 이상 26명 이하여야 합니다."),
    EXCEPTION_INVALID_PLAYER_NAME("존재하지 않는 플레이어 이름입니다."),

    /*Reward*/
    EXCEPTION_INVALID_REWARD_LENGTH("실행 결과 이름은 1자 이상 5자 이하여야 합니다."),

    /*Rewards*/
    EXCEPTION_INVALID_REWARD_COUNT("실행 결과 수는 플레이어 수와 일치해야 합니다."),

    /*Height*/
    EXCEPTION_INVALID_HEIGHT("사다리 높이는 2 이상 100 이하여야 합니다."),

    /*LadderGameController*/
    EXCEPTION_EXIT("비정상 작동으로 인해 게임을 종료합니다.");

    public final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}