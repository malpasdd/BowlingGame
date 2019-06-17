package pl.gswistak.bowling.game.frame;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public abstract class AbstractFrame {

    private static final int MAX_PINS = 10;
    private static final int FIRST_ROLL_INDEX = 0;
    private static final int SECOND_ROLL_INDEX = 1;
    private List<Integer> rolls;
    private int index;

    public abstract boolean isCompleted();

    public boolean isSpare() {
        int firstRollScore = getFirstRollScore();
        int secondRollScore = getSecondRollScore();
        return !isStrike() && firstRollScore + secondRollScore == MAX_PINS;

    }

    public boolean isStrike() {
        return getFirstRollScore() == MAX_PINS;
    }

    int getCurrentRollsCount() {
        return rolls.size();
    }

    public int getKnockedPins() {
        return rolls.stream()
                .reduce(0, Integer::sum);
    }

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    private int getFirstRollScore() {
        return getRollScore(FIRST_ROLL_INDEX);
    }

    private int getSecondRollScore() {
        return getRollScore(SECOND_ROLL_INDEX);
    }

    private int getRollScore(int rollIndex) {
        return rollIndex < rolls.size() ? rolls.get(rollIndex) : 0;
    }
}
