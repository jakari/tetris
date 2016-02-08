package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.Tetromino;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    private Game game;
    private Tetromino t;

    public Movement(Game game) {
        this.game = game;
    }

    public void setTetromino(Tetromino tetromino) {
        t = tetromino;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The A character
        if (e.getKeyCode() == 65) {
            moveLeft();
            // The D character
        } else if (e.getKeyCode() == 68) {
            moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void moveLeft() {
        GridPosition p = t.getGridPosition();
        if (p.x > 0) {
            p.x--;
        }
        game.update();
    }

    private void moveRight() {
        GridPosition p = t.getGridPosition();
        if (p.x+t.getWidth()-1 < 9) {
            p.x++;
        }
        game.update();
    }
}
