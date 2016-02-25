package org.janitor.tetris.model.game;

import static org.mockito.Mockito.*;

import org.janitor.tetris.model.grid.Board;
import org.janitor.tetris.model.grid.GridPosition;
import org.janitor.tetris.model.grid.RemovedRowsResult;
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
    private boolean[][] tetrominoGrid;

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

        tetrominoGrid = new boolean[][] {{true, true}, {true, true}};
        when(tetromino.getBlockGrid()).thenReturn(tetrominoGrid);
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
        game.update();

        shouldRepaintBoard(1);
    }

    @Test
    public void doesntTickOverGrid() {
        when(staticBoard.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(4, 1))).thenReturn(false);

        game.tick();

        verify(movement, times(1)).moveDown();

        tetromino.getGridPosition().y++;

        boolean[][] updatedGrid = {{true}};
        when(staticBoard.doesGridOverlapAtPosition(tetrominoGrid, new GridPosition(4, 2))).thenReturn(true);
        Board boardWithAddedTetromino = mock(Board.class);
        Board boardWithRemovedRows = mock(Board.class);
        Board lastBoard = mock(Board.class);
        RemovedRowsResult result = new RemovedRowsResult(0, boardWithRemovedRows);
        when(staticBoard.addTetromino(tetromino))
            .thenReturn(boardWithAddedTetromino);
        when(boardWithAddedTetromino.removeFilledRows()).thenReturn(result);
        when(boardWithRemovedRows.addTetromino(tetromino)).thenReturn(lastBoard);
        when(lastBoard.getGrid()).thenReturn(updatedGrid);

        game.tick();

        verify(view).update(updatedGrid);

        verify(r, times(3)).getNextTetromino();

        verify(movement, times(1)).moveDown();
    }

    @Test
    public void tickDoesntChangeXPosition() {
        assertEquals(4, tetrominoPosition.x);
        game.tick();
        assertEquals(4, tetrominoPosition.x);
    }

    @Test
    public void rotatesTetrominoToLeft() {
        boolean[][] representation = new boolean[0][0];

        when(tetromino.getRotatedGridRepresentation()).thenReturn(representation);
        when(staticBoard.doesGridOverlapAtPosition(representation, tetrominoPosition)).thenReturn(false);

        game.rotateTetromino();

        verify(tetromino).rotateLeft();
        verify(view, times(1)).update(grid);
    }

    @Test
    public void doesntRotateWhenGridOverlaps() {
        boolean[][] representation = new boolean[0][0];

        when(tetromino.getRotatedGridRepresentation()).thenReturn(representation);
        when(staticBoard.doesGridOverlapAtPosition(representation, tetrominoPosition)).thenReturn(true);

        game.rotateTetromino();

        verify(tetromino, never()).rotateLeft();
        verify(view, never()).update(grid);
    }

    private void shouldRepaintBoard(int shouldBeCalledTimes) {
        verify(view, times(shouldBeCalledTimes)).update((boolean[][]) argThat(new MatchesTwoDimensionalBooleanArray(grid)));
    }
}
