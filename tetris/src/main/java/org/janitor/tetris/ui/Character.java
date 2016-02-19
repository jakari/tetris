package org.janitor.tetris.ui;

import java.awt.*;

/**
 * Character painter - paints characters on a given position.
 */
public class Character {
    private Color charColor;

    /**
     * Constructor.
     */
    public Character() {
        charColor = new Color(0xC3FFAF);
    }

    /**
     * paint a dot.
     * @param p the position where to paint the dot
     * @param g The graphics object to use painting on
     */
    public void dot(Position p, Graphics g) {
        g.setColor(charColor);

        g.fillRect(
                p.x + CharacterPosition.px(2) + CharacterPosition.FONT_X,
                p.y + CharacterPosition.px(8),
                1,
                CharacterPosition.px(1)
        );
    }

    /**
     * paint a block.
     * @param p the position where to paint the block
     * @param g The graphics object to use painting on
     */
    public void block(Position p, Graphics g) {
        g.setColor(charColor);
        g.fillRect(
                p.x,
                p.y,
                CharacterPosition.px(5),
                CharacterPosition.px(9)
        );
        g.fillRect(
                p.x + CharacterPosition.FONT_SPACING_X + CharacterPosition.FONT_X,
                p.y,
                CharacterPosition.px(5),
                CharacterPosition.px(9)
        );
    }
}
