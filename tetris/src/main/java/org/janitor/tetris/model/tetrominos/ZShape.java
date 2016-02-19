package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * An Z-shaped tetromino.
 */
public class ZShape extends Tetromino {
    /**
     * Constructor.
     */
    public ZShape() {
        p = new GridPosition(4, 0);
        blockGrid = new boolean[][] {
            {true, true, false},
            {false, true, true}
        };
    }
}
