package org.example;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Point2D;

public class DropShadowBorder implements Border {

    private static final int SHADOW_SIZE = 10;
    private static final Color SHADOW_COLOR_START = new Color(0, 0, 0, 100);
    private static final Color SHADOW_COLOR_END = new Color(0, 0, 0, 0);


    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        // Create a gradient paint for the shadow effect
        Paint paint = new LinearGradientPaint(
                new Point2D.Double(x, y),
                new Point2D.Double(x, y + height),
                new float[]{0.0f, 1.0f},
                new Color[]{SHADOW_COLOR_START, SHADOW_COLOR_END}
        );

        // Set the gradient paint
        g2d.setPaint(paint);

        // Fill the rectangle with the gradient shadow
        g2d.fillRect(x, y, width, height);

        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(SHADOW_SIZE, SHADOW_SIZE, SHADOW_SIZE, SHADOW_SIZE);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
