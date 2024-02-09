package org.example;

import java.util.Random;

import static org.example.Game_2048.*;

public class ComputationLogic {
    private static Random random = new Random();

    public static void moveUp() {
//        means that the tile moves and merges with the tile upwards
        int prevScore = score;
        boolean isTileMoved = false;
        for (int j = 0; j < DIMENSION; j++) {
//            int mergeValue = -1;
            for (int i = 1; i < DIMENSION; i++) {
                if (grid[i][j] != 0) {
                    int row = i;
                    while (row > 0 && (grid[row - 1][j] == 0 || grid[row - 1][j] == grid[row][j])) {
//                        if (grid[row - 1][j] == grid[row][j] && mergeValue != row - 1) {
                        if (grid[row - 1][j] == grid[row][j]) {
                            grid[row - 1][j] *= 2;
                            score += grid[row - 1][j];
                            grid[row][j] = 0;
//                            mergeValue = row - 1;
                            isTileMoved = true;
                        } else if (grid[row - 1][j] == 0) {
                            grid[row - 1][j] = grid[row][j];
                            grid[row][j] = 0;
                            isTileMoved = true;
                        }
                        row--;
                    }
                }
            }
        }
        if (isTileMoved) {
            addNewNumber();
            updateScore();
        }
    }

    public static void moveDown() {
//        means that the tile moves and merges with the tile downwards
        int prevScore = score;
        boolean isTileMoved = false;
        for (int j = 0; j < DIMENSION; j++) {
//            int mergeValue = -1;
            for (int i = DIMENSION - 2; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    int row = i;
                    while (row < DIMENSION - 1 && (grid[row + 1][j] == 0 || grid[row + 1][j] == grid[row][j])) {
                        if (grid[row + 1][j] == grid[row][j] ) {
                            grid[row + 1][j] *= 2;
                            score += grid[row + 1][j];
                            grid[row][j] = 0;
//                            mergeValue = row + 1;
                            isTileMoved = true;
                        } else if (grid[row + 1][j] == 0) {
                            grid[row + 1][j] = grid[row][j];
                            grid[row][j] = 0;
                            isTileMoved = true;
                        }
                        row++;
                    }
                }
            }
        }
        if (isTileMoved) {
            addNewNumber();
            updateScore();
        }
    }

    public static void moveLeft() {
//        means that the tile moves and merges with the tile towards left
        int prevScore = score;
        boolean isTileMoved = false;
        for (int i = 0; i < DIMENSION; i++) {
//            int mergeValue = -1;
            for (int j = 1; j < DIMENSION; j++) {
                if (grid[i][j] != 0) {
                    int col = j;
                    while (col > 0 && (grid[i][col - 1] == 0 || grid[i][col - 1] == grid[i][col])) {
                        if (grid[i][col - 1] == grid[i][col]) {
                            grid[i][col - 1] *= 2;
                            score += grid[i][col - 1];
                            grid[i][col] = 0;
//                            mergeValue = col - 1;
                            isTileMoved = true;
                        } else if (grid[i][col - 1] == 0) {
                            grid[i][col - 1] = grid[i][col];
                            grid[i][col] = 0;
                            isTileMoved = true;
                        }
                        col--;
                    }
                }
            }
        }
        if (isTileMoved) {
            addNewNumber();
            updateScore();
        }
    }

//        means that the tile moves and merges with the tile towards right
    public static void moveRight() {
        int prevScore = score;
        boolean isTileMoved = false;
        for (int i = 0; i < DIMENSION; i++) {
//            int mergeValue = -1;
            for (int j = DIMENSION - 2; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    int col = j;
                    while (col < DIMENSION - 1 && (grid[i][col + 1] == 0 || grid[i][col + 1] == grid[i][col])) {
                        if (grid[i][col + 1] == grid[i][col] ) {
                            grid[i][col + 1] *= 2;
                            score += grid[i][col + 1];
                            grid[i][col] = 0;
//                            mergeValue = col + 1;
                            isTileMoved = true;
                        } else if (grid[i][col + 1] == 0) {
                            grid[i][col + 1] = grid[i][col];
                            grid[i][col] = 0;
                            isTileMoved = true;
                        }
                        col++;
                    }
                }
            }
        }
        if (isTileMoved) {
            addNewNumber();
            updateScore();
        }
    }

    public static void updateScore() {
        scoreLabel.setText("Score: " + score);
        if(score > Best) {
            Best = score;
            BestScoreLabel.setText("Max Score: " + Best);
        }
    }

    public static void addNewNumber() {
        int row , col ;

        do {
            // Generate random row and column indices
            row = random.nextInt(DIMENSION);
            col = random.nextInt(DIMENSION);
        } while (grid[row][col] != 0);

//        assigning a new number 2 or 4 to the empty cell
        grid[row][col] = (random.nextInt(2) + 1) * 2;
    }
}
