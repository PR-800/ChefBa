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
import javax.sound.sampled.*;

public class DeadOctopus {
    private static JFrame frDeadOctopus;
    private JLabel lbDeadOctopus, lbWin;
    private ImageIcon imgDeadOctopus1, imgDeadOctopus2;
    
    
    public DeadOctopus(){
        frDeadOctopus = new JFrame();
        imgDeadOctopus1 = new ImageIcon(getClass().getResource("/objects/deadOctopus.jpg"));
        imgDeadOctopus2 = new ImageIcon(imgDeadOctopus1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        lbDeadOctopus = new JLabel(imgDeadOctopus2);
        lbWin = new JLabel("You Win !");
        lbWin.setFont(new Font("Courier", 1, 45));
        lbWin.setForeground(Color.white);
        
        frDeadOctopus.setLayout(null);
        Dimension sizeMon = lbDeadOctopus.getPreferredSize();
        lbDeadOctopus.setBounds(0, 0, sizeMon.width, sizeMon.height);
        
        Dimension sizeWin = lbWin.getPreferredSize();
        lbWin.setBounds(100, 330, sizeWin.width+10, sizeWin.height);
        
        frDeadOctopus.add(lbWin);
        frDeadOctopus.add(lbDeadOctopus);
        
        frDeadOctopus.setSize(400, 400);
        frDeadOctopus.setResizable(false);
        frDeadOctopus.setLocationRelativeTo(null);
        frDeadOctopus.setUndecorated(true);
        frDeadOctopus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
            Main.class.getResourceAsStream("/sound/win.wav"));
            clip.open(inputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
            clip.start();
            } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        frDeadOctopus.setVisible(true);
        
    }
    public static JFrame getDeadOct(){
        return DeadOctopus.frDeadOctopus;
    }
//    public static void main(String[] args) {
//        new DeadOctopus();
//    }
}
