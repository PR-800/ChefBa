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

public class MonsterShark implements Runnable{
    private JFrame frShark;
    private JLabel lbShark;
    private ImageIcon imgShark, imgShark2;
    
    public MonsterShark(){
        frShark = new JFrame();
        imgShark = new ImageIcon(getClass().getResource("shark.png"));
        imgShark2 = new ImageIcon(imgShark.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        lbShark = new JLabel(imgShark2);
        
        frShark.add(lbShark);
        
        
        frShark.setVisible(true);
        frShark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frShark.setSize(400, 400);
    }
    
    public void run(){
        int x = 0;
        while(true){
            if (x%2 == 0){
               lbShark.setLocation(0, 20);
               
            }
            else{
                lbShark.setLocation(0, -20);
            }
            x++;
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
    }
}
