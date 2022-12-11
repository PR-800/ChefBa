/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pearita
 */

import java.awt.*;
import javax.swing.JFrame;

public class EndingWindow {
    private JFrame Ewindow;
    
    private GraphicsEnvironment environment;
    private GraphicsDevice device;
    private GraphicsConfiguration config;
    private int currentScreenWidth, currentScreenHeight;
    
    public EndingWindow() {
        //set fullscreen
        environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = environment.getDefaultScreenDevice();
        config = device.getDefaultConfiguration();
        currentScreenWidth = config.getBounds().width;
        currentScreenHeight = config.getBounds().height;
        System.out.println(currentScreenHeight + " " + currentScreenWidth);
        
        //window
        Ewindow = new JFrame();
        Ewindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        Ewindow.setUndecorated(true);
        
        Ewindow.setVisible(true);
    }
    
    public JFrame getEndingWindow() { return this.Ewindow; }
}
