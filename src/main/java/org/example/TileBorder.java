package org.example;

import javax.swing.border.Border;
import java.awt.*;

public class TileBorder implements Border {

    private static final int THICKNESS = 10;
    private static final int RADIUS = 20;

    private static final Color color = new Color(0, 0, 0, 100);


    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        // Set the color
        g.setColor(color);
//        Setting top border
        g.fillRoundRect(x, y, width, THICKNESS, RADIUS, RADIUS);
//        Setting left border
        g.fillRoundRect(x, y, THICKNESS, height, RADIUS, RADIUS);
//        Setting bottom border
        g.fillRoundRect(x, y + height - THICKNESS, width, THICKNESS, RADIUS, RADIUS);
//        Setting right border
        g.fillRoundRect(x + width - THICKNESS, y, THICKNESS, height, RADIUS, RADIUS);

    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(THICKNESS, THICKNESS, THICKNESS, THICKNESS);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
