package org.janitor.tetris.ui;

import org.janitor.tetris.ui.Position;

public class CharacterPosition extends Position {
    public CharacterPosition(int charX, int charY) {
        super(xCharPosToPx(charX), yCharPosToPx(charY));
    }

    public static int PIXEL_SIZE = 2;
    public static int FONT_X = 5;
    public static int FONT_Y = 9;
    public static int FONT_SPACING_X = 2;
    public static int FONT_SPACING_Y = 5;

    public static int px(int pixels) {
        return PIXEL_SIZE*pixels;
    }

    private static int xCharPosToPx(int x) {
        return px((x*FONT_X)+(x * FONT_SPACING_X));
    }

    private static int yCharPosToPx(int y) {
        return px((y * FONT_Y) + (y * FONT_SPACING_Y));
    }
}
