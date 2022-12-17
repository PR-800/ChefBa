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

public class ClockOctopus extends JLabel implements Runnable{
    private int sec = 10;
    private int second;
    private int remainTime;
    private int state = 0;
    
    public void run(){
        try {
            while(sec >= 0){
                Font font = new Font("Arial", Font.BOLD, 25);
                this.setFont(font);
                this.setText(String.format("%02d Seconds", sec));
                Dimension sizeClock = this.getPreferredSize();
                this.setBounds(130, 300, sizeClock.width, sizeClock.height);
                this.setForeground(Color.white);

                this.setRemainTime(sec);
                if ((this.getRemainTime() >= 0) && (KillOctopus.getCountDown() <= 0)){ // Win Case
                    state = 1;
                    sec = 0;
                    KillOctopus.getMonFrame().setVisible(false);
                    new DeadOctopus();
                    this.setRemainTime(10);
                    KillOctopus.setCountdown(10);
                    break;
                }
                else if ((this.getRemainTime() == 0) && (KillOctopus.getCountDown() > 0)){ // Lost Case
                    state = 2;
                    KillOctopus.getMonFrame().setVisible(false);
                    new DeadPlayer(); // change to lost page
                    this.setRemainTime(10);
                    KillOctopus.setCountdown(10);
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
