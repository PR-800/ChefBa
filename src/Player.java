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
public class Player extends Entity{
    
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
        jump = 0.0f;
        time = 0.5f;
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
    
    public void setJump(float jump) { this.jump = jump; }
    
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
                        jump+=time;
                        if (jump <= 10.0f) {
                            worldY -= speed*2;
                            break;
                        }
                    case "left" :
                        worldX -= speed;
                        directionImage = "left";
                        break;
                    case "right":
                        worldX += speed;
                        directionImage = "right";
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
                    setJump(0);
                    break;
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;
        
        switch (directionImage) {
            case "up":
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
                break;
            case "down":
                image = walkR2;
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
    }
}
