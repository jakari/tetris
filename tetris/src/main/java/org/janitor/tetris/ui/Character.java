package org.janitor.tetris.ui;

import java.awt.*;

public class Character {
    private Color charColor;

    public Character() {
        charColor = new Color(0xC3FFAF);
    }

    public void dot(Position p, Graphics g) {
        g.setColor(charColor);

        g.fillRect(
                p.x+3,
                p.y+7,
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );

        g.fillRect(
                p.x+CharacterPosition.FONT_SPACING_X+CharacterPosition.FONT_X,
                p.y+7,
                CharacterPosition.px(1),
                CharacterPosition.px(2)
        );
    }

    public void block(Position p, Graphics g) {
        g.setColor(charColor);
        g.fillRect(
                p.x,
                p.y,
                CharacterPosition.px(5),
                CharacterPosition.px(9)
        );
        g.fillRect(
                p.x+CharacterPosition.FONT_SPACING_X+CharacterPosition.FONT_X,
                p.y,
                CharacterPosition.px(5),
                CharacterPosition.px(9)
        );
    }
}