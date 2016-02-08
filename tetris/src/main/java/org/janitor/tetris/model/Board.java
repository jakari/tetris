package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.Tetromino;

public class Board  {
    private boolean[][] grid;

    public Board(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public Board addTetromino(Tetromino t) {
        boolean[][] newGrid = new boolean[grid.length][0];

        // Must perform deep clone to get a immutable copy of the array
        for (int r = 0; r < grid.length; r++) {
            newGrid[r] = grid[r].clone();
        }

        GridPosition p = t.getGridPosition();
        boolean[][] rows = t.getBlockGrid();

        for (int r = 0; r < rows.length; r++) {
            System.arraycopy(rows[r], 0, newGrid[r + p.y], p.x, rows[r].length);
        }

        return new Board(newGrid);
    }
}
