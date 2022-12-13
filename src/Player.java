/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;


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
        
    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 12;
        worldY = gp.tileSize * 9;
        speed = 5;
    }
    public void update() {
//       worldY += speed;
        if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true) {
//                worldY -= speed*2;
//                worldY -= speed;
            }
            else if(keyH.downPressed == true) {
//                worldY += speed;
            }
            else if(keyH.leftPressed == true) {
//               worldX -= speed;
            }
            else if(keyH.rightPressed == true) {
//                worldX += speed;
            }
            //Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //If Collision is False, Player can move
            if(collisionOn == false){
                switch(direction){
                case "up":
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
           }
        }
    }
    public void draw(Graphics2D g2) {
        
        g2.setColor(Color.WHITE);
        g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);       
    }
}
