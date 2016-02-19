package org.janitor.tetris.model.tetrominos;

import org.janitor.tetris.model.grid.GridPosition;

/**
 * A baseclass for tetrominos to extend.
 */
public abstract class Tetromino {
    protected GridPosition p;
    protected boolean[][] blockGrid;

    public GridPosition getGridPosition() {
        return p;
    }

    public boolean[][] getBlockGrid() {
        return this.blockGrid;
    }

    public int getWidth() {
        return blockGrid[0].length;
    }

    public int getHeight() {
        return blockGrid.length;
    }

    /**
     * Rotates the tetromino to the left.
     */
    public void rotateLeft() {
        blockGrid = getRotatedGridRepresentation();
    }

    /**
     * Retrieves a grid representation of the tetromine how it would look
     * when rotated to the left. This does not alter the tetromino.
     *
     * @return The grid of blocks
     */
    public boolean[][] getRotatedGridRepresentation() {
        boolean[][] newGrid = new boolean[getWidth()][getHeight()];

        int newX = 0;

        for (int y = 0; y < getHeight(); y++) {
            int newY = 0;
            for (int x = getWidth() - 1; x >= 0; x--) {
                newGrid[newY][newX] = blockGrid[y][x];
                newY++;
            }
            newX++;
        }

        return newGrid;
    }
}
