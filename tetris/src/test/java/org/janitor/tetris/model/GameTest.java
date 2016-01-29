package org.janitor.tetris.model;

import static org.mockito.Mockito.*;
import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.ui.Position;
import org.janitor.tetris.util.MatchesTwoDimensionalBooleanArray;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    private GameBoard view;
    private Game game;

    @Before
    public void setUp() {
        view = mock(GameBoard.class);
        game = new Game(view);
    }

    @Test
    public void createsCorrectSizedBoardOnStart() {
        game.start();
        verify(view).update((boolean[][]) argThat(new MatchesTwoDimensionalBooleanArray(new boolean[20][10])));
    }

    @Test
    public void tickAdvancesBlockYPosition() {
        assertEquals(0, game.getPosition().y);
        game.start();
        assertEquals(0, game.getPosition().y);

        game.tick();
        assertEquals(1, game.getPosition().y);
        game.tick();
        assertEquals(2, game.getPosition().y);
    }

    @Test
    public void tickDoesntChangeXPosition() {
        assertEquals(4, game.getPosition().x);
        game.start();
        assertEquals(4, game.getPosition().x);
        game.tick();
        assertEquals(4, game.getPosition().x);
    }

    @Test
    public void movesBlockToLeft() {
        game.moveLeft();
        assertEquals(3, game.getPosition().x);
        game.moveLeft();
        assertEquals(2, game.getPosition().x);
    }

    @Test
    public void doesntAdvanceOverLeftBoardBorder() {
        game.moveLeft();
        game.moveLeft();
        game.moveLeft();
        game.moveLeft();
        game.moveLeft();
        assertEquals(0, game.getPosition().x);
    }

    @Test
    public void doesntAdvanceOverRightBoardBorder() {
        game.moveRight();
        game.moveRight();
        game.moveRight();
        game.moveRight();
        game.moveRight();
        game.moveRight();
        assertEquals(9, game.getPosition().x);
    }
}
