package pl.gswistak.bowling.game;

import pl.gswistak.bowling.game.frame.AbstractFrame;
import pl.gswistak.bowling.game.frame.FrameListFactory;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

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
                .map(frame -> frame.getKnockedPins() + getBonus(frame))
                .reduce(0, Integer::sum);
    }

    private int getBonus(AbstractFrame frame) {
        return frames.stream()
                .filter(f -> f.getIndex() > frame.getIndex())
                .map(AbstractFrame::getRolls)
                .flatMap(Collection::stream)
                .limit(frame.getBonusRollsCount())
                .reduce(0, Integer::sum);
    }

    private AbstractFrame findFirstNotCompleted() {
        return frames.stream()
                .filter(frame -> !frame.isCompleted())
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
