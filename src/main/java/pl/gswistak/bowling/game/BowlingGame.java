package pl.gswistak.bowling.game;

import pl.gswistak.bowling.game.frame.AbstractFrame;
import pl.gswistak.bowling.game.frame.FrameListFactory;
import pl.gswistak.bowling.game.frame.LastFrame;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BowlingGame {

    private final List<AbstractFrame> frames;

    public BowlingGame() {
        FrameListFactory frameListFactory = new FrameListFactory();
        this.frames = frameListFactory.createFramesList();
    }

    public void roll(int pins) {
        AbstractFrame firstNotCompleted = findFirstNotCompleted();
        firstNotCompleted.addRoll(pins);
    }

    public int calculateScore() {
        return frames.stream()
                .filter(AbstractFrame::isCompleted)
                .map(this::calculateFrameScore)
                .reduce(0, Integer::sum);
    }

    private int calculateFrameScore(AbstractFrame frame) {
        int bonusRollsCount = getBonusRollsCount(frame);
        return isFrameHaveBonus(bonusRollsCount)
                ? getFrameScoreWithBonus(frame, bonusRollsCount)
                : frame.getKnockedPins();
    }

    private int getFrameScoreWithBonus(AbstractFrame frame, int bonusRollsCount) {
        List<Integer> limit = frames.stream()
                .filter(f -> f.getIndex() > frame.getIndex())
                .map(AbstractFrame::getRolls)
                .flatMap(Collection::stream)
                .limit(bonusRollsCount)
                .collect(Collectors.toList());

        return limit.size() == bonusRollsCount
                ? frame.getKnockedPins() + limit.stream().reduce(0, Integer::sum)
                : 0;
    }

    private boolean isFrameHaveBonus(int bonusRollsCount) {
        return bonusRollsCount != 0;
    }

    private int getBonusRollsCount(AbstractFrame frame) {
        if (frame instanceof LastFrame) {
            return 0;
        } else if (frame.isStrike()) {
            return 2;
        } else if (frame.isSpare()) {
            return 1;
        } else {
            return 0;
        }
    }

    private AbstractFrame findFirstNotCompleted() {
        return frames.stream()
                .filter(frame -> !frame.isCompleted())
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
