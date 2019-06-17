package pl.gswistak.bowling.game.frame;

import java.util.ArrayList;

public class NormalFrame extends AbstractFrame {

    private static final int MAX_ROLLS_COUNT = 2;

    NormalFrame(int index) {
        super(new ArrayList<>(), index);
    }

    @Override
    public boolean isCompleted() {
        return getCurrentRollsCount() == MAX_ROLLS_COUNT || isStrike();
    }

}
