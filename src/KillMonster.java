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

public class KillMonster implements MouseListener{
    private JFrame frMonster;
    private JLabel lbCount, lbMonster, lbKO;
    private ImageIcon imgMonster1, imgMonster2;
    private Clock clock;
    private Thread tClock;
    private int countdown = 9;
    private static int checkResult = 0;
    
    public KillMonster(){
        frMonster = new JFrame();
        clock = new Clock();
        tClock = new Thread(clock);
        lbCount = new JLabel("Kill Monster 10 times !");
        imgMonster1 = new ImageIcon("D:\\_second_year\\OOP\\Monster\\src\\shark.png");
        imgMonster2 = new ImageIcon(imgMonster1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
        lbMonster = new JLabel(imgMonster2);
        lbMonster.addMouseListener(this);
        lbCount.setFont(new Font("Arial", 1, 25));
        lbKO = new JLabel("KO");
       
        frMonster.setLayout(null);
        Dimension sizeMon = lbMonster.getPreferredSize();
        lbMonster.setBounds(40, 0, sizeMon.width, sizeMon.height);
        frMonster.add(lbMonster);
        
//        Dimension sizeClock = clock.getPreferredSize();
//        clock.setBounds(60, 280, sizeClock.width, sizeClock.height);
        frMonster.add(clock);
        
        Dimension sizeCount = lbCount.getPreferredSize();
        lbCount.setBounds(63, 300, sizeCount.width, sizeCount.height);
        frMonster.add(lbCount);
        
        
        frMonster.setVisible(true);
        frMonster.setSize(400, 400);
        frMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tClock.start();
        
//            if (Kill.getCheckResult() == 1){
//                new DeadMonster();
//            }
//            else if (Kill.getCheckResult() == 2){
//                new DeadMonster();
//            }
    }
    
    public synchronized void mouseClicked(MouseEvent ev){
        if (countdown >= 0){
            if ((clock.getRemainTime() >= 0) && (countdown == 0)){ // Win Case
                clock.setState(1);
                new DeadMon();
            }
            else if ((clock.getRemainTime() == 0) && (countdown > 0)){ // Lost Case
                clock.setState(2);
                new DeadMon();
            }
            else{
                clock.setState(0);
                lbCount.setText("You remain " + countdown + " times.");
                System.out.print(clock.getRemainTime());
                System.out.println(" "+countdown);
            }
        }
        countdown--;
    }
    public void mouseEntered(MouseEvent m){}
    public void mouseExited(MouseEvent m){}
    public void mousePressed(MouseEvent m){}
    public void mouseReleased(MouseEvent m){}
    
    public static void setCheckResult(int checkResult){
        KillMonster.checkResult = checkResult;
    }
    public static int getCheckResult(){
        return KillMonster.checkResult;
    }
    public static void main(String[] args) {
        new KillMonster();
    }
}
