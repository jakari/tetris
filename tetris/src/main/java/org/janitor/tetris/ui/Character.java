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
        RectangleBuilder builder = new RectangleBuilder(charColor, g, p);
        builder.fillRect(0, 0, 6, 10);
        g.fillRect(
                p.x + CharacterPosition.FONT_SPACING_X + CharacterPosition.FONT_X,
                p.y,
                CharacterPosition.px(6),
                CharacterPosition.px(10)
        );
    }

    /**
     * Writes a left border character.
     * @param p Position of character
     * @param g Graphics to draw to
     */
    public void leftBorder(Position p, Graphics g) {
        RectangleBuilder builder = new RectangleBuilder(charColor, g, p);
        builder.fillRect(4, 1, 1, 1);
        builder.fillRect(3, 2, 1, 1);
        builder.fillRect(2, 3, 1, 1);
        builder.fillRect(1, 4, 1, 1);
        builder.fillRect(0, 5, 1, 1);
        builder.fillRect(1, 6, 1, 1);
        builder.fillRect(2, 7, 1, 1);
        builder.fillRect(3, 8, 1, 1);
        builder.fillRect(4, 9, 1, 1);

        exclamationMark(
            new Position(p.x + CharacterPosition.FONT_X, p.y),
            g
        );
    }

    /**
     * Creates a right border character.
     * @param p Position of character
     * @param g Graphics to draw to
     */
    public void rightBorder(Position p, Graphics g) {
        Position basePosition =
                new Position(p.x + CharacterPosition.FONT_X, p.y);
        RectangleBuilder builder = new RectangleBuilder(charColor, g, basePosition);

        builder.fillRect(0, 1, 1, 1);
        builder.fillRect(1, 2, 1, 1);
        builder.fillRect(2, 3, 1, 1);
        builder.fillRect(3, 4, 1, 1);
        builder.fillRect(4, 5, 1, 1);
        builder.fillRect(3, 6, 1, 1);
        builder.fillRect(2, 7, 1, 1);
        builder.fillRect(1, 8, 1, 1);
        builder.fillRect(0, 9, 1, 1);

        exclamationMark(p, g);
    }

    /**
     * Draws a bottom border character.
     * @param p Position of character
     * @param g Graphics to draw to
     */
    public void bottomBorder(Position p, Graphics g) {
        int x2 = p.x + CharacterPosition.FONT_X;
        int y = p.y + CharacterPosition.yCharPosToPx(1);

        Position leftBasePosition = new Position(p.x, y);
        Position rightBasePosition = new Position(x2, y);
        RectangleBuilder leftBuilder = new RectangleBuilder(
            charColor,
            g,
            leftBasePosition
        );
        RectangleBuilder rightBuilder = new RectangleBuilder(
            charColor,
            g,
            rightBasePosition
        );

        leftBuilder.fillRect(0, 0, 1, 2);
        leftBuilder.fillRect(1, 2, 1, 2);
        leftBuilder.fillRect(2, 4, 1, 2);
        leftBuilder.fillRect(3, 6, 1, 2);
        leftBuilder.fillRect(4, 8, 1, 2);

        equalsSign(new Position(p.x, p.y), g);
        equalsSign(new Position(x2, p.y), g);

        rightBuilder.fillRect(4, 0, 1, 2);
        rightBuilder.fillRect(3, 2, 1, 2);
        rightBuilder.fillRect(2, 4, 1, 2);
        rightBuilder.fillRect(1, 6, 1, 2);
        rightBuilder.fillRect(0, 8, 1, 2);
    }

    private void equalsSign(Position p, Graphics g) {
        RectangleBuilder builder = new RectangleBuilder(charColor, g, p);
        builder.fillRect(0, 3, 6, 2);
        builder.fillRect(0, 6, 6, 2);
    }

    private void exclamationMark(Position p, Graphics g) {
        RectangleBuilder builder = new RectangleBuilder(charColor, g, p);
        builder.fillRect(2, 0, 1, 7);
        builder.fillRect(2, 8, 1, 2);
    }
}
