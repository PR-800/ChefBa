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

public class DeadMon {
    private JFrame frWin;
    private JLabel lbWin;
    
    public DeadMon(){
        frWin = new JFrame();
        lbWin = new JLabel("YOU WIN !");
        
        frWin.setSize(400, 200);
        frWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frWin.setVisible(true);
        
    }
}
