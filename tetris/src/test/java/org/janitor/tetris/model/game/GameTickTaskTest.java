package org.janitor.tetris.model.game;

import org.junit.*;
import static org.mockito.Mockito.*;

public class GameTickTaskTest {
    private Game game;
    private GameTickTask task;

    @Before
    public void setUp() {
        game = mock(Game.class);
        task = new GameTickTask(game);
    }

    @Test
    public void ticksGameUntilOver() {
        when(game.isOver()).thenReturn(false, false, true);

        task.run();
        task.run();
        task.run();

        verify(game, times(2)).tick();
    }
}
