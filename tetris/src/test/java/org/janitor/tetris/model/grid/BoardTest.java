package org.janitor.tetris.model.grid;

import org.janitor.tetris.model.tetrominos.LShape;
import org.janitor.tetris.model.tetrominos.Tetromino;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void createsBoardAndReturnsGrid() {
        boolean[][] grid = new boolean[3][3];

        Board board = new Board(grid);

        assertSame(grid, board.getGrid());
    }

    @Test
    public void appendsTetrominoAndReturnsNewInstanceWithTetromnio() {
        boolean[][] grid = new boolean[4][10];
        Tetromino l = new LShape();
        l.getGridPosition().y = 1;

        Board board = new Board(grid);
        Board appended = board.addTetromino(l);

        assertNotSame(board, appended);

        // Original board is not mutated
        assertArrayEquals(board.getGrid(), new boolean[4][10]);

        boolean[][] expected = new boolean[4][10];

        expected[1][3] = true;
        expected[1][4] = true;
        expected[1][5] = true;
        expected[2][3] = true;

        assertArrayEquals(appended.getGrid(), expected);
    }

    @Test
    public void tetrominoShouldOverlapWhenOutsideGrid() {
        boolean[][] grid = new boolean[5][5];
        Board board = new Board(grid);

        assertTrue(board.doesGridOverlapAtPosition(aGrid(1, 1), new GridPosition(-1, 0)));
        assertTrue(board.doesGridOverlapAtPosition(aGrid(1, 1), new GridPosition(0, -1)));
        assertTrue(board.doesGridOverlapAtPosition(aGrid(1, 1), new GridPosition(5, 0)));
        assertTrue(board.doesGridOverlapAtPosition(aGrid(2, 1), new GridPosition(4, 0)));
        assertTrue(board.doesGridOverlapAtPosition(aGrid(1, 1), new GridPosition(0, 5)));
        assertTrue(board.doesGridOverlapAtPosition(aGrid(1, 2), new GridPosition(0, 4)));
    }

    @Test
    public void tetrominoShouldOverlapWhenBlockAtSamePosition() {
        boolean[][] grid = new boolean[5][5];
        Board board = new Board(grid);

        grid[3][2] = true;

        assertTrue(board.doesGridOverlapAtPosition(aGrid(1, 1), new GridPosition(2, 3)));
    }

    @Test
    public void tetrominoShouldNotOverlapInEmptySpace() {
        boolean[][] grid = new boolean[5][5];
        Board board = new Board(grid);

        boolean[][] tetrominoGrid = {{true, true}, {true, true}};

        assertFalse(board.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(0, 0)));
        assertFalse(board.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(3, 0)));
        assertFalse(board.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(3, 3)));
        assertFalse(board.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(0, 3)));
    }

    @Test
    public void tetrominoShouldNotOverlapAtFreeTetrominoSpace() {
        boolean[][] grid = new boolean[5][5];
        Board board = new Board(grid);

        grid[3][2] = true;
        grid[3][3] = false;

        boolean[][] tetrominoGrid = {{false, true}};

        assertFalse(board.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(2, 3)));
    }

    private boolean[][] aGrid(int width, int height) {
        boolean[][] grid = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = true;
            }
        }

        return grid;
    }
}
