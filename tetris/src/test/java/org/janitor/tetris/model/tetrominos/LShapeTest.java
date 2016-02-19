package org.janitor.tetris.model.tetrominos;

public class LShapeTest extends TetrominoTest {
    @Override
    protected int getWidth() {
        return 3;
    }

    @Override
    protected Tetromino createTetromino() {
        return new LShape();
    }

    @Override
    protected int getHeight() {
        return 2;
    }
}
