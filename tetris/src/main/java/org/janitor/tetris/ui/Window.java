package org.janitor.tetris.ui;

import javax.swing.*;
import java.awt.*;

/**
 * The actual window where the game is painted.
 */
public class Window implements Runnable {
    private JPanel panel;

    public Window(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Tetris");
        JPanel main = new JPanel();
        frame.setVisible(false);
        main.setBackground(Color.BLACK);

        frame.setLayout(new BorderLayout());

        // To go fullscreen uncomment this
        // Todo still undecided wether fullscreen is desired...
        /*GraphicsDevice gd =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        frame.setUndecorated(true);
        gd.setFullScreenWindow(frame); */

        JPanel center = new JPanel(new GridBagLayout());
        center.add(panel, new GridBagConstraints());
        center.setBackground(Color.black);

        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(center);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
