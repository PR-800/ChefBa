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

public class MonsterOctopus implements Runnable{
    private JFrame frOctopus;
    private JLabel lbOctopus;
    private ImageIcon imgOctopus, imgOctopus2;
    
    public MonsterOctopus(){
        frOctopus = new JFrame();
        imgOctopus = new ImageIcon("D:\\_second_year\\OOP\\Monster\\src\\shark.png");//change img to octopus png
        imgOctopus2 = new ImageIcon(imgOctopus.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        lbOctopus = new JLabel(imgOctopus2);
        
        frOctopus.add(lbOctopus);
        
        
        frOctopus.setVisible(true);
        frOctopus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frOctopus.setSize(400, 400);
    }
    
    public void run(){
        int x = 1;
        while(true){
            if (x == 1){
               lbOctopus.setLocation(0, 10);
               x = 2;
               
            }
            else if(x == 2){
                lbOctopus.setLocation(-10, 0);
                x = 3;
            }
            else if(x == 3){
                lbOctopus.setLocation(10, 0);
                x = 1;
            }

            try {
                Thread.sleep(300);
            }
            catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
    }
}
