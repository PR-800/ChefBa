/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pearita
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CutSceneWindow implements MouseListener{
    private JFrame window;
    private JPanel pSpace, pPic;
    private JLabel lPic;
    private String url;
    private int count = 1;
    
    private GameWindow gameWindow;
    
    private ImageIcon cg;
    private Image img, newimg;
    
    int currentScreenWidth, currentScreenHeight;
    
    public CutSceneWindow() {
        gameWindow = new GameWindow();
        gameWindow.getGameWindow().setVisible(false);
        
        currentScreenWidth = 1600;
        currentScreenHeight = 900;
        
        window = new JFrame("Chef Ba the Master Chef");
        window.setSize(currentScreenWidth,currentScreenHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);   
        window.setBackground(Color.BLACK);
        
        pPic = new JPanel();
        pSpace = new JPanel();
        pPic.setBounds(0, 70, 800, 400);
        pSpace.setBounds(0, 0, 800, 100);
        
        url = "cg1.png";
        cg = new ImageIcon(getClass().getResource(url));
        img = cg.getImage(); // transform it 
        newimg = img.getScaledInstance(800, 390,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        cg = new ImageIcon(newimg);
        
        lPic = new JLabel();
        lPic.setIcon(cg);
        lPic.addMouseListener(this);
        
        pPic.add(lPic);
        
        window.add(pSpace);
        window.add(pPic);
        window.add(pSpace);
        
        window.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        count++;
        switch (count) {
            case 2 -> url = "cg2.png";
            case 3 -> url = "cg3.png";
            case 4 -> url = "cg4.png";
            case 5 -> url = "cg5.png";
            case 6 -> url = "cg6.png";
            case 7 -> {
                gameWindow.getGameWindow().setVisible(true);
                window.setVisible(false);
            }
            default -> {
                url = "cg1.png";
            }
        }
        cg = new ImageIcon(getClass().getResource(url));
        img = cg.getImage(); // transform it 
        newimg = img.getScaledInstance(800, 390,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        cg = new ImageIcon(newimg);
        lPic.setIcon(cg);
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
