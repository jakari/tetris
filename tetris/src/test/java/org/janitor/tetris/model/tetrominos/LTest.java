package org.janitor.tetris.model.tetrominos;

import org.junit.Test;

public class LTest extends TetrominoTest {
    @Override
    protected int getWidth() {
        return 3;
    }

    @Override
    protected Tetromino createTetromino() {
        return new L();
    }

    @Override
    protected int getHeight() {
        return 2;
    }
}
