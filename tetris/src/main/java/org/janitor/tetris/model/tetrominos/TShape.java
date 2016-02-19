package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * A T-shaped tetromino.
 */
public class TShape extends Tetromino {
    /**
     * Constructor.
     */
    public TShape() {
        p = new GridPosition(3, 0);
        blockGrid = new boolean[][] {
            {true, true, true},
            {false, true, false}
        };
    }
}
