package pl.gswistak.bowling.game.frame;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FrameListFactory {

    private static final int FRAME_COUNT = 10;

    public LinkedList<AbstractFrame> createFramesList() {
        return IntStream.rangeClosed(1, FRAME_COUNT)
                .mapToObj(this::getFrame)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private AbstractFrame getFrame(int frameIndex) {
        return frameIndex == FRAME_COUNT
                ? new LastFrame(frameIndex)
                : new NormalFrame(frameIndex);
    }
}
