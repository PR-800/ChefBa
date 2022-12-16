/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FiFa-PC
 */

public class CollisionChecker {
    GamePanel gp;
    
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
        case "up":
            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "down":
            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "left":
            entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "right":
            entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
            
        }
    }
    public int checkObject(Entity entity, boolean player){
        int indexShark = 999;
        
        // Hit Shark //
        for (int i = 0; i < gp.obj.length; i++){
            if (gp.obj[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
                
                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexShark = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexShark = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexShark = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexShark = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;                
                
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            } 
        }
        return indexShark; // if player hit obj will return index of obj
    }
 
    public int checkItem1(Entity entity, boolean player){
        int indexSquid = 999;
        
        for (int i = 0; i < gp.item1.length; i++){
            if (gp.item1[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                gp.item1[i].solidArea.x = gp.item1[i].worldX + gp.item1[i].solidArea.x;
                gp.item1[i].solidArea.y = gp.item1[i].worldY + gp.item1[i].solidArea.y;
                
                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.item1[i].solidArea)){
                            if (gp.item1[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSquid = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.item1[i].solidArea)){
                            if (gp.item1[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSquid = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.item1[i].solidArea)){
                            if (gp.item1[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSquid = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.item1[i].solidArea)){
                             if (gp.item1[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSquid = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;                
                
                gp.item1[i].solidArea.x = gp.item1[i].solidAreaDefaultX;
                gp.item1[i].solidArea.y = gp.item1[i].solidAreaDefaultY;
            } 
        }
        return indexSquid;
    }

}