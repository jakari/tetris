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
                p.x + CharacterPosition.px(3) + CharacterPosition.FONT_X,
                p.y + CharacterPosition.px(8),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
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
                CharacterPosition.px(6),
                CharacterPosition.px(10)
        );
        g.fillRect(
                p.x + CharacterPosition.FONT_SPACING_X + CharacterPosition.FONT_X,
                p.y,
                CharacterPosition.px(6),
                CharacterPosition.px(10)
        );
    }

    public void leftBorder(Position p, Graphics g) {
        g.setColor(charColor);
        g.fillRect(
                p.x+CharacterPosition.px(4),
                p.y+CharacterPosition.px(1),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(3),
                p.y+CharacterPosition.px(2),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(2),
                p.y+CharacterPosition.px(3),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(1),
                p.y+CharacterPosition.px(4),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(0),
                p.y+CharacterPosition.px(5),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(1),
                p.y+CharacterPosition.px(6),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(2),
                p.y+CharacterPosition.px(7),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(3),
                p.y+CharacterPosition.px(8),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                p.x+CharacterPosition.px(4),
                p.y+CharacterPosition.px(9),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );

        exclamationMark(
                p.x+CharacterPosition.FONT_X,
                p.y,
                g
        );
    }

    public void rightBorder(Position p, Graphics g) {
        int x = p.x+CharacterPosition.FONT_X;

        g.setColor(charColor);
        g.fillRect(
                x+CharacterPosition.px(0),
                p.y+CharacterPosition.px(1),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(1),
                p.y+CharacterPosition.px(2),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(2),
                p.y+CharacterPosition.px(3),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(3),
                p.y+CharacterPosition.px(4),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(4),
                p.y+CharacterPosition.px(5),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(3),
                p.y+CharacterPosition.px(6),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(2),
                p.y+CharacterPosition.px(7),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(1),
                p.y+CharacterPosition.px(8),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );
        g.fillRect(
                x+CharacterPosition.px(0),
                p.y+CharacterPosition.px(9),
                CharacterPosition.px(1),
                CharacterPosition.px(1)
        );

        exclamationMark(
                p.x,
                p.y,
                g
        );
    }

    public void bottomBorder(Position p, Graphics g) {
        int x2 = p.x + CharacterPosition.FONT_X;
        int y = p.y+CharacterPosition.yCharPosToPx(1);

        equalsSign(p.x, p.y, g);
        equalsSign(x2, p.y, g);

        g.fillRect(
                p.x,
                y,
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                p.x + CharacterPosition.px(1),
                y + CharacterPosition.px(2),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                p.x + CharacterPosition.px(2),
                y + CharacterPosition.px(4),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                p.x + CharacterPosition.px(3),
                y + CharacterPosition.px(6),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                p.x + CharacterPosition.px(4),
                y + CharacterPosition.px(8),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );

        g.fillRect(
                x2+CharacterPosition.px(4),
                y,
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                x2+CharacterPosition.px(3),
                y + CharacterPosition.px(2),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                x2+CharacterPosition.px(2),
                y + CharacterPosition.px(4),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                x2+CharacterPosition.px(1),
                y + CharacterPosition.px(6),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
        g.fillRect(
                x2,
                y + CharacterPosition.px(8),
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
    }

    private void equalsSign(int x, int y, Graphics g) {
        g.fillRect(
                x,
                y+CharacterPosition.px(3),
                CharacterPosition.px(6),
                CharacterPosition.px(2)
        );
        g.fillRect(
                x,
                y+CharacterPosition.px(6),
                CharacterPosition.px(6),
                CharacterPosition.px(2)
        );
    }

    private void exclamationMark(int x, int y, Graphics g) {
        g.fillRect(
            x+CharacterPosition.px(2),
            y,
            CharacterPosition.px(1),
            CharacterPosition.px(7)
        );
        g.fillRect(
            x+CharacterPosition.px(2),
            y+CharacterPosition.px(8),
            CharacterPosition.px(1),
            CharacterPosition.px(2)
        );
    }
}
