package org.janitor.tetris.ui;

import org.janitor.tetris.model.Game;

import javax.swing.JPanel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GameBoard extends JPanel {
    private Character chars;
    private boolean[][] board;

    public GameBoard() {
        super();
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(154* CharacterPosition.PIXEL_SIZE, 280* CharacterPosition.PIXEL_SIZE));
        chars = new Character();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (board[y][x]) {
                    chars.block(new CharacterPosition(x, y), graphics);
                    chars.block(new CharacterPosition(x, y), graphics);
                } else if (x % 2 != 0) {
                    chars.dot(new CharacterPosition(x, y), graphics);
                }
            }
        }

        chars.block(new CharacterPosition(8, 3), graphics);
        chars.block(new CharacterPosition(9, 3), graphics);
        chars.block(new CharacterPosition(10, 3), graphics);
        chars.block(new CharacterPosition(11, 3), graphics);
        chars.block(new CharacterPosition(12, 3), graphics);
        chars.block(new CharacterPosition(13, 3), graphics);
        chars.block(new CharacterPosition(12, 4), graphics);
        chars.block(new CharacterPosition(13, 4), graphics);
    }

    public void update(boolean[][] board) {
        this.board = board;
        repaint();
    }
}