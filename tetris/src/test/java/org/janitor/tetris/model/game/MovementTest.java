package org.janitor.tetris.model.game;

import org.janitor.tetris.model.grid.GridPosition;
import org.janitor.tetris.model.tetrominos.Tetromino;
import org.junit.*;
import org.mockito.stubbing.OngoingStubbing;

import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MovementTest {
    private Game game;
    private Tetromino tetromino;
    private GridPosition tetrominoPosition;
    private Movement movement;

    @Before
    public void setUp() {
        tetromino = mock(Tetromino.class);
        tetrominoPosition = new GridPosition(4, 0);
        when(tetromino.getGridPosition()).thenReturn(tetrominoPosition);
        when(tetromino.getWidth()).thenReturn(2);
        game = mock(Game.class);
        movement = new Movement(game);
        movement.setTetromino(tetromino);
    }



    @Test
    public void movesBlockToLeft() {
        tetrominoPosition.x = 4;

        when(game.canTetrominoMoveTo(any())).thenReturn(true);

        moveLeft();
        assertEquals(3, tetrominoPosition.x);
        shouldUpdateGame(1);
        moveLeft();
        assertEquals(2, tetrominoPosition.x);
        shouldUpdateGame(2);
    }

    @Test
    public void movesBlockToRight() {
        tetrominoPosition.x = 4;

        when(game.canTetrominoMoveTo(any())).thenReturn(true);

        moveRight();
        assertEquals(5, tetrominoPosition.x);
        shouldUpdateGame(1);
        moveRight();
        assertEquals(6, tetrominoPosition.x);
        shouldUpdateGame(2);
    }

    @Test
    public void doesntAdvanceOverLeftBoardBorder() {
        tetrominoPosition.x = 4;

        canTetrominoMoveTo(3, 0).thenReturn(true);
        canTetrominoMoveTo(2, 0).thenReturn(true);
        canTetrominoMoveTo(1, 0).thenReturn(true);
        canTetrominoMoveTo(0, 0).thenReturn(true);
        canTetrominoMoveTo(-1, 0).thenReturn(false);
        moveLeft();
        moveLeft();
        moveLeft();
        moveLeft();
        moveLeft();
        assertEquals(0, tetrominoPosition.x);
    }

    @Test
    public void doesntAdvanceOverRightBoardBorder() {
        tetrominoPosition.x = 4;

        canTetrominoMoveTo(5, 0).thenReturn(true);
        canTetrominoMoveTo(6, 0).thenReturn(true);
        canTetrominoMoveTo(7, 0).thenReturn(true);
        canTetrominoMoveTo(8, 0).thenReturn(false);
        moveRight();
        moveRight();
        moveRight();
        moveRight();

        // The tetromnino is set to 2 width, so the maximum position is 7
        assertEquals(7, tetrominoPosition.x);
    }

    @Test
    public void movesDown() {
        tetrominoPosition.y = 0;

        canTetrominoMoveTo(4, 1).thenReturn(true);
        canTetrominoMoveTo(4, 2).thenReturn(true);
        canTetrominoMoveTo(4, 3).thenReturn(true);
        movement.moveDown();
        movement.moveDown();
        movement.moveDown();

        verify(game, times(3)).update();

        assertEquals(3, tetrominoPosition.y);
    }

    @Test
    public void rotatesTetromino() {
        rotate();

        verify(game).rotateTetromino();
    }

    @Test
    public void stopsMoveDownWhenCannotMove() {
        tetrominoPosition.y = 0;

        canTetrominoMoveTo(4, 1).thenReturn(true);
        canTetrominoMoveTo(4, 2).thenReturn(false);
        movement.moveDown();
        movement.moveDown();
        movement.moveDown();

        verify(game, times(1)).update();

        assertEquals(1, tetrominoPosition.y);
    }

    @Test
    public void freeFallMovesDownUntilCannotMove() {
        canTetrominoMoveTo(4, 1).thenReturn(true);
        canTetrominoMoveTo(4, 2).thenReturn(true);
        canTetrominoMoveTo(4, 3).thenReturn(true);
        canTetrominoMoveTo(4, 4).thenReturn(false);

        // The 'S' character is for tetromino free fall
        pressKey(83);

        verify(game, times(1)).update();

        assertEquals(3, tetrominoPosition.y);
    }

    private void moveLeft() {
        pressKey(65);
    }

    private void moveRight() {
        pressKey(68);
    }

    private void rotate() {
        pressKey(87);
    }

    private void pressKey(int keyCode) {
        KeyEvent e = mock(KeyEvent.class);
        when(e.getKeyCode()).thenReturn(keyCode);
        movement.keyPressed(e);
    }

    private void shouldUpdateGame(int count) {
        verify(game, times(count)).update();
    }

    private OngoingStubbing<Boolean> canTetrominoMoveTo(int  x, int y) {
        return when(game.canTetrominoMoveTo(new GridPosition(x, y)));
    }
}
