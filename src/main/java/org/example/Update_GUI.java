package org.example;

import java.awt.*;

import static org.example.Game_2048.*;

public class Update_GUI {
    public static void updateGridLabels() {
        TileBorder tileBorder = new TileBorder();
//        updating GUI grid labels with the current grid state
        for(int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (grid[i][j] == 0) {
                    gridlabels[i][j].setText("");
                    gridlabels[i][j].setBackground(Color.lightGray);
                }
                else if (grid[i][j] == 2048) {
                    isGameWon = true;
                    gridlabels[i][j].setText(String.valueOf(grid[i][j]));
                    gridlabels[i][j].setBackground(getTileColor(grid[i][j]));
                }
                else {
                    gridlabels[i][j].setText(String.valueOf(grid[i][j]));
                    gridlabels[i][j].setBackground(getTileColor(grid[i][j]));
                }

                gridlabels[i][j].setBorder(tileBorder);
            }
        }
    }

    public static Color getTileColor (int val) {
        switch (val) {
            case 0:
                return new Color(238, 228, 218, 90);
            case 2:
                return new Color(238, 228, 218);
            case 4:
                return new Color(237, 224, 200);
            case 8:
                return new Color(242, 177, 121);
            case 16:
                return new Color(245, 149, 99);
            case 32:
                return new Color(246, 124, 95);
            case 64:
                return new Color(246, 94, 59);
            case 128:
                return new Color(237, 207, 114);
            case 256:
                return new Color(237, 204, 97);
            case 512:
                return new Color(237, 200, 80);
            case 1024:
                return new Color(237, 197, 63);
            case 2048:
                return new Color(237, 194, 46);
            default:
                return Color.WHITE;
        }
    }
}
