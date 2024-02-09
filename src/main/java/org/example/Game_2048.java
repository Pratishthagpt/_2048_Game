package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static org.example.CompletionAndRestartLogic.isGameOver;
import static org.example.CompletionAndRestartLogic.showGameOverMessage;
import static org.example.ComputationLogic.addNewNumber;
import static org.example.ComputationLogic.updateScore;
import static org.example.Update_GUI.updateGridLabels;

public class Game_2048 {
    public static final int DIMENSION = 4;
    public static int [][] grid;
    public static int score;
    public static int maxScore;
    public static JFrame gridFrame;
    public static JPanel gridPanel;
    public static JLabel [][] gridlabels;
    public static JLabel scoreLabel;
    public static JLabel maxScoreLabel;
    public static boolean isGameWon = false;

//    initialize the settings before start of game
    public Game_2048() {
        grid = new int[DIMENSION][DIMENSION];
        score = 0;
        maxScore = 0;
        isGameWon = false;

//        create the GUI Components
        gridFrame = new JFrame("Welcome to 2048 Game!");
        gridFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gridFrame.setSize(500, 600);
        gridFrame.setBackground(Color.DARK_GRAY);
        gridFrame.setLayout(new BorderLayout());

        DropShadowBorder shadowBorder = new DropShadowBorder();

        gridPanel = new JPanel(new GridLayout(DIMENSION, DIMENSION));
        gridPanel.setBorder(shadowBorder);

        gridlabels = new JLabel[DIMENSION][DIMENSION];


        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                gridlabels[i][j] = new JLabel("", JLabel.CENTER);
                gridlabels[i][j].setFont(new Font("Tahoma", Font.BOLD, 30));
                gridlabels[i][j].setOpaque(true);
                gridlabels[i][j].setBackground(Color.lightGray);
                gridPanel.add(gridlabels[i][j]);
            }
        }

//        add the components to Grid Frame
        gridFrame.add(gridPanel, BorderLayout.CENTER);
//        creating the information panel
        JPanel infoPanel = new JPanel(new GridLayout(2,2));
        scoreLabel = new JLabel("Your Score: 0", JLabel.CENTER);
        maxScoreLabel = new JLabel("Max Score: 0", JLabel.CENTER);
        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        maxScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        infoPanel.add(scoreLabel);
        infoPanel.add(maxScoreLabel);

        gridFrame.add(infoPanel, BorderLayout.NORTH);

//        adding key listeners to handle user input
        gridFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    ComputationLogic.moveUp();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    ComputationLogic.moveDown();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    ComputationLogic.moveLeft();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    ComputationLogic.moveRight();
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                updateGridLabels();
                updateScore();
                if (isGameOver()) {
                    showGameOverMessage();
                }
            }
        });

//        setting frame properties and initialize the grid
        gridFrame.setVisible(true);
        gridFrame.setFocusable(true);
        gridFrame.requestFocus();
        initializeGameGrid();
        updateGridLabels();
    }

    public static void initializeGameGrid() {
        for (int i = 0; i < DIMENSION; i++) {
            for(int j = 0; j < DIMENSION; j++) {
                grid[i][j] = 0;
            }
        }

//        adding  two numbers at random places in grid to start the game
        addNewNumber();
        addNewNumber();
    }
}
