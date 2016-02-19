package org.janitor.tetris.model.tetrominos;

import org.junit.Test;
import static org.junit.Assert.*;

abstract class TetrominoTest {
    protected abstract int getHeight();
    protected abstract int getWidth();
    protected abstract Tetromino createTetromino();

    @Test
    public void getsCorrectTetrominoSize() {
        Tetromino tetromino = createTetromino();

        assertEquals(getHeight(), tetromino.getHeight());
        assertEquals(getWidth(), tetromino.getWidth());
    }

    @Test
    public void rotatesLeft() {
        Tetromino tetromino = createTetromino();

        boolean[][] originalGrid = tetromino.getBlockGrid();
        boolean[][] rotatedGrid = new boolean[getWidth()][getHeight()];

        int newX = 0;

        for (int y = 0; y < tetromino.getHeight(); y++) {
            int newY = 0;
            for (int x = getWidth()-1; x >= 0; x--) {
                rotatedGrid[newY][newX] = originalGrid[y][x];
                newY++;
            }
            newX++;
        }

        tetromino.rotateLeft();

        assertArrayEquals(rotatedGrid, tetromino.getBlockGrid());
    }
}
