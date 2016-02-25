package org.janitor.tetris.ui;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterPositionTest {
    @Test
    public void calculatesPixelPosition() {
        assertEquals(20, CharacterPosition.px(10));
    }

    @Test
    public void calculateCharacterPositionInPixels() {
        int x = 10;
        int y = 5;

        CharacterPosition p = new CharacterPosition(x, y);
        assertEquals(320, p.x);
        assertEquals(160, p.y);
    }
}
