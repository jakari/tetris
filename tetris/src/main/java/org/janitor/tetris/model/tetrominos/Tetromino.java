package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.GridPosition;

public abstract class Tetromino {
    protected GridPosition p;
    protected boolean[][] blockGrid;

    public GridPosition getGridPosition() {
        return p;
    }

    public boolean[][] getBlockGrid() {
        return this.blockGrid;
    }
}
