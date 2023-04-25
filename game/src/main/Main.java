package main;

import main.GamePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);
        okno.setTitle("2dParkour");

        GamePanel gamePanel =new GamePanel();
        okno.add(gamePanel);
        okno.pack();

        okno.setLocationRelativeTo(null);
        okno.setVisible(true);

        gamePanel.startGameThread();



    }
}