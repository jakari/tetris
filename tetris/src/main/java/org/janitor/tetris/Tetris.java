package org.janitor.tetris;

import org.janitor.tetris.model.*;
import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.ui.Window;

import javax.swing.*;
import java.util.Timer;

/**
 * This is the main class to run the game
 */
public class Tetris {
    public static void main(String[] args) {
        GameBoard view = new GameBoard();
        Window w = new Window(view);
        SwingUtilities.invokeLater(w);
        Game g = new Game(
                view,
                new TetrominoRandomizer(),
                new Board(new boolean[20][10])
        );
        g.setMovement(new Movement(g));
        g.nextTetromino();

        Timer t = new Timer();

        t.scheduleAtFixedRate(new GameTickTask(g), 600, 600);
    }
}
