package org.janitor.tetris.model.grid;

import org.janitor.tetris.model.tetrominos.Tetromino;

import java.util.Arrays;

/**
 * Defines the tetromino board grid model.
 *
 * This class is immutable.
 */
public class Board {
    private final boolean[][] grid;

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
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            newGrid[rowIndex] = grid[rowIndex].clone();
        }

        GridPosition gridPosition = t.getGridPosition();
        boolean[][] rows = t.getBlockGrid();

        for (int yIndex = 0; yIndex < rows.length; yIndex++) {
            for (int xIndex = 0; xIndex < rows[yIndex].length; xIndex++) {
                // Write to a existing block only if there is no existing block
                if (!newGrid[yIndex + gridPosition.y][xIndex + gridPosition.x]) {
                    newGrid[yIndex + gridPosition.y][xIndex + gridPosition.x] = rows[yIndex][xIndex];
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

        for (int yIndex = 0; yIndex < gridToCheck.length; yIndex++) {
            for (int xIndex = 0; xIndex < gridToCheck[yIndex].length; xIndex++) {
                if (grid[yIndex + position.y][xIndex + position.x] && gridToCheck[yIndex][xIndex]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Removes rows that are filled with blocks.
     * @return Returns result containing the number of rows removed and a new
     * Board representing the new state.
     */
    public RemovedRowsResult removeFilledRows() {
        int fullRows = 0;
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];

        // Marks the current row pointer in the new grid.
        int newY = grid.length - 1;

        // Loop through existing rows and search for rows that are full.
        for (int y = newY; y >= 0; y--) {
            boolean isFull = true;

            // Loop through each cell in current row and check for filled blocks
            for (boolean cell : grid[y]) {
                // If a cell is found with a block not filled, stop searching
                // and flag row as not full
                if (!cell) {
                    isFull = false;
                    break;
                }
            }

            // When row is not full, it is copied to the new grid.
            // Full rows are not copied into the new grid, but the next
            // row is stacked downwards, so the newY is not incremented
            // when the row is full.
            if (!isFull) {
                newGrid[newY] = grid[y];
                newY--;
            } else {
                fullRows++;
            }
        }

        return new RemovedRowsResult(fullRows, new Board(newGrid));
    }
}
