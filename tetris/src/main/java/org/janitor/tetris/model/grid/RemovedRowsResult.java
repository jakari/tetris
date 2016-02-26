package org.janitor.tetris.model.grid;

/**
 * A data container class containing the number of rows removed and a new board
 * containing the new modified grid.
 */
public class RemovedRowsResult {
    public final int rowsRemoved;
    public final Board board;

    /**
     * Constructor.
     * @param rowsRemoved The number of removed rows.
     * @param board The board.
     */
    public RemovedRowsResult(int rowsRemoved, Board board) {
        this.rowsRemoved = rowsRemoved;
        this.board = board;
    }
}
