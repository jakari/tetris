package org.janitor.tetris.model.grid;

/**
 * GridPosition specifies a position on the board grid.
 */
public class GridPosition {
    /**
     * The x axis of the position.
     */
    public int x;

    /**
     * The y axis of the position.
     */
    public int y;

    /**
     * Constructor.
     * @param x The x axis of the position
     * @param y The y axis of the position
     */
    public GridPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        GridPosition p = (GridPosition) o;

        return p.x == this.x && p.y == this.y;
    }
}
