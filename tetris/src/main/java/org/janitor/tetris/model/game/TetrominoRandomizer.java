package org.janitor.tetris.model.game;

import org.janitor.tetris.model.tetrominos.*;

import java.util.Random;

/**
 * Generates a random tetromino.
 */
public class TetrominoRandomizer {
    /**
     * Constructor.
     * @return Retrieves a new random tetromino
     */
    public Tetromino getNextTetromino() {
        Random random = new Random();

        switch (random.nextInt(7)) {
            case 0:
                return new BlockShape();
            case 1:
                return new InverseLShape();
            case 2:
                return new LineShape();
            case 3:
                return new LShape();
            case 4:
                return new SShape();
            case 5:
                return new TShape();
            case 6:
                return new ZShape();
        }

        throw new Error("Internal tetromino random error");
    }
}
