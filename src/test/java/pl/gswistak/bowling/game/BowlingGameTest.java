package pl.gswistak.bowling.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class BowlingGameTest {

    @Test
    void rollShouldChangeScoreResult() {
        BowlingGame game = new BowlingGame();
        game.roll(6);
        game.roll(0);
        Assertions.assertEquals(6, game.calculateScore());
    }

    @ParameterizedTest
    @MethodSource("rollsToScoreProvider")
    void calculateScore(List<Integer> rolls, int score) {
        BowlingGame game = new BowlingGame();
        rolls.forEach(game::roll);
        Assertions.assertEquals(score, game.calculateScore());
    }

    private static Stream rollsToScoreProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 5, 3), 26),
                Arguments.of(Arrays.asList(4, 6, 7), 17),
                Arguments.of(Collections.nCopies(10, 10), 240),
                Arguments.of(Collections.nCopies(12, 10), 300)
        );
    }
}