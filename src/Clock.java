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

public class Clock extends JLabel implements Runnable{
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
                this.setBounds(120, 250, sizeClock.width, sizeClock.height);
                second = sec;
                getRemainTime();
               
                if (getState() == 1){
                    sec = 0;
                    KillMonster.setCheckResult(1);
                }
                else if (getState() == 2){
                    KillMonster.setCheckResult(1);
                }
                
                Thread.sleep(1000);
                sec--;
            }
        } 
        catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
    }
    
    public synchronized int getRemainTime(){
        return second;
    }
    
    public synchronized void setState(int state){
        this.state = state;
    }
    public synchronized int getState(){
        return this.state;
    }
}
