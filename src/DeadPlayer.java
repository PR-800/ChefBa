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

public class DeadPlayer {
    private JFrame frDeadShark;
    private JLabel lbDeadShark, lbWin;
    private ImageIcon imgDeadShark1, imgDeadShark2;
    
    
    public DeadPlayer(){
        frDeadShark = new JFrame();
        imgDeadShark1 = new ImageIcon("");
        imgDeadShark2 = new ImageIcon(imgDeadShark1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        lbDeadShark = new JLabel(imgDeadShark2);
        lbWin = new JLabel("You are Looooooser !");
        lbWin.setFont(new Font("Courier", 1, 35));
        lbWin.setForeground(Color.white);
        
        frDeadShark.setLayout(null);
        Dimension sizeMon = lbDeadShark.getPreferredSize();
        lbDeadShark.setBounds(0, 0, sizeMon.width, sizeMon.height);
        
        Dimension sizeWin = lbWin.getPreferredSize();
        lbWin.setBounds(120, 320, sizeWin.width+10, sizeWin.height);
        
        frDeadShark.add(lbWin);
        frDeadShark.add(lbDeadShark);
        
        frDeadShark.setSize(415, 430);
        frDeadShark.setLocationRelativeTo(null);
        frDeadShark.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frDeadShark.setVisible(true);
        
    }
    
    public JFrame getDeadFrame() { return this.frDeadShark; }
//    public static void main(String[] args) {
//        new DeadShark();
//    }
}
