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

public class DeadShark {
    private JFrame frDeadShark;
    private JLabel lbDeadShark, lbWin;
    private ImageIcon imgDeadShark1, imgDeadShark2;
    
    
    public DeadShark(){
        frDeadShark = new JFrame();
        imgDeadShark1 = new ImageIcon("D:\\_second_year\\OOP_Project\\ChefBa\\src\\objects\\deadShark.jpg");
        imgDeadShark2 = new ImageIcon(imgDeadShark1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        lbDeadShark = new JLabel(imgDeadShark2);
        lbWin = new JLabel("You Win !");
        lbWin.setFont(new Font("Courier", 1, 35));
        lbWin.setForeground(Color.white);
        
        frDeadShark.setLayout(null);
        Dimension sizeMon = lbDeadShark.getPreferredSize();
        lbDeadShark.setBounds(0, 0, sizeMon.width, sizeMon.height);
        
        Dimension sizeWin = lbWin.getPreferredSize();
        lbWin.setBounds(120, 320, sizeWin.width+10, sizeWin.height);
        
        frDeadShark.add(lbWin);
        frDeadShark.add(lbDeadShark);
        
        ///////////////// CENTER JFRAME TT ////////////////////
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frDeadShark.getWidth())/2;
        int y = (screenSize.height - frDeadShark.getHeight())/2;
        frDeadShark.setLocation(x, y);
        
        frDeadShark.setSize(415, 430);
        frDeadShark.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frDeadShark.setVisible(true);
        
    }
//    public static void main(String[] args) {
//        new DeadShark();
//    }
}
