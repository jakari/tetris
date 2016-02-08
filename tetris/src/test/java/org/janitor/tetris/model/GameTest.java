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
        grid = new boolean[3][3];

        when(tetromino.getBlockGrid()).thenReturn(new boolean[][] {{true, true}, {true, true}});
        when(tetromino.getGridPosition()).thenReturn(tetrominoPosition);
        when(tetromino.getWidth()).thenReturn(2);
        when(tetromino.getHeight()).thenReturn(1);
        when(r.getNextTetromino()).thenReturn(tetromino);
        when(staticBoard.addTetromino(tetromino)).thenReturn(paintedBoard);
        when(staticBoard.getGrid()).thenReturn(grid);
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
    public void doesntTickOverGrid() {
        when(tetromino.getHeight()).thenReturn(2);
        game.tick();
        assertEquals(1, tetrominoPosition.y);
        assertFalse(game.isOver());

        game.tick();
        assertEquals(1, tetrominoPosition.y);
        assertTrue(game.isOver());
    }

    @Test
    public void tickDoesntChangeXPosition() {
        assertEquals(4, tetrominoPosition.x);
        game.tick();
        assertEquals(4, tetrominoPosition.x);
    }

    private void shouldRepaintBoard() {
        shouldRepaintBoard(1);
    }

    private void shouldRepaintBoard(int shouldBeCalledTimes) {
        verify(view, times(shouldBeCalledTimes)).update((boolean[][]) argThat(new MatchesTwoDimensionalBooleanArray(grid)));
    }
}
