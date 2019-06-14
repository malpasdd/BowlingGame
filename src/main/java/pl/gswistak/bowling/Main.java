package pl.gswistak.bowling;

import pl.gswistak.bowling.game.BowlingGame;

public class Main {

    public static void main(String[] args) {
        BowlingGame firstGame = new BowlingGame();
        firstGame.roll(10);
        firstGame.roll(10);
        firstGame.roll(4);
        firstGame.roll(5);

        int firstGameScore = firstGame.calculateScore();
        System.out.println(String.format("score: %s", firstGameScore));


        BowlingGame secondGame = new BowlingGame();
        secondGame.roll(10);
        secondGame.roll(6);
        secondGame.roll(4);
        secondGame.roll(4);
        secondGame.roll(5);

        int secondGameScore = secondGame.calculateScore();
        System.out.println(String.format("score: %s", secondGameScore));
    }
}
