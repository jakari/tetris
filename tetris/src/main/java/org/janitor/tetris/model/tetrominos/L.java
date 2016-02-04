package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.GridPosition;

public class L extends Tetromino {
    public L() {
        p = new GridPosition(3, 0);
        blockGrid = new boolean[][] {
            {true, true, true},
            {true}
        };
    }
}
