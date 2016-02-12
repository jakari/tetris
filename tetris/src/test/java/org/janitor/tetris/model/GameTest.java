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
    private Movement movement;

    @Before
    public void setUp() {
        view = mock(GameBoard.class);
        r = mock(TetrominoRandomizer.class);
        tetrominoPosition = new GridPosition(4, 0);
        tetromino = mock(Tetromino.class);
        staticBoard = mock(Board.class);
        paintedBoard = mock(Board.class);
        grid = new boolean[3][3];
        movement = mock(Movement.class);

        when(tetromino.getBlockGrid()).thenReturn(new boolean[][] {{true, true}, {true, true}});
        when(tetromino.getGridPosition()).thenReturn(tetrominoPosition);
        when(tetromino.getWidth()).thenReturn(2);
        when(tetromino.getHeight()).thenReturn(2);
        when(r.getNextTetromino()).thenReturn(tetromino);
        when(staticBoard.addTetromino(tetromino)).thenReturn(paintedBoard);
        when(paintedBoard.addTetromino(tetromino)).thenReturn(paintedBoard);
        when(staticBoard.getGrid()).thenReturn(grid);
        when(paintedBoard.getGrid()).thenReturn(grid);

        game = new Game(view, r, staticBoard);
        game.setMovement(movement);
        game.nextTetromino();
    }

    @Test
    public void initializesGameClass() {
        Movement m = mock(Movement.class);
        GameBoard b = mock(GameBoard.class);
        Game g = new Game(b, r, staticBoard);

        g.setMovement(m);
        verify(b).addKeyListener(m);

        g.nextTetromino();
        verify(movement, times(1)).setTetromino(tetromino);
        assertFalse(g.isOver());
    }

    @Test
    public void getsAnewTetrominoAndPaintsView() {
        shouldRepaintBoard();
    }

    @Test
    public void doesntTickOverGrid() {
        when(staticBoard.doesTetrominoOverlapAtPosition(tetromino, new GridPosition(4, 1))).thenReturn(false);

        game.tick();

        verify(movement, times(1)).moveDown();

        tetromino.getGridPosition().y++;

        when(staticBoard.doesTetrominoOverlapAtPosition(tetromino, new GridPosition(4, 2))).thenReturn(true);
        game.tick();

        verify(r, times(2)).getNextTetromino();

        verify(movement, times(1)).moveDown();
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
