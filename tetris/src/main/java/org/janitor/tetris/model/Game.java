package org.janitor.tetris.model;

import org.janitor.tetris.model.tetrominos.Tetromino;
import org.janitor.tetris.ui.GameBoard;

public class Game {
    private TetrominoRandomizer randomizer;
    private Board board;
    private GameBoard view;
    private Tetromino tetromino;
    private Movement movement;
    private boolean isRunning = true;

    public Game(GameBoard view, TetrominoRandomizer randomizer, Board board) {
        this.board = board;
        this.view = view;
        this.randomizer = randomizer;
        this.movement = new Movement(this);
        view.addKeyListener(this.movement);

        nextTetromino();
    }

    public void tick() {
        if (tetromino.getGridPosition().y+tetromino.getHeight() == this.board.getGrid().length) {
            this.isRunning = false;
        } else {
            tetromino.getGridPosition().y++;
            update();
        }
    }

    public void update() {
        this.view.update(board.addTetromino(tetromino).getGrid());
    }

    public boolean isOver() {
        return !isRunning;
    }

    private void nextTetromino() {
        tetromino = randomizer.getNextTetromino();
        movement.setTetromino(tetromino);
        update();
    }
}
