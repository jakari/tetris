package org.janitor.tetris.model.tetrominos;

import org.junit.Test;
import static org.junit.Assert.*;

abstract class TetrominoTest {
    protected abstract int getHeight();
    protected abstract int getWidth();
    protected abstract Tetromino createTetromino();

    @Test
    public void getsCorrectTetrominoSize() {
        Tetromino tetromino = createTetromino();

        assertEquals(getHeight(), tetromino.getHeight());
        assertEquals(getWidth(), tetromino.getWidth());
    }
}
