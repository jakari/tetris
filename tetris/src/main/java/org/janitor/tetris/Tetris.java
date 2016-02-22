package org.janitor.tetris;

import org.janitor.tetris.model.game.Game;
import org.janitor.tetris.model.game.GameTickTask;
import org.janitor.tetris.model.game.Movement;
import org.janitor.tetris.model.game.TetrominoRandomizer;
import org.janitor.tetris.model.grid.Board;
import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.ui.Window;

import javax.swing.*;
import java.util.Timer;

/**
 * This is the main class to run the game.
 */
public class Tetris {
    /**
     * Main application class.
     * @param args arguments.
     */
    public static void main(String[] args) {
        GameBoard view = new GameBoard();
        Game g = new Game(
                view,
                new TetrominoRandomizer(),
                new Board(new boolean[20][10])
        );
        g.setMovement(new Movement(g));
        g.nextTetromino();

        Window w = new Window(view);
        SwingUtilities.invokeLater(w);

        Timer t = new Timer();

        t.scheduleAtFixedRate(new GameTickTask(g), 600, 600);
    }
}
