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
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class EndingWindow implements MouseListener, KeyListener{
    public JFrame Ewindow;
    public JPanel pPic;
    public JLabel lPic;
    public String url;
    public static int Ecount = 1;
    public BufferedImage cs = null;
    public Image imageCS;
    public ImageIcon iconCS;
    
    private GraphicsEnvironment environment;
    private GraphicsDevice device;
    private GraphicsConfiguration config;
    private int currentScreenWidth, currentScreenHeight;
    
    GamePanel gp;

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
        
        //panel
        pPic = new JPanel();
        pPic.setBackground(Color.BLACK);
        url = "/background/cutscene3.png";
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
        Ewindow.add(pPic);
        Ewindow.addKeyListener(this);
        
        Ewindow.setVisible(true);
    }
    
    public JFrame getEndingWindow() { return this.Ewindow; }
    
    public void reScene() {
        Ecount = 0;
        url = "/background/cutscene1.png";
        nextScene();
    }
    
    public void nextScene() {
        Ecount++;
        switch (Ecount) {
            case 1 -> url = "/background/cutscene3.png";
            case 2 -> url = "/background/cutscene4.png";
            case 3 -> {
                gp = new GamePanel();
                gp.removeAll();
                if(gp.getPlayer().getNumSquid() >= 5 && gp.getPlayer().getNumAnemone() >= 3 && gp.getPlayer().getNumSeagrass2() >= 5) {
                    url = "/background/ending1.png";
                }
                else if(gp.getPlayer().getNumSeagrass2() >= 4 && gp.getPlayer().getNumAnemone() >= 1 && gp.getPlayer().getNumSquid() >= 6) {
                    url = "/background/ending2.png";
                }
                else if(gp.getPlayer().getNumSeagrass2() >= 3 && gp.getPlayer().getNumAnemone() >= 1) {
                    url = "/background/ending3.png";
                }
                else {
                    url = "/background/ending4.png";
                }
                System.out.println("squid = " + gp.getPlayer().getNumSquid());
                System.out.println("anemone = " + gp.getPlayer().getNumAnemone());
                System.out.println("seagrass = " + gp.getPlayer().getNumSeagrass2());
            }
            case 4 -> {
                Ewindow.dispose();
                reScene();
                new MainWindow();   //Back to menu
//                main.getMainFrame().dispose();
//                main.getMainFrame().setVisible(true);    
            }
            default -> { url = "/background/cutscene3.png"; }
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
