/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.sound.sampled.*;

/**
 *
 * @author Fluk
 */
public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public int numSquid = 0;
    public int numAnemone = 0;
    public int numSeagrass2 = 0;
    
    public int x, y;
    
    public boolean isJumping = false;
    public int jumpCounter = 0;
    public double falling = 0.0;
 
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
//        screenX = gp.screenWidth + (gp.tileSize*(gp.screenWidth));
        screenY = gp.screenHeight/2;
        
        System.out.println(gp.screenWidth);
        
        solidArea = new Rectangle();
        solidArea.x = 18;
        solidArea.y = 25;
        solidArea.width = 40;
        solidArea.height= 57;
        hitBoxX = new Rectangle(10, 30, 58, 35);
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        setDefaultValues();
        getPlayerImage();
        
    }
    
    public int getNumSquid() { return this.numSquid; }
    public int getNumAnemone() { return this.numAnemone; }
    public int getNumSeagrass2() { return this.numSeagrass2; }
    
    public void setDefaultValues() {
        //player position
//        worldX = gp.tileSize * 12;
//        worldY = gp.tileSize * 9;
        //check ending
//        worldX = gp.tileSize * 60;
//        worldY = gp.tileSize * 40;

//        worldX = gp.tileSize * 40;
//        worldY = gp.tileSize * 24;

        // check Mon
        worldX = gp.tileSize * 52;
        worldY = gp.tileSize * 11;
        
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
    
    public void update() throws InterruptedException {
        
        if (isJumping) {
                jumpCounter++;
                if (jumpCounter < 18) {             //time floating     default -> 18
                    audioOn = false;
                    if (!topHit) {
                        worldY -= speed *3/2;
                    }
                    else if (topHit || leftHit || rightHit) {
                        jumpCounter = 0;
                        isJumping = false;
                    }
                } else {
                    jumpCounter = 0;
                    isJumping = false;
                }
            } else if (!bottomHit) {
//                worldY += speed *7/4;
                worldY += speed *3/2;
                falling += 0.00;
//                System.out.println(falling);
            } else {
                falling = 0;
            }
        
        if(keyH.upPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){ 
            if((keyH.upPressed == true) && (keyH.leftPressed == true) ) {
                direction = "upleft";
            }
            else if((keyH.upPressed == true) && (keyH.rightPressed == true) ) {
                direction = "upright";
            }
            else if(keyH.upPressed == true) {
                direction = "up";
            }
            else if(keyH.leftPressed == true) {
                direction = "left";
            }
            else if(keyH.rightPressed == true) {
                direction = "right";
            }
            
            
            // Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // check obj collision
            int obj1Index = gp.cChecker.checkObject(this, true);
            killShark(obj1Index);
            int obj2Index = gp.cChecker.checkObject2(this, true);
            killOctopus(obj2Index);
            
            // check item collision
            int item1Index = gp.cChecker.checkItem1(this, true);
            pickUpItem1(item1Index);
            int item2Index = gp.cChecker.checkItem2(this, true);
            pickUpItem2(item2Index);
            int item4Index = gp.cChecker.checkItem4(this, true);
            pickUpItem4(item4Index);
                  
                    if (keyH.upPressed){
                        direction = "up";
                        if (bottomHit) {
                            jump();
                                try {
                                Clip bgm = AudioSystem.getClip();
                                AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sound/jump.wav"));
                                bgm.open(inputStream);
                                if (audioOn == false) {
                                    audioOn = true;
                                    bgm.start(); 
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    }
                    if (keyH.downPressed) {
                        direction = "down";
                        if (!bottomHit) {
                            worldY += speed;
                        }
                    }
                    if (keyH.rightPressed) {
                        direction = "right";
                        if (isJumping) {
                            directionImage = "up";
                        }
                        else {
                            directionImage = "right";
                        }
                        
                        if (!rightHit) {
                            worldX += speed;
                        }
                        else {
                            if (vineLeft) {
                                worldY += speed/(3/2);
                                jump();
                            }
                        }
                    }
                    if (keyH.leftPressed) {
                        direction = "left";
                        if (isJumping) {
                            directionImage = "down";
                        }
                        else {
                            directionImage = "left"; 
                        }
                           
                        if (!leftHit) {
                            worldX -= speed;
                        }
                        else {
                            if (vineRight) {
                                worldY += speed/(3/2);
                                jump();
                            }
                        }
                    }
            
            
            //If Collision is False, Player can move  
            if(collisionOn == false){
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
//        if (collisionOn == false) {
//            switch(direction){
//                case "down":
//                    worldY += speed;
//                    break;
//            }
//        }
//        else {
//            if (jump > 11.0f) {
//                setJump(0);
//                audioOn = false;
//            }
//        }
        
        //Check died
        if (trapTop || trapBottom || trapLeft || trapRight) {
            gp.gameState = gp.gameOverState;
        }
        
        //Warp
        if (warp1Left) {
            worldX = gp.tileSize * 65;
            worldY = gp.tileSize * 29;
        }
        if (warp2Right) {
            worldX = gp.tileSize * 40;
            worldY = gp.tileSize * 23;
        }
        if (warp3Bottom) {
            worldX = gp.tileSize * 61;
            worldY = gp.tileSize * 26;
        }
        if(endBottom) {
            gp.gameState = gp.pauseState;
            new EndingWindow();
            JFrame gpFrame = (JFrame) gp.getTopLevelAncestor();  //get JFrame
            gpFrame.dispose();
        }
    }
    
    public void setWX(int x) { this.worldX = x; }
    public void setWY(int y) { this.worldY = y; }
    public int getTS() { return this.gp.tileSize; }
    public GamePanel getGP() { return this.gp; }
    
    public void jump() {
        if (!isJumping) {
            isJumping = true;
        }
    }
    
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;
        
        switch (directionImage) {
            case "up":
                image = walkR2;
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
                image = walkL2;
                break;
        }
       
        g2.drawImage(image, screenX, screenY, gp.tileSize*5/4, gp.tileSize*5/4, null);
        
//        g2.setColor(Color.RED);
//        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
//        g2.setColor(Color.GREEN);
//        g2.drawRect(screenX + hitBoxX.x, screenY + hitBoxX.y, hitBoxX.width, hitBoxX.height);
    }
    
    public void killShark(int index){
        if (index != 999){
            new KillShark();
            gp.obj[index] = null;
        }
    }
    
    public void killOctopus(int index){
        if (index != 999){
            new KillOctopus();
            gp.obj2[index] = null;
        }
    }
    
    public void pickUpItem1(int i) {
        
        if (i != 999) {
            
            String item1Name = gp.item1[i].name;
            
            switch(item1Name) {
                case "squid":
                    numSquid++;
                    gp.item1[i] = null;
                    System.out.println("Squid : " + numSquid);
                    //audio
                    try {
                        Clip pickUp = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/sound/pickUp.wav"));
                        pickUp.open(inputStream);
                        pickUp.start(); 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    
    public void pickUpItem2(int i) {
        
        if (i != 999) {
            
            String item2Name = gp.item2[i].name;
            
            switch(item2Name) {
                case "anemone":
                    numAnemone++;
                    gp.item2[i] = null;
                    System.out.println("Anemone : " + numAnemone);
                    //audio
                    try {
                        Clip pickUp = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/sound/pickUp.wav"));
                        pickUp.open(inputStream);
                        pickUp.start(); 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    
    public void pickUpItem4(int i) {
        
        if (i != 999) {
            
            String item4Name = gp.item4[i].name;
            
            switch(item4Name) {
                case "seagrass2":
                    numSeagrass2++;
                    gp.item4[i] = null;
                    System.out.println("Seagrass : " + numSeagrass2);
                    //audio
                    try {
                        Clip pickUp = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/sound/pickUp.wav"));
                        pickUp.open(inputStream);
                        pickUp.start(); 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
    
    
    
    
}