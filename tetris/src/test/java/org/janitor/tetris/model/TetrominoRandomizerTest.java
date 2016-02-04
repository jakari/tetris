package org.janitor.tetris.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class TetrominoRandomizerTest {
    @Test
    public void returnsNewTetromino() {
        TetrominoRandomizer r = new TetrominoRandomizer();
        assertNotNull(r.getNextTetromino());
    }
}
