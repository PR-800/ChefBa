/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Font;
import static javax.swing.text.StyleConstants.Size;
import java.awt.event.*;
import java.io.IOException;
import javax.sound.sampled.*;

public class KillShark implements MouseListener{
    private static JFrame frMonster;
    private JLabel lbCount, lbSea;
    private ImageIcon imgSea1, imgSea2;
    private SharkMove lbShark;
    private ClockShark clock;
    private Thread tClock, tShark;
    private static int countdown = 34;
 
    public KillShark(){  
        frMonster = new JFrame();
        clock = new ClockShark();
        tClock = new Thread(clock);
        lbCount = new JLabel("Kill Monster 35 times !");
        lbShark = new SharkMove();
        lbShark.addMouseListener(this);
        tShark = new Thread(lbShark);
        
        imgSea1 = new ImageIcon(getClass().getResource("/objects/sea.jpg"));
        imgSea2 = new ImageIcon(imgSea1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        lbSea = new JLabel(imgSea2);
        lbCount.setFont(new Font("Arial", 1, 28));
       
        frMonster.setLayout(null);
        Dimension sizeMon = lbShark.getPreferredSize();
        lbShark.setBounds(0, 0, sizeMon.width, sizeMon.height);
        
        Dimension sizeCount = lbCount.getPreferredSize();
        lbCount.setBounds(58, 340, sizeCount.width, sizeCount.height);
        
        Dimension sizeSea = lbSea.getPreferredSize();
        lbSea.setBounds(0, 0, sizeSea.width, sizeSea.height);
        
        frMonster.add(clock);
        frMonster.add(lbCount);
        frMonster.add(lbShark);
        frMonster.add(lbSea);
        
        frMonster.setSize(400, 400);
        frMonster.setResizable(false);
        frMonster.setLocationRelativeTo(null);
        
        frMonster.setUndecorated(true);
        frMonster.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frMonster.setVisible(true);
        
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
            Main.class.getResourceAsStream("/sound/wave.wav"));
            clip.open(inputStream);
            clip.start();
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        tClock.start();
        tShark.start();
        
    }
    
    public synchronized void mouseClicked(MouseEvent ev){
        if (countdown > 0){
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                Main.class.getResourceAsStream("/sound/sword.wav"));
                clip.open(inputStream);
                clip.start();
            } 
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
            
            lbCount.setText("You remain _" + countdown + "_ times.");
            this.setCountdown(countdown);
            countdown--;
        }
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public void mousePressed(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    
    public static int getCountDown(){
        return KillShark.countdown;
    }
    public static void setCountdown(int countdown){
        KillShark.countdown = countdown;
    }
    
    public static JFrame getMonFrame(){
        return KillShark.frMonster;
    }
    public static void setMonFrame(JFrame frMonster){
        KillShark.frMonster = frMonster;
    }
//    public static void main(String[] args) {
//        new KillShark();
//    }
}
