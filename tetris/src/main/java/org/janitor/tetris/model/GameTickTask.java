package org.janitor.tetris.model;

import java.util.TimerTask;

public class GameTickTask extends TimerTask {
    private Game game;

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
