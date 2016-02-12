package org.janitor.tetris.ui;

import javax.swing.JPanel;
import java.awt.*;

/**
 * The panel where to do the actual painting of the game
 */
public class GameBoard extends JPanel {
    private Character chars;
    private boolean[][] board;

    public GameBoard() {
        super();
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(138 * CharacterPosition.PIXEL_SIZE, 275 * CharacterPosition.PIXEL_SIZE));
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
                } else {
                    chars.dot(new CharacterPosition(x, y), graphics);
                }
            }
        }
    }

    /**
     * Paint the board with the given grid data.
     * @param board The board to paint
     */
    public void update(boolean[][] board) {
        this.board = board;
        repaint();
    }
}
