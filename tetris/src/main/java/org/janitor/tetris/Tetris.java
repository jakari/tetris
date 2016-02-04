package org.janitor.tetris;

import org.janitor.tetris.model.Board;
import org.janitor.tetris.model.Game;
import org.janitor.tetris.model.GameTickTask;
import org.janitor.tetris.model.TetrominoRandomizer;
import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.ui.Window;

import javax.swing.*;
import java.util.Timer;

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

        Timer t = new Timer();

        t.scheduleAtFixedRate(new GameTickTask(g), 600, 600);
    }
}
