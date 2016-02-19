package org.janitor.tetris.model.game;

import org.janitor.tetris.model.grid.GridPosition;
import org.janitor.tetris.model.tetrominos.Tetromino;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Movement defines the controls in the game - in this case the keyboard.
 */
public class Movement implements KeyListener {
    private Game game;
    private Tetromino t;

    /**
     * Constructor.
     * @param game The game to init movement into
     */
    public Movement(Game game) {
        this.game = game;
    }

    /**
     * Set the tetromino to move.
     * @param tetromino The tetromino initialize movement to.
     */
    public void setTetromino(Tetromino tetromino) {
        t = tetromino;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No implementation
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            // The A character
            case 65:
                moveLeft();
                break;
            // The D character
            case 68:
                moveRight();
                break;
            // The S character
            case 83:
                freeFall();
                break;
            case 87:
                game.rotateTetromino();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No implementation
    }

    private void moveLeft() {
        GridPosition p = t.getGridPosition();

        if (game.canTetrominoMoveTo(new GridPosition(p.x - 1, p.y))) {
            p.x--;
            game.update();
        }
    }

    private void moveRight() {
        GridPosition p = t.getGridPosition();

        if (game.canTetrominoMoveTo(new GridPosition(p.x + 1, p.y))) {
            p.x++;
            game.update();
        }
    }

    /**
     * Move the tetromino down one unit.
     */
    public void moveDown() {
        GridPosition p = t.getGridPosition();

        if (game.canTetrominoMoveTo(new GridPosition(p.x, p.y + 1))) {
            p.y++;
            game.update();
        }
    }

    private void freeFall() {
        GridPosition p = t.getGridPosition();

        while (game.canTetrominoMoveTo(new GridPosition(p.x, p.y + 1))) {
            p.y++;
        }

        game.update();
    }
}
