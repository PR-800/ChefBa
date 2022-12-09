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
import javax.sound.sampled.*;
import javax.swing.*;

public class GameWindow implements ActionListener{
    private JFrame window;
    private Container con;
    private JPanel pTitle, pButton;
    private JLabel lTitle;
    private Font fTitle, fButton;
    private JButton bStart, bQuit, bFull, bExitFull;
    
    private static boolean audioOn = false;
    
    int currentScreenWidth, currentScreenHeight;
//    private boolean fullScreenOn;
//    GraphicsDevice gDevice;
    
    
    public GameWindow() {                
//        GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        gDevice = gEnvironment.getDefaultScreenDevice(); // let graphic device access monitor
//        fullScreenOn = false;
        currentScreenWidth = 1920;
        currentScreenHeight = 1080;
        
        //window
        window = new JFrame("Chef Ba the Master Chef");
        window.setLayout(null);
        window.setSize(currentScreenWidth,currentScreenHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
//        con = window.getContentPane();
        
        createFont();
//        createComponent();

        //title
        pTitle = new JPanel();
        int titleX = (int) Math.round(currentScreenWidth*0.125);
        int titleY = (int) Math.round(currentScreenHeight*0.166);
        int titleW = (int) Math.round(currentScreenWidth*0.75);
        int titleH = (int) Math.round(currentScreenHeight*0.25);
        pTitle.setBounds(titleX, titleY, titleW, titleH);     
        lTitle = new JLabel("CHEF BA");
        lTitle.setForeground(Color.BLACK);
        lTitle.setFont(fTitle);
        pTitle.add(lTitle);
        
        //buttons
        pButton = new JPanel();
        int startX = (int) Math.round(currentScreenWidth*0.375);
        int startY = (int) Math.round(currentScreenHeight*0.58);
        int startW = (int) Math.round(currentScreenWidth*0.25);
        int startH = (int) Math.round(currentScreenHeight*0.25);
        pButton.setBounds(startX, startY, startW, startH);
        
        bStart = new JButton("START");
        bStart.setBackground(Color.BLACK);
        bStart.setForeground(Color.WHITE);
        bStart.setFont(fButton);
        bStart.addActionListener(this);
        
        bQuit = new JButton("QUIT");
        bQuit.setBackground(Color.BLACK);
        bQuit.setForeground(Color.WHITE);
        bQuit.setFont(fButton);
        bQuit.addActionListener(this);
        
//        bFull = new JButton("FULL SCREEN");
//        bFull.setBackground(Color.BLACK);
//        bFull.setForeground(Color.WHITE);
//        bFull.setFont(fButton);
//        bFull.addActionListener(this);
        
        pButton.add(bStart);
        pButton.add(bQuit);
//        pButton.add(bFull);
        
        //container add
        window.add(pTitle);
        window.add(pButton);
        
        window.setVisible(true);
        
        try {
            Clip bgm = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("bgm.wav"));
            bgm.open(inputStream);    
            if (audioOn == false) {
                audioOn = true;
                bgm.start(); 
                bgm.loop(bgm.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void createFont() {
        int titleFontSize = (int) Math.round(currentScreenWidth*0.0875);
        int buttonFontSize = (int) Math.round(currentScreenWidth*0.03125);
        fTitle = new Font("Monospaced", Font.BOLD, titleFontSize);
        fButton = new Font("Monospaced", Font.BOLD, buttonFontSize);
    }
    
//    public void createComponent() {}
//    public void setFullScreen() {
//        fullScreenOn = true;
//        window.remove(pTitle);
//        window.remove(pButton);
//        window.dispose();
//        
//        gDevice.setFullScreenWindow(window);
//        
//        currentScreenWidth = window.getWidth();
//        currentScreenHeight = window.getHeight();
//        
//        createFont();
//        createComponent();
//    }
//    
//    public void endFullScreen() {
//        fullScreenOn = false;
//        window.remove(pTitle);
//        window.remove(pButton);
//        window.dispose();
//        
//        gDevice.setFullScreenWindow(null);
//        
//        currentScreenWidth = 800;
//        currentScreenHeight = 600;
//        
//        createFont();
//        createComponent();
//    }
    
    public static void main(String[] args) {
        new GameWindow();
    }
    
    public JFrame getGameWindow() { return this.window; }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(bFull) && (fullScreenOn == false)) {
//            setFullScreen();
//        }
//        if (e.getSource().equals(bStart) && (fullScreenOn == true)) {
//            endFullScreen();
//        }
        if (e.getSource().equals(bStart)) {          
            window.setVisible(false);
            new CutSceneWindow();
        }
        if (e.getSource().equals(bQuit)) {
            System.exit(0);
        }
    }  
}
