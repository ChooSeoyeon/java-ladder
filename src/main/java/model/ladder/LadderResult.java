package model.ladder;

import java.util.List;
import model.player.Players;

public class LadderResult {
    private static final String INVALID_SIZE_OF_LADDER_RESULT_CONTENTS = "실행 결과 수는 참여자 수와 같아야 합니다.";

    private final List<LadderResultContent> contents;

    private LadderResult(List<LadderResultContent> contents) {
        this.contents = contents;
    }

    public static LadderResult of(Players players, List<LadderResultContent> contents) {
        validateSizeOfLadderResultContents(players, contents);
        return new LadderResult(contents);
    }

    private static void validateSizeOfLadderResultContents(Players players, List<LadderResultContent> contents) {
        if (players.getSize() != contents.size()) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_LADDER_RESULT_CONTENTS);
        }
    }
}