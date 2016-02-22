package org.janitor.tetris.model.grid;

public class RemovedRowsResult {
    public final int rowsRemoved;
    public final Board board;

    public RemovedRowsResult(int rowsRemoved, Board board) {
        this.rowsRemoved = rowsRemoved;
        this.board = board;
    }
}
