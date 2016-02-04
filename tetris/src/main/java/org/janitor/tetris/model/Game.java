package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.Tetromino;
import org.janitor.tetris.ui.GameBoard;

public class Game {
    private TetrominoRandomizer randomizer;
    private Board board;
    private GameBoard view;
    private Tetromino tetromino;

    public Game(GameBoard view, TetrominoRandomizer randomizer, Board board) {
        this.board = board;
        this.view = view;
        this.randomizer = randomizer;

        tetromino = randomizer.getNextTetromino();
        repaint();
    }

    public void tick() {
        tetromino.getGridPosition().y++;
        repaint();
    }

    private void repaint() {
        this.view.update(board.addTetromino(tetromino).getGrid());
    }

    public void moveLeft() {
        GridPosition p = tetromino.getGridPosition();
        if (p.x > 0) {
            p.x--;
        }
    }

    public void moveRight() {
        GridPosition p = tetromino.getGridPosition();
        if (p.x < 9) {
            p.x++;
        }
    }
}
