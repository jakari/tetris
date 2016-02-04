package org.janitor.tetris.model;

import static org.mockito.Mockito.*;

import org.janitor.tetris.model.tetrominos.Tetromino;
import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.util.MatchesTwoDimensionalBooleanArray;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private GameBoard view;
    private Game game;
    private Board staticBoard;
    private Board paintedBoard;
    private TetrominoRandomizer r;
    private Tetromino tetromino;
    private GridPosition tetrominoPosition;
    private boolean[][] grid;

    @Before
    public void setUp() {
        view = mock(GameBoard.class);
        r = mock(TetrominoRandomizer.class);
        tetrominoPosition = new GridPosition(4, 0);
        tetromino = mock(Tetromino.class);
        staticBoard = mock(Board.class);
        paintedBoard = mock(Board.class);
        grid = new boolean[1][1];

        when(tetromino.getBlockGrid()).thenReturn(new boolean[][] {{true}});
        when(tetromino.getGridPosition()).thenReturn(tetrominoPosition);
        when(r.getNextTetromino()).thenReturn(tetromino);
        when(staticBoard.addTetromino(tetromino)).thenReturn(paintedBoard);
        when(paintedBoard.getGrid()).thenReturn(grid);

        game = new Game(view, r, staticBoard);
    }

    @Test
    public void getsAnewTetrominoAndPaintsView() {
        shouldRepaintBoard();
    }

    @Test
    public void tickAdvancesBlockYPosition() {
        assertEquals(0, tetrominoPosition.y);

        game.tick();
        assertEquals(1, tetrominoPosition.y);

        shouldRepaintBoard(2);

        game.tick();
        assertEquals(2, tetrominoPosition.y);

        shouldRepaintBoard(3);
    }

    @Test
    public void tickDoesntChangeXPosition() {
        assertEquals(4, tetrominoPosition.x);
        game.tick();
        assertEquals(4, tetrominoPosition.x);
    }

    @Test
    public void movesBlockToLeft() {
        tetrominoPosition.x = 4;

        game.moveLeft();
        assertEquals(3, tetrominoPosition.x);
        game.moveLeft();
        assertEquals(2, tetrominoPosition.x);
    }

    @Test
    public void doesntAdvanceOverLeftBoardBorder() {
        tetrominoPosition.x = 0;
        game.moveLeft();
        game.moveLeft();
        game.moveLeft();
        game.moveLeft();
        game.moveLeft();
        assertEquals(0, tetrominoPosition.x);
    }

    @Test
    public void doesntAdvanceOverRightBoardBorder() {
        tetrominoPosition.x = 4;
        game.moveRight();
        game.moveRight();
        game.moveRight();
        game.moveRight();
        game.moveRight();
        game.moveRight();
        assertEquals(9, tetrominoPosition.x);
    }

    private void shouldRepaintBoard() {
        shouldRepaintBoard(1);
    }

    private void shouldRepaintBoard(int shouldBeCalledTimes) {
        verify(view, times(shouldBeCalledTimes)).update((boolean[][]) argThat(new MatchesTwoDimensionalBooleanArray(grid)));
    }
}
