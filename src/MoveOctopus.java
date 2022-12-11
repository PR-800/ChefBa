/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoveOctopus{
    private MonsterOctopus octopus;
    private Thread tOctopus;
    
    public MoveOctopus(){
        octopus = new MonsterOctopus();
        tOctopus = new Thread(octopus);
        tOctopus.start();
    }
}
