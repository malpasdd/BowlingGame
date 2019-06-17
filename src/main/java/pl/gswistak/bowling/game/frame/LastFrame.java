package pl.gswistak.bowling.game.frame;

import java.util.ArrayList;

public class LastFrame extends AbstractFrame {

    private static final int ROLLS_COUNT_WITHOUT_BONUS = 2;
    private static final int ROLLS_COUNT_WITH_BONUS = 3;

    public LastFrame(int index) {
        super(new ArrayList<>(), index);
    }

    @Override
    public boolean isCompleted() {
        return (isStrike() || isSpare()) && getCurrentRollsCount() == ROLLS_COUNT_WITH_BONUS
                || !(isStrike() || isSpare()) && getCurrentRollsCount() == ROLLS_COUNT_WITHOUT_BONUS;
    }

}
