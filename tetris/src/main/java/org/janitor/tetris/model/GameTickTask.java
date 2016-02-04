package org.janitor.tetris.model;

import java.util.TimerTask;

public class GameTickTask extends TimerTask {
    private Game game;

    public GameTickTask(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        // Currently in debug mode
        try {
            game.tick();
        } catch (ArrayIndexOutOfBoundsException e) {
            cancel();
        }
    }
}
