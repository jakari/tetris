package org.janitor.tetris.ui;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class CharacterTest {
    private int x = 10;
    private int y = 20;
    private Character character;
    private Graphics g;
    private Position p;
    private Color color;

    @Before
    public void setUp() {
        character = new Character();
        g = mock(Graphics.class);
        p = mock(Position.class);
        p.x = x;
        p.y = y;
        color = new Color(0xC3FFAF);
    }

    @Test
    public void createsDot() {
        character.dot(p, g);

        verify(g).setColor(color);
        verify(g).fillRect(
                p.x + CharacterPosition.px(3)+CharacterPosition.FONT_X,
                p.y + CharacterPosition.px(8),
                2,
                4
        );
    }

    @Test
    public void createsBlock() {
        character.block(p, g);

        verify(g).setColor(color);
        verify(g).fillRect(
                x,
                y,
                CharacterPosition.PIXEL_SIZE*6,
                CharacterPosition.PIXEL_SIZE*10
        );
    }
}
