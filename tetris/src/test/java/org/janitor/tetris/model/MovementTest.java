package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.Tetromino;
import org.junit.*;

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

        moveRight();
        assertEquals(5, tetrominoPosition.x);
        shouldUpdateGame(1);
        moveRight();
        assertEquals(6, tetrominoPosition.x);
        shouldUpdateGame(2);
    }

    @Test
    public void doesntAdvanceOverLeftBoardBorder() {
        tetrominoPosition.x = 0;
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
        moveRight();
        moveRight();
        moveRight();
        moveRight();
        moveRight();
        moveRight();

        // The tetromnino is set to 2 width, so the maximum position is 7
        assertEquals(8, tetrominoPosition.x);
    }

    private void moveLeft() {
        KeyEvent e = mock(KeyEvent.class);
        when(e.getKeyCode()).thenReturn(65);
        movement.keyPressed(e);
    }

    private void moveRight() {
        KeyEvent e = mock(KeyEvent.class);
        when(e.getKeyCode()).thenReturn(68);
        movement.keyPressed(e);
    }

    private void shouldUpdateGame(int count) {
        verify(game, times(count)).update();
    }
}
