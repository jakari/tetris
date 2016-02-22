package org.janitor.tetris.ui;

import javax.swing.JPanel;
import java.awt.*;

/**
 * The panel where to do the actual painting of the game.
 */
public class GameBoard extends JPanel {
    private Character chars;
    private boolean[][] board;

    /**
     * Constructor.
     */
    public GameBoard() {
        super();
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(CharacterPosition.xCharPosToPx(12), CharacterPosition.yCharPosToPx(22)));
        chars = new Character();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (board == null){
            return;
        }

        for (int y = 0; y < 20; y++) {
            chars.leftBorder(new CharacterPosition(0, y), graphics);
            chars.rightBorder(new CharacterPosition(11, y), graphics);

            for (int x = 0; x < 10; x++) {
                if (board[y][x]) {
                    chars.block(new CharacterPosition(x+1, y), graphics);
                    chars.block(new CharacterPosition(x+1, y), graphics);
                } else {
                    chars.dot(new CharacterPosition(x+1, y), graphics);
                }

                if (y == 0) {
                    chars.leftBorder(new CharacterPosition(0, 20), graphics);
                    chars.rightBorder(new CharacterPosition(11, 20), graphics);
                    chars.bottomBorder(new CharacterPosition(x+1, 20), graphics);
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
