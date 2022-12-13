/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


/**
 *
 * @author Fluk
 */
public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2;
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height= 32;
        
        setDefaultValues();
        getPlayerImage();
        
    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 12;
        worldY = gp.tileSize * 9;
        speed = 5;
        direction = "down";
    }
    
    public void getPlayerImage() {
        
        try {
            
            walkR1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkR1.png"));
            walkR2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkR2.png"));
            walkL1 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkL1.png"));
            walkL2 = ImageIO.read(getClass().getResourceAsStream("/res/player/walkL2.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
 
//        worldY += speed; 
        if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.leftPressed == true || keyH.rightPressed == true){
            
            if(keyH.upPressed == true) {
                direction = "up";
            }
            else if(keyH.downPressed == true) {
                direction = "down";
            }
            else if(keyH.leftPressed == true) {
                direction = "left";
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
            }
            
            //Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //If Collision is False, Player can move
            
                
        if(collisionOn == false){
//            worldY += speed;
            gp.cChecker.checkTile(this);
            
            switch(direction){
                case "up":
    //                    worldY -= speed*2;
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                }
                
                spriteCounter++;
                if (spriteCounter > 10) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    }
                    else if (spriteNum == 2) {
                    spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
           }
        }  
//        }
//        else {
            //Check Tile Collision
//            collisionOn = false;
//            gp.cChecker.checkTile(this);
//            if(collisionOn == false)
//                worldY += speed; 
    }
    
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;
        
        switch (direction) {
            case "up":
                image = walkR1;
                break;
            case "down":
                image = walkR1;
                break;
            case "left":
                if (spriteNum == 1) {
                    image = walkL1;
                }
                if (spriteNum == 2) {
                    image = walkL2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = walkR1;
                }
                if (spriteNum == 2) {
                    image = walkR2;
                }
        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
    }
}
