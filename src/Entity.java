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
    
<<<<<<< HEAD
    public BufferedImage walkR1, walkR2, walkL1, walkL2;
    public String direction;
=======
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction = "down";
>>>>>>> 364863abdd268f534622493409831fe4880b1c18
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
