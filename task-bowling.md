# Bowling scorer

### Task description

Implement `BowlingGame` class, with methods
```
public void roll(int pins)
public int calculateScore()
```

`BowlingGame` is used to track score of a single player, across a single bowling game.
The `roll` method is used to provide how many pins were knocked down with a single roll. The `calculateScore` method can be used any time to return the current game score.

Add any necessary unit tests, proving the correctness of `BowlingGame` implementation, to the `BowlingGameTest` test class.

### Bowling scoring rules
The bowling game consists of 10 frames. The player, in each frame, aims to knock down 10 pins, with maximally two attempts (an attempt being a ball roll).  
The score for a frame is the number of knocked pins, plus eventual bonuses for strikes and spares.

A spare occurs when player knocks down 10 pins in two rolls. The bonus for the frame is the number of pins hit with the next single roll.
For example, if in frame *n* player hits 4 pins with first roll, 6 with second roll, and in first roll in frame *n + 1* hits 3 pins, the score for frame *n* is 13 points.  

A strike is when player hits 10 pins with first roll (i.e. on a first try). The bonus are the results of next two balls rolled.

If the player scores spare or strike in the last (tenth) frame, she is allowed to make additional roll. However, no more than 3 rolls in total can be made in the tenth frame. Spares and strikes achieved in the last frame do not score spare/strike bonus points.

The game score is a sum of scores from all frames.  
