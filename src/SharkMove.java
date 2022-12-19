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

public class SharkMove extends JLabel implements Runnable{
    private ImageIcon imgShark, imgShark2;
    
    public SharkMove(){
        imgShark = new ImageIcon(getClass().getResource("/objects/liveShark2.png"));
        imgShark2 = new ImageIcon(imgShark.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        
        this.setIcon(imgShark2);
    }
    
    public void run(){
        int x = 1;
        while(true){
            if (x == 1){
               this.setLocation(0, 10);
               x = 2;
               
            }
            else if(x == 2){
                this.setLocation(-10, 0);
                x = 3;
            }
            else if(x == 3){
                this.setLocation(10, 0);
                x = 1;
            }
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
    }
}
