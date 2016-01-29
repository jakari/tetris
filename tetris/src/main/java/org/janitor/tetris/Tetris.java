package org.janitor.tetris;

import org.janitor.tetris.model.Game;
import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.ui.Window;

import javax.swing.*;

public class Tetris {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Window w = new Window(board);
        SwingUtilities.invokeLater(w);
        Game g = new Game(board);
        g.start();
    }
}
