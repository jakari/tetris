package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.GridPosition;

/**
 * A L-shaped tetromino
 */
public class L extends Tetromino {
    public L() {
        p = new GridPosition(3, 0);
        blockGrid = new boolean[][] {
            {true, true, true},
            {true, false, false}
        };
    }
}
