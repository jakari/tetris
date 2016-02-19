package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * A Inversed L-shaped tetromino.
 */
public class InverseLShape extends Tetromino {
    /**
     * Constructor.
     */
    public InverseLShape() {
        p = new GridPosition(3, 0);
        blockGrid = new boolean[][] {
            {true, false, false},
            {true, true, true}
        };
    }
}
