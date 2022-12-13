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
//        screenX = gp.screenWidth + (gp.tileSize*(gp.screenWidth));
        screenY = gp.screenHeight/2;
        
        System.out.println(gp.screenWidth);
        
        solidArea = new Rectangle();
        solidArea.x = 17;
        solidArea.y = 18;
        solidArea.width = 28;
        solidArea.height= 34;
        
        setDefaultValues();
        getPlayerImage();
        
    }
    public void setDefaultValues() {
        //player position
        worldX = gp.tileSize * 12;
        worldY = gp.tileSize * 9;
        speed = 6;
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
        if(keyH.upPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){   
            if(keyH.upPressed == true) {
                direction = "up";
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
                switch(direction){
                    case "up":
                        worldY -= speed*2;
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
                
                direction = "down";
            }
        }  
        gp.cChecker.checkTile(this);
        if (collisionOn == false) {
            switch(direction){
                case "down":
                    worldY += speed;
                    break;
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;
        
//        switch (direction) {
//            case "up":
//                image = walkR1;
//                break;
//            case "left":
//                if (spriteNum == 1) {
//                    image = walkL1;
//                }
//                if (spriteNum == 2) {
//                    image = walkL2;
//                }
//                break;
//            case "right":
//                if (spriteNum == 1) {
//                    image = walkR1;
//                }
//                if (spriteNum == 2) {
//                    image = walkR2;
//                }
//            case "down":
//                image = walkR1;
//                break;
//        }
        
        if (direction.equals("up")) { 
            image = walkR1; 
        }
        else if (direction.equals("left")) { 
            if (spriteNum == 1) {
                image = walkL1;
            }
            if (spriteNum == 2) {
                image = walkL2;
            }
        }
        else if (direction.equals("right")) { 
            if (spriteNum == 1) {
                image = walkR1;
            }
            if (spriteNum == 2) {
                image = walkR2;
            }
        }
        else if (direction.equals("down")) { 
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
