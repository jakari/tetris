package org.janitor.tetris.ui;

/**
 * The character position helper class converts a board position.
 *
 * todo This class is not finished, It should be refactored and move the pixel conversion completely away.
 */
public class CharacterPosition extends Position {
    /**
     * Constructor.
     * @param charX A board grid x asis
     * @param charY A board grid y axis
     */
    public CharacterPosition(int charX, int charY) {
        super(xCharPosToPx(charX), yCharPosToPx(charY));
    }

    public static final int PIXEL_SIZE = 2;
    public static final int FONT_X = 6 + 2 + 6;
    public static final int FONT_Y = 10;
    public static final int FONT_SPACING_X = 2;
    public static final int FONT_SPACING_Y = 6;

    /**
     * Converts a pixel to real paintable pixels.
     * @param pixels pixels to convert
     * @return converted pixel size
     */
    public static int px(int pixels) {
        return PIXEL_SIZE * pixels;
    }

    /**
     * Converts a grid pixel x axis to a real paintable pixels.
     * @param x the grid x axis position
     * @return a paintable pixel x axis
     */
    public static int xCharPosToPx(int x) {
        return px((x * FONT_X) + (x * FONT_SPACING_X));
    }

    /**
     * Converts a grid pixel y axis to a real paintable pixels.
     * @param y the grid y axis position
     * @return a paintable pixel y axis
     */
    public static int yCharPosToPx(int y) {
        return px((y * FONT_Y) + (y * FONT_SPACING_Y));
    }
}
