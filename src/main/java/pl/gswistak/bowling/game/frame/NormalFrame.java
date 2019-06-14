package pl.gswistak.bowling.game.frame;

import java.util.ArrayList;

public class NormalFrame extends AbstractFrame {

    private static final int MAX_ROLLS_COUNT = 2;

    NormalFrame(int index) {
        super(new ArrayList<>(), index);
    }

    @Override
    public boolean isCompleted() {
        return getCurrentRollsCount() == getMaxRollsCount() || isStrike();
    }

    @Override
    public boolean isSpare() {
        return getKnockedPins() == MAX_PINS && getCurrentRollsCount() == getMaxRollsCount();
    }

    @Override
    public boolean isStrike() {
        return getKnockedPins() == MAX_PINS && getCurrentRollsCount() == STRIKE_ROLLS_COUNT;
    }

    @Override
    public int getMaxRollsCount() {
        return MAX_ROLLS_COUNT;
    }
}
