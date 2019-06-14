package pl.gswistak.bowling.game.frame;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public abstract class AbstractFrame {

    static final int MAX_PINS = 10;
    static final int STRIKE_ROLLS_COUNT = 1;
    private List<Integer> rolls;
    private int index;

    public abstract boolean isCompleted();

    public abstract boolean isSpare();

    public abstract boolean isStrike();

    public abstract int getMaxRollsCount();

    int getCurrentRollsCount() {
        return rolls.size();
    }

    public int getKnockedPins() {
        return rolls.stream()
                .reduce(0, Integer::sum);
    }

    public void addRoll(int pins) {
        assert pins <= MAX_PINS;
        rolls.add(pins);
    }

    public int getBonusRollsCount() {
        if (this.isStrike()) {
            return 2;
        } else if (this.isSpare()) {
            return 1;
        } else {
            return 0;
        }
    }
}
