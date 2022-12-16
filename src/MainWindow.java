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
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

public class MainWindow implements ActionListener, MouseListener, KeyListener{
    //Main
    public JFrame window;
    public JPanel pTitle, pButton;
    public JLabel lTitle, lSubtitle;
    public Font fTitle, fButton;
    public JButton bStart, bQuit, bHow;
    
    //Cutscene
    public JFrame Cwindow;
    public JPanel pPic;
    public JLabel lPic;
    public String url;
    public static int count = 1;
    public BufferedImage cs = null;
    public Image imageCS;
    public ImageIcon iconCS;
    
    //How to play
    public JFrame Hwindow;
    public JPanel pHow;

    //Screen
    public GraphicsEnvironment environment;
    public GraphicsDevice device;
    public GraphicsConfiguration config;
    public int currentScreenWidth, currentScreenHeight;
    
    //Audio
    public static boolean audioOn = false;

    //Menu background
    public BufferedImage bg = null; 
    public Image image;
    public ImageIcon icon;
    
    //check if game is running
    MainGame game;
    public int gameCheck = 0;

    public MainWindow() {     
        //set game invisible
        
        //set fullscreen
        environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = environment.getDefaultScreenDevice();
        config = device.getDefaultConfiguration();
        currentScreenWidth = config.getBounds().width;
        currentScreenHeight = config.getBounds().height;
        
        // **Main** window
        window = new JFrame("Chef Ba the Master Chef");
        window.setLayout(null);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        window.setUndecorated(true);
        window.setFocusable(true);
        
        //background
        try {
            bg = ImageIO.read(getClass().getResourceAsStream("/background/Main.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        image = bg.getScaledInstance(currentScreenWidth, currentScreenHeight, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        
        //font
        int titleFontSize = (int) Math.round(currentScreenWidth*0.0875);
        int buttonFontSize = (int) Math.round(currentScreenWidth*0.03125);
        fTitle = new Font("Monospaced", Font.BOLD, titleFontSize);
        fButton = new Font("Monospaced", Font.BOLD, buttonFontSize);

        //title
        pTitle = new JPanel();
        pTitle.setLayout(new GridLayout(2, 1));
        pTitle.setOpaque(false);
        int titleX = (int) Math.round(currentScreenWidth*0.125);
        int titleY = (int) Math.round(currentScreenHeight*0.20);
        int titleW = (int) Math.round(currentScreenWidth*0.75);
        int titleH = (int) Math.round(currentScreenHeight*0.25);
        pTitle.setBounds(titleX, titleY, titleW, titleH);     
        lTitle = new JLabel("CHEF BA", SwingConstants.CENTER);
        lSubtitle = new JLabel("THE MASTER CHEF", SwingConstants.CENTER);
        lTitle.setForeground(Color.WHITE);
        lTitle.setFont(fTitle);
        lSubtitle.setForeground(Color.WHITE);
        lSubtitle.setFont(fButton);
        pTitle.add(lTitle);
        pTitle.add(lSubtitle);
        
        //buttons
        pButton = new JPanel();
        pButton.setOpaque(false);
        GridLayout layout = new GridLayout(3,1);
        layout.setVgap(8);
        pButton.setLayout(layout);
        int startX = (int) Math.round(currentScreenWidth*0.10);
        int startY = (int) Math.round(currentScreenHeight*0.58);
        int startW = (int) Math.round(currentScreenWidth*0.25);
        int startH = (int) Math.round(currentScreenHeight*0.25);
        pButton.setBounds(startX, startY, startW, startH);
        bStart = new JButton("START");
        bStart.setBackground(Color.BLACK);
        bStart.setForeground(Color.WHITE);
        bStart.setFont(fButton);
        bStart.addActionListener(this);
        bHow = new JButton("HOW TO PLAY");
        bHow.setBackground(Color.BLACK);
        bHow.setForeground(Color.WHITE);
        bHow.setFont(fButton);
        bHow.addActionListener(this);
        bQuit = new JButton("QUIT");
        bQuit.setBackground(Color.BLACK);
        bQuit.setForeground(Color.WHITE);
        bQuit.setFont(fButton);
        bQuit.addActionListener(this);
        pButton.add(bStart);
        pButton.add(bHow);
        pButton.add(bQuit);

        //frame add
        window.setContentPane(new JLabel(icon));
        window.add(pTitle);
        window.add(pButton);
        window.setVisible(true);
        
        //audio
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
        
        // **Cutscene** window
        Cwindow = new JFrame("Chef Ba the Master Chef"); 
        Cwindow.setBackground(Color.BLACK);
        Cwindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        Cwindow.setUndecorated(true);
        
        //picture
        pPic = new JPanel();
        pPic.setBackground(Color.BLACK);
        url = "/background/cutscene1.png";
        try {
            cs = ImageIO.read(getClass().getResourceAsStream(url));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageCS = cs.getScaledInstance(currentScreenWidth, currentScreenHeight, Image.SCALE_SMOOTH);
        iconCS = new ImageIcon(imageCS);
        lPic = new JLabel();
        lPic.setIcon(iconCS);
        lPic.addMouseListener(this);
        pPic.add(lPic);
           
        //frame add
        Cwindow.add(pPic);
        Cwindow.setVisible(false);
        
        // **How to play** window
        Hwindow = new JFrame("Chef Ba the Master Chef"); 
        Hwindow.setBackground(Color.BLACK);
        Hwindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        Hwindow.setUndecorated(true);
        
        //details
        pHow = new JPanel();
        pHow.setLayout(new GridLayout(5,1));
        
        //frame add
        Hwindow.setVisible(false);
    }
    
    public JFrame getMainFrame() { return this.window; }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bStart)) {   
            reScene();
            Cwindow.setVisible(true);
            window.dispose();
        }
        if (e.getSource().equals(bHow)) {
            System.exit(0);
        }
        if (e.getSource().equals(bQuit)) {
            System.exit(0);
        }
    }  

    public void reScene() {
        count = 0;
        url = "/background/cutscene1.png";
        nextScene();
    }
    
    public void nextScene() {
        count++;
        switch (count) {
            case 1 -> url = "/background/cutscene1.png";
            case 2 -> url = "/background/cutscene2.png";
            case 3 -> {
                reScene();
                if(gameCheck == 0) {
                    window.dispose();
                    Cwindow.dispose();
                    game = new MainGame();    //Skip to gameplay
                    gameCheck = 1;
                }
                else {
                    game.getGameFrame();
                }
                
            }
            default -> { url = "/background/cutscene1.png"; }
        }
        try {
            cs = ImageIO.read(getClass().getResourceAsStream(url));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageCS = cs.getScaledInstance(currentScreenWidth, currentScreenHeight, Image.SCALE_SMOOTH);
        iconCS = new ImageIcon(imageCS);
        lPic.setIcon(iconCS);
    }

    @Override public void mouseClicked(MouseEvent e) { nextScene(); }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    @Override public void keyTyped(KeyEvent e) {}

    @Override public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_ENTER) {
            nextScene();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}

}
