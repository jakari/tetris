package org.janitor.tetris.model.game;

import org.janitor.tetris.model.grid.Board;
import org.janitor.tetris.model.grid.GridPosition;
import org.janitor.tetris.model.tetrominos.Tetromino;
import org.janitor.tetris.ui.GameBoard;

/**
 * The game class contains the main game logic model.
 */
public class Game {
    private TetrominoRandomizer randomizer;
    private Board board;
    private GameBoard view;
    private Tetromino tetromino;
    private Movement movement;
    private boolean isRunning = true;

    /**
     * Constructor.
     *
     * @param view          The view to use for the game
     * @param randomizer    A tetromino randomizer
     * @param board         The game board grid
     */
    public Game(GameBoard view, TetrominoRandomizer randomizer, Board board) {
        this.board = board;
        this.view = view;
        this.randomizer = randomizer;
    }

    /**
     * Sets a movement controller for controlling the game.
     * @param m the object
     */
    public void setMovement(Movement m) {
        movement = m;
        view.addKeyListener(movement);
    }

    /**
     * Initializes a game "tick"
     * Each tick in a game is a step when a tetromino moves one unit down.
     */
    public void tick() {
        if (!canTetrominoMoveDown()) {
            nextTetromino();
            update();
        } else {
            movement.moveDown();
        }
    }

    /**
     * Initializes a game update.
     */
    public void update() {
        if (!canTetrominoMoveDown()) {
            board = board.addTetromino(tetromino).removeFilledRows().board;
            nextTetromino();
        }

        this.view.update(board.addTetromino(tetromino).getGrid());
    }

    /**
     * Checks if the game is still running or is it over.
     * @return Returns true if game is over
     */
    public boolean isOver() {
        return !isRunning;
    }

    /**
     * Sets a new random tetromino for the game.
     */
    public void nextTetromino() {
        tetromino = randomizer.getNextTetromino();
        movement.setTetromino(tetromino);
    }

    /**
     * Rotates the tetromino to the left.
     */
    public void rotateTetromino() {
        boolean[][] rotated = tetromino.getRotatedGridRepresentation();

        if (!board.doesGridOverlapAtPosition(rotated, tetromino.getGridPosition())) {
            tetromino.rotateLeft();
            update();
        }
    }

    private boolean canTetrominoMoveDown() {
        // If on last row, tetromino can't move down
        return canTetrominoMoveTo(
            new GridPosition(
                tetromino.getGridPosition().x,
                tetromino.getGridPosition().y + 1
            )
        );
    }

    /**
     * Checks wether the current tetromino can move to the given position on the grid.
     * @param position Position where to place the tetromino
     * @return Returns true if the tetromino can be moved to the specified position, false otherwise
     */
    public boolean canTetrominoMoveTo(GridPosition position) {
        return !board.doesGridOverlapAtPosition(tetromino.getBlockGrid(), position);
    }
}
