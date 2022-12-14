/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class SuperObject { // declare variable of obj
    public BufferedImage imageShark, imageOctopus;
    public String name, name2;
    public boolean collision = false;
    public int worldX, worldY;
    
    public void drawShark(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        g2.drawImage(imageShark, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
    
    public void drawOctopus(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        g2.drawImage(imageOctopus, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
