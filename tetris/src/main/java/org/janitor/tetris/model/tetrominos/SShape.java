package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * An S-shaped tetromino.
 */
public class SShape extends Tetromino {
    /**
     * Constructor.
     */
    public SShape() {
        p = new GridPosition(4, 0);
        blockGrid = new boolean[][] {
            {false, true, true},
            {true, true, false}
        };
    }
}
