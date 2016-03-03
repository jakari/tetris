package org.janitor.tetris.ui;

import java.awt.*;

/**
 * Creates rectangles based on a given position.
 */
public class RectangleBuilder {
    private Position basePosition;
    private Graphics g;

    /**
     * Constructor.
     * @param color        the color for the rectangles to be created.
     * @param g            Graphics painter.
     * @param basePosition the base position for rectangles.
     */
    public RectangleBuilder(Color color, Graphics g, Position basePosition) {
        this.basePosition = basePosition;
        this.g = g;
        g.setColor(color);
    }

    /**
     * Create a fillrectangle similarly than in the Graphics class, though this
     * creates it relative to the given baseposition and relative to defined
     * pixel size.
     * @param offsetX The X axis offset from base position.
     * @param offsetY The Y axis offset from base position.
     * @param width   Width of the rectangle to create.
     * @param height  Height of the rectangle to create.
     */
    public void fillRect(int offsetX, int offsetY, int width, int height) {
        g.fillRect(
                basePosition.x + CharacterPosition.px(offsetX),
                basePosition.y + CharacterPosition.px(offsetY),
                CharacterPosition.px(width),
                CharacterPosition.px(height)
        );
    }
}
