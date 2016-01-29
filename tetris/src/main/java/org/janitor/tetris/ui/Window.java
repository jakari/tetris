package org.janitor.tetris.ui;

import javax.swing.*;
import java.awt.*;

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
        System.out.println(panel.isDoubleBuffered());

        GraphicsDevice gd =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        JPanel center = new JPanel(new GridBagLayout());
        center.add(panel, new GridBagConstraints());
        center.setBackground(Color.darkGray);


        // frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(center);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
