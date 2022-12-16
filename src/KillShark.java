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

public class KillShark implements MouseListener{
    private static JFrame frMonster;
    private JLabel lbCount, lbSea;
    private ImageIcon imgSea1, imgSea2;
    private SharkMove lbShark;
    private Clock clock;
    private Thread tClock, tShark;
    private static int countdown = 9;
    
    public KillShark(){
        frMonster = new JFrame();
        clock = new Clock();
        tClock = new Thread(clock);
        lbCount = new JLabel("Kill Monster 10 times !");
        lbShark = new SharkMove();
        lbShark.addMouseListener(this);
        tShark = new Thread(lbShark);
        
        imgSea1 = new ImageIcon("D:\\_second_year\\OOP_Project\\ChefBa\\src\\objects\\sea.jpg");
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
        
        ///////////////// CENTER JFRAME TT ////////////////////
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frMonster.getWidth())/2;
        int y = (screenSize.height - frMonster.getHeight())/2;
        frMonster.setLocation(x, y);

        frMonster.setVisible(true);
        frMonster.setSize(415, 430);
        frMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tClock.start();
        tShark.start();
        
    }
    
    public synchronized void mouseClicked(MouseEvent ev){
        if (countdown > 0){
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
