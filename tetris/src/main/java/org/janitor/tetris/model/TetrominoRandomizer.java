package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.L;
import org.janitor.tetris.model.tetrominos.Tetromino;

public class TetrominoRandomizer {
    public Tetromino getNextTetromino() {
        return new L();
    }
}
