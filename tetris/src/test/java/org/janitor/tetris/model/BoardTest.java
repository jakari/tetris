package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.L;
import org.janitor.tetris.model.tetrominos.Tetromino;
import org.junit.Test;

import java.util.Arrays;

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
        Tetromino l = new L();
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
}
