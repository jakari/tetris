package org.janitor.tetris.model.game;

import java.util.TimerTask;

/**
 * The timer for ticking the game.
 * This moves the tetromino down at specified intervals.
 */
public class GameTickTask extends TimerTask {
    private Game game;

    /**
     *  Constructor.
     * @param game the game to tick.
     */
    public GameTickTask(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        if (game.isOver()) {
            cancel();
            return;
        }

        game.tick();
    }
}
