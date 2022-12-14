/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Fluk
 */
public class MainGame extends MainWindow implements KeyListener{
    public JFrame Gwindow;
    public GamePanel gamePanel;
    
    public MainGame() {
        Gwindow = new JFrame();
        Gwindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Gwindow.setUndecorated(true);
        
        gamePanel = new GamePanel();
        Gwindow.add(gamePanel);
        gamePanel.addKeyListener(this);
        
        Gwindow.pack();
        Gwindow.setLocationRelativeTo(null);
        Gwindow.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 27 -> { //esc
                int skip = JOptionPane.showConfirmDialog(null, "Exit game", "Confirm Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(skip == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }                      
            }
        }
//        System.out.println(e.getKeyCode());
    }
    
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    public static void main(String[] args) {
        new MainGame();
    }
}
