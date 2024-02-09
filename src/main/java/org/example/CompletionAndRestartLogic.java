package org.example;

import javax.swing.*;

import static org.example.ComputationLogic.updateScore;
import static org.example.Game_2048.*;
import static org.example.Update_GUI.updateGridLabels;

public class CompletionAndRestartLogic {

    public static boolean isGameOver () {
        if (isGameWon) {
            return true;
        }

        for (int i = 0; i < DIMENSION; i++) {
            for(int j = 0; j < DIMENSION; j++) {
                if (grid[i][j] == 0 ||
                        (i > 0 && grid[i][j] == grid[i-1][j]) ||
                        (i < DIMENSION - 1 && grid[i][j] == grid[i+1][j]) ||
                        (j > 0 && grid[i][j] == grid[i][j-1]) ||
                        (j < DIMENSION - 1 && grid[i][j] == grid[i][j+1])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void showGameOverMessage() {
        String message;
        if (isGameWon) {
            message = "Congratulations! You won the game!\\nDo you want to continue playing?";
        }
        else {
            message = "Game Over! Do you want to play again?";
        }

        int choice = JOptionPane.showConfirmDialog(gridFrame, message, "Game Over", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            restartGame();
        }
        else {
            System.exit(0);
        }

    }

    private static void restartGame() {
        score = 0;
        isGameWon = false;
        updateScore();
        initializeGameGrid();
        updateGridLabels();
    }

}
