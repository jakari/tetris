package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * A line-shaped tetromino.
 */
public class LineShape extends Tetromino {
    /**
     * Constructor.
     */
    public LineShape() {
        p = new GridPosition(4, 0);
        blockGrid = new boolean[][] {
            {true},
            {true},
            {true},
            {true}
        };
    }
}
