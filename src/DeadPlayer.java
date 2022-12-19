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

public class DeadPlayer {
    private static JFrame frDeadPlayer;
    private JLabel lbDeadPlayer, lbLoose;
    private ImageIcon imgDeadPlayer1, imgDeadPlayer2;
    
    
    public DeadPlayer(){
        frDeadPlayer = new JFrame();
        imgDeadPlayer1 = new ImageIcon(getClass().getResource("/objects/deadPlayer.jpg"));
        imgDeadPlayer2 = new ImageIcon(imgDeadPlayer1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        lbDeadPlayer = new JLabel(imgDeadPlayer2);
        lbLoose = new JLabel("You are Looser !");
        lbLoose.setFont(new Font("Courier", 1, 40));
        lbLoose.setForeground(Color.BLACK);
        
        frDeadPlayer.setLayout(null);
        Dimension sizeMon = lbDeadPlayer.getPreferredSize();
        lbDeadPlayer.setBounds(0, 0, sizeMon.width, sizeMon.height);
        
        Dimension sizeWin = lbLoose.getPreferredSize();
        lbLoose.setBounds(45, 310, sizeWin.width+10, sizeWin.height);
        
        frDeadPlayer.add(lbLoose);
        frDeadPlayer.add(lbDeadPlayer);
        
        
        frDeadPlayer.setSize(400, 400);
        frDeadPlayer.setResizable(false);
        frDeadPlayer.setLocationRelativeTo(null);
        frDeadPlayer.setUndecorated(true);
        frDeadPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
            Main.class.getResourceAsStream("/sound/lose.wav"));
            clip.open(inputStream);
            clip.start();
            } 
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        frDeadPlayer.setVisible(true);
        
    }
    public static JFrame getDeadPlayer(){
        return DeadPlayer.frDeadPlayer;
    }
//    public static void main(String[] args) {
//        new DeadPlayer();
//    }
}
