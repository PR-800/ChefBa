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
public class MainGame {
    public JFrame Gwindow;
    public GamePanel gamePanel;
    
    public MainGame() {
        Gwindow = new JFrame();
        Gwindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Gwindow.setUndecorated(true);
        
        gamePanel = new GamePanel();
        Gwindow.add(gamePanel);
        
        Gwindow.pack();
        Gwindow.setLocationRelativeTo(null);
        Gwindow.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
    
    public JFrame getGameFrame() { return this.Gwindow; }
    
}
