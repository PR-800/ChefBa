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

public class MainWindow implements ActionListener, MouseListener, KeyListener{
    //Main
    private JFrame window;
    private Container con;
    private JPanel pTitle, pButton;
    private JLabel lTitle;
    private Font fTitle, fButton;
    private JButton bStart, bQuit, bFull, bExitFull;
    
    //Cutscene
    private JFrame Cwindow;
    private JPanel pSpace, pPic;
    private JLabel lPic;
    private String url;
    private static int count = 1;
    private ImageIcon cs;
    private Image img, newimg;

    //Screen
    private GraphicsEnvironment environment;
    private GraphicsDevice device;
    private GraphicsConfiguration config;
    private int currentScreenWidth, currentScreenHeight;
    
    //Audio
    private static boolean audioOn = false;

    public MainWindow() {       
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

        //font
        int titleFontSize = (int) Math.round(currentScreenWidth*0.0875);
        int buttonFontSize = (int) Math.round(currentScreenWidth*0.03125);
        fTitle = new Font("Monospaced", Font.BOLD, titleFontSize);
        fButton = new Font("Monospaced", Font.BOLD, buttonFontSize);

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
        GridLayout layout = new GridLayout(2,1);
        layout.setVgap(10);
        pButton.setLayout(layout);
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
        pButton.add(bStart);
        pButton.add(bQuit);

        //frame add
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
        url = "cg1.png";
        cs = new ImageIcon(getClass().getResource(url));
        img = cs.getImage(); // transform it 
        newimg = img.getScaledInstance(currentScreenWidth, currentScreenHeight,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        cs = new ImageIcon(newimg);
        lPic = new JLabel();
        lPic.setIcon(cs);
        lPic.addMouseListener(this);
        pPic.add(lPic);
        
        //frame add
        Cwindow.add(pPic);
        Cwindow.addKeyListener(this);
        Cwindow.setVisible(false);
    }
    
    public JFrame getMainWindow() { return this.window; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bStart)) {   
            reScene();
            Cwindow.setVisible(true);
            window.setVisible(false);
        }
        if (e.getSource().equals(bQuit)) {
            System.exit(0);
        }
    }  
    
    public void reScene() {
        count = 0;
        url = "cg1.png";
        nextScene();
    }
    
    public void nextScene() {
        count++;
        switch (count) {
            case 1 -> url = "cg1.png";
            case 2 -> url = "cg2.png";
            case 3 -> url = "cg3.png";
            case 4 -> url = "cg4.png";
            case 5 -> url = "cg5.png";
            case 6 -> url = "cg6.png";
            case 7 -> {
                reScene();
                window.setVisible(true);    // ** Skip to gameplay
                Cwindow.setVisible(false);
            }
            default -> { url = "cg1.png"; }
        }
        cs = new ImageIcon(getClass().getResource(url));
        img = cs.getImage(); // transform it 
        newimg = img.getScaledInstance(currentScreenWidth, currentScreenHeight,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        cs = new ImageIcon(newimg);
        lPic.setIcon(cs);
    }

    @Override public void mouseClicked(MouseEvent e) { nextScene(); }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 10 -> { //enter
                int skip = JOptionPane.showConfirmDialog(null, "Skip cutscene", "Confirm Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(skip == JOptionPane.YES_OPTION) {
                    reScene();
                    window.setVisible(true);    // ** Skip to gameplay
                    Cwindow.setVisible(false);
                }                      
            }
            case 27 -> { //esc
                int skip = JOptionPane.showConfirmDialog(null, "Go to Main Menu", "Confirm Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(skip == JOptionPane.YES_OPTION) {
                    reScene();
                    window.setVisible(true);
                    Cwindow.setVisible(false);
                }                      
            }
            default -> nextScene();
        }
//        System.out.println(e.getKeyCode());
    }
    
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
