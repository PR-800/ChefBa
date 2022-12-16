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
//    public void checkTile(Entity entity){
//        
//        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
//        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
//        int entityTopWorldY = entity.worldY + entity.solidArea.y;
//        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
//        
//        int entityLeftCol = entityLeftWorldX/gp.tileSize;
//        int entityRightCol = entityRightWorldX/gp.tileSize;
//        int entityTopRow = entityTopWorldY/gp.tileSize;
//        int entityBottomRow = entityBottomWorldY/gp.tileSize;
//        
//        int tileNum1, tileNum2;
//        
//        switch(entity.direction){
//        case "up":
//            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
//            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
//                entity.collisionOn = true;
//            }
//            break;
//        case "down":
//            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
//            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
//            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
//                entity.collisionOn = true;
//            }
//            break;
//        case "left":
//            entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
//            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
//            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
//                entity.collisionOn = true;
//            }
//            break;
//        case "right":
//            entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
//            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
//            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
//            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
//                entity.collisionOn = true;
//            }
//            break;
//            
//        }
//    }
    
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
    
    public int checkItem2(Entity entity, boolean player){
        int indexAnemone = 999;
        
        for (int i = 0; i < gp.item2.length; i++){
            if (gp.item2[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                gp.item2[i].solidArea.x = gp.item2[i].worldX + gp.item2[i].solidArea.x;
                gp.item2[i].solidArea.y = gp.item2[i].worldY + gp.item2[i].solidArea.y;
                
                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.item2[i].solidArea)){
                            if (gp.item2[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexAnemone = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.item2[i].solidArea)){
                            if (gp.item2[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexAnemone = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.item2[i].solidArea)){
                            if (gp.item2[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexAnemone = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.item2[i].solidArea)){
                            if (gp.item2[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexAnemone = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;                
                
                gp.item2[i].solidArea.x = gp.item2[i].solidAreaDefaultX;
                gp.item2[i].solidArea.y = gp.item2[i].solidAreaDefaultY;
            } 
        }
        return indexAnemone;
    }
    
    public int checkItem4(Entity entity, boolean player){
        int indexSeagrass = 999;
        
        for (int i = 0; i < gp.item4.length; i++){
            if (gp.item4[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                gp.item4[i].solidArea.x = gp.item4[i].worldX + gp.item4[i].solidArea.x;
                gp.item4[i].solidArea.y = gp.item4[i].worldY + gp.item4[i].solidArea.y;
                
                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.item4[i].solidArea)){
                            if (gp.item4[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSeagrass = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.item4[i].solidArea)){
                            if (gp.item4[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSeagrass = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.item4[i].solidArea)){
                            if (gp.item4[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSeagrass = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.item4[i].solidArea)){
                            if (gp.item4[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                indexSeagrass = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;                
                
                gp.item4[i].solidArea.x = gp.item4[i].solidAreaDefaultX;
                gp.item4[i].solidArea.y = gp.item4[i].solidAreaDefaultY;
            } 
        }
        return indexSeagrass;
    }

    public void checkTile(Entity entity) {
        int hitXLeft = (entity.worldX + entity.hitBoxX.x) / gp.tileSize;
        int hitXRight = (entity.worldX + entity.hitBoxX.x + entity.hitBoxX.width) / gp.tileSize;
        int hitXTop = (entity.worldY + entity.hitBoxX.y) / gp.tileSize;
        int hitXBottom = (entity.worldY + entity.hitBoxX.y + entity.hitBoxX.height) / gp.tileSize;

        int hitYLeft = (entity.worldX + entity.solidArea.x) / gp.tileSize;
        int hitYRight = (entity.worldX + entity.solidArea.x + entity.solidArea.width) / gp.tileSize;
        int hitYTop = (entity.worldY + entity.solidArea.y) / gp.tileSize;
        int hitYBottom = (entity.worldY + entity.solidArea.y + entity.solidArea.height) / gp.tileSize;

        int topHitPos1 = gp.tileM.mapTileNum[hitYLeft][hitYTop];
        int topHitPos2 = gp.tileM.mapTileNum[hitYRight][hitYTop];

        int bottomHitPos1 = gp.tileM.mapTileNum[hitYLeft][hitYBottom];
        int bottomHitPos2 = gp.tileM.mapTileNum[hitYRight][hitYBottom];

        int leftHitPos1 = gp.tileM.mapTileNum[hitXLeft][hitXTop];
        int leftHitPos2 = gp.tileM.mapTileNum[hitXLeft][hitXBottom];

        int rightHitPos1 = gp.tileM.mapTileNum[hitXRight][hitXTop];
        int rightHitPos2 = gp.tileM.mapTileNum[hitXRight][hitXBottom];


        if (gp.tileM.tile[topHitPos1].collision || gp.tileM.tile[topHitPos2].collision) {
            entity.topHit = true;
        } else {
            entity.topHit = false;
        }

        if (gp.tileM.tile[bottomHitPos1].collision || gp.tileM.tile[bottomHitPos2].collision) {
            entity.bottomHit = true;
        } else {
            entity.bottomHit = false;
        }

        if (gp.tileM.tile[leftHitPos1].collision || gp.tileM.tile[leftHitPos2].collision) {
            entity.leftHit = true;
        } else {
            entity.leftHit = false;
        }

        if (gp.tileM.tile[rightHitPos1].collision || gp.tileM.tile[rightHitPos2].collision) {
            entity.rightHit = true;
        } else {
            entity.rightHit = false;
        }
    }
    
}