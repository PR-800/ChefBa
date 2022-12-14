/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Fluk
 */
public class Entity {
    
    public int worldX, worldY;
    public int speed;
    public float jump, time;
    
    public BufferedImage walkR1, walkR2, walkL1, walkL2;
    public String direction;
    public String directionImage = "down";
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public boolean collisionOn = false;
    
    public static boolean audioOn = false;
    
    public int checkJump = 0;
}
