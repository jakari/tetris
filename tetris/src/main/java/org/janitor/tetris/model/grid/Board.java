package org.janitor.tetris.model.grid;

import org.janitor.tetris.model.tetrominos.Tetromino;

/**
 * Defines the tetromino board grid model.
 *
 * This class is immutable.
 */
public class Board {
    private boolean[][] grid;

    /**
     * Constructor.
     * @param grid The grid to create board with
     */
    public Board(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    /**
     * Adds a tetromino to the board and returns a new instance containing the
     * added tetromino.
     *
     * @param t Tetromino to add to board
     * @return The new board containing added tetromino
     */
    public Board addTetromino(Tetromino t) {
        boolean[][] newGrid = new boolean[grid.length][0];

        // Must perform deep clone to get a immutable copy of the array
        for (int r = 0; r < grid.length; r++) {
            newGrid[r] = grid[r].clone();
        }

        GridPosition p = t.getGridPosition();
        boolean[][] rows = t.getBlockGrid();

        for (int r = 0; r < rows.length; r++) {
            for (int c = 0; c < rows[r].length; c++) {
                // Write to a existing block only if there is no existing block
                if (!newGrid[r + p.y][c + p.x]) {
                    newGrid[r + p.y][c + p.x] = rows[r][c];
                }
            }
        }

        return new Board(newGrid);
    }

    /**
     * Checks if an grid placed on a specific position would overlap existing blocks at a specified position.
     * In other words, could a set of blocks be placed on a specified position.
     *
     * @param gridToCheck   The grid to check
     * @param position      The position of the upper left corner of the grid
     *
     * @return Returns true if there are existing blocks where the grid would be places.
     * Returns false if the grid could be added to the specified position
     */
    public boolean doesGridOverlapAtPosition(boolean[][] gridToCheck, GridPosition position) {
        // Check that grid doesn't overlap array grid borders.
        if (position.x < 0 || position.y < 0) {
            return true;
        }
        if (grid.length < gridToCheck.length + position.y) {
            return true;
        }
        if (grid[0].length < gridToCheck[0].length + position.x) {
            return true;
        }

        for (int r = 0; r < gridToCheck.length; r++) {
            for (int c = 0; c < gridToCheck[r].length; c++) {
                if (grid[r + position.y][c + position.x] && gridToCheck[r][c]) {
                    return true;
                }
            }
        }

        return false;
    }
}