package pl.gswistak.bowling.game.frame;

import java.util.ArrayList;

public class LastFrame extends AbstractFrame {

    private static final int MAX_ROLLS_COUNT = 3;

    LastFrame(int index) {
        super(new ArrayList<>(), index);
    }

    @Override
    public boolean isCompleted() {
        return getCurrentRollsCount() == getMaxRollsCount();
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public int getMaxRollsCount() {
        return MAX_ROLLS_COUNT;
    }
}
