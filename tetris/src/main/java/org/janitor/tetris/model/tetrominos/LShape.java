package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * A L-shaped tetromino.
 */
public class LShape extends Tetromino {
    /**
     * Constructor.
     */
    public LShape() {
        p = new GridPosition(3, 0);
        blockGrid = new boolean[][] {
            {true, true, true},
            {true, false, false}
        };
    }
}
