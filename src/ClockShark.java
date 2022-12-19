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

public class ClockShark extends JLabel implements Runnable{
    private int sec = 10;
    private int second;
    private int remainTime;
    private static int state = 0;
    private GamePanel gp;
    private MainWindow main;
    
    public void run(){
        try {
            while(sec >= 0){
                Font font = new Font("Arial", Font.BOLD, 25);
                this.setFont(font);
                this.setText(String.format("%02d Seconds", sec));
                Dimension sizeClock = this.getPreferredSize();
                this.setBounds(130, 300, sizeClock.width, sizeClock.height);

                this.setRemainTime(sec);
                if ((this.getRemainTime() >= 0) && (KillShark.getCountDown() <= 0)){ // Win Case
                    state = 1;
                    sec = 0;
                    KillShark.getMonFrame().dispose();
                    new DeadShark();
                    
                    Thread.sleep(2000);
                    DeadShark.getDeadShark().dispose();
                    this.setRemainTime(10);
                    KillShark.setCountdown(35);
                    break;
                }
                else if ((this.getRemainTime() == 0) && (KillShark.getCountDown() > 0)){ // Lost Case
                    state = 2;
                    KillShark.getMonFrame().dispose();
                    new DeadPlayer();
                    
                    Thread.sleep(2000);
                    DeadPlayer.getDeadPlayer().dispose();
                    main = new MainWindow();
                    main.getMainFrame().setVisible(true);
                    
                    this.setRemainTime(10);
                    KillShark.setCountdown(35);
                    break;
                }
                
                Thread.sleep(1000);
                sec--;
            }
        }
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
    }
    
    public synchronized void setRemainTime(int sec){
        this.sec = sec;
    }
    
    public synchronized int getRemainTime(){
        return sec;
    }
}