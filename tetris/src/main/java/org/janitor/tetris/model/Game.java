package org.janitor.tetris.model;

import org.janitor.tetris.ui.GameBoard;
import org.janitor.tetris.ui.Position;

public class Game {
    private Position position;
    private boolean[][] board;
    private GameBoard view;

    public Game(GameBoard view) {
        board = new boolean[20][10];
        position = new Position(4, 0);
        this.view = view;
    }

    public void start() {
        this.view.update(board);
    }

    public void tick() {
        position = new Position(position.x, position.y+1);
    }

    public Position getPosition() {
        return position;
    }

    public void moveLeft() {
        if (position.x > 0) {
            position = new Position(position.x-1, position.y);
        }
    }

    public void moveRight() {
        if (position.x < 9) {
            position = new Position(position.x+1, position.y);
        }
    }
}
