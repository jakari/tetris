package org.janitor.tetris.model.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class TetrominoRandomizerTest {
    @Test
    public void returnsNewTetromino() {
        TetrominoRandomizer r = new TetrominoRandomizer();

        for (int i = 0; i < 1000; i++) {
            assertNotNull(r.getNextTetromino());
        }
    }
}
