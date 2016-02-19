package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * A block-shaped tetromino.
 */
public class BlockShape extends Tetromino {

    /**
     * Constructor.
     */
    public BlockShape() {
        p = new GridPosition(4, 0);
        blockGrid = new boolean[][] {
            {true, true},
            {true, true}
        };
    }
}
