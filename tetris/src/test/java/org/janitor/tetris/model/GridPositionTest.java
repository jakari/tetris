package org.janitor.tetris.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GridPositionTest {
    @Test
    public void gridPositionEquals() {
        GridPosition p1 = new GridPosition(1, 2);
        GridPosition p2 = new GridPosition(2, 1);
        GridPosition p3 = new GridPosition(1, 2);

        assertTrue(p1.equals(p3));
        assertFalse(p1.equals(p2));

        assertFalse(p1.equals(new String("1, 2")));
    }
}
