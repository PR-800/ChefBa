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
    
    public int checkObject2(Entity entity, boolean player){
        int indexOctopus = 999;
        
        // Hit Shark //
        for (int i = 0; i < gp.obj2.length; i++){
            if (gp.obj2[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                gp.obj2[i].solidArea.x = gp.obj2[i].worldX + gp.obj2[i].solidArea.x;
                gp.obj2[i].solidArea.y = gp.obj2[i].worldY + gp.obj2[i].solidArea.y;
                
                switch (entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj2[i].solidArea)){
                            if (gp.obj2[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexOctopus = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj2[i].solidArea)){
                            if (gp.obj2[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexOctopus = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj2[i].solidArea)){
                            if (gp.obj2[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexOctopus = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj2[i].solidArea)){
                            if (gp.obj2[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                indexOctopus = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;                
                
                gp.obj2[i].solidArea.x = gp.obj2[i].solidAreaDefaultX;
                gp.obj2[i].solidArea.y = gp.obj2[i].solidAreaDefaultY;
            } 
        }
        return indexOctopus; // if player hit obj will return index of obj
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
        
        //Climbable
        if (gp.tileM.tile[leftHitPos1].climbableRight || gp.tileM.tile[leftHitPos2].climbableRight) {
            entity.vineRight = true;
        } else {
            entity.vineRight = false;
        }

        if (gp.tileM.tile[rightHitPos1].climbableLeft || gp.tileM.tile[rightHitPos2].climbableLeft) {
            entity.vineLeft = true;
        } else {
            entity.vineLeft = false;
        }
        
        //Check died
        if (gp.tileM.tile[topHitPos1].trap || gp.tileM.tile[topHitPos2].trap) {
            entity.trapTop = true;
        } else {
            entity.trapTop = false;
        }

        if (gp.tileM.tile[bottomHitPos1].trap || gp.tileM.tile[bottomHitPos2].trap) {
            entity.trapBottom = true;
        } else {
            entity.trapBottom = false;
        }

        if (gp.tileM.tile[leftHitPos1].trap || gp.tileM.tile[leftHitPos2].trap) {
            entity.trapLeft = true;
        } else {
            entity.trapLeft = false;
        }

        if (gp.tileM.tile[rightHitPos1].trap || gp.tileM.tile[rightHitPos2].trap) {
            entity.trapRight = true;
        } else {
            entity.trapRight = false;
        }
        
        //Ending Scence
        if (gp.tileM.tile[bottomHitPos1].ending || gp.tileM.tile[bottomHitPos2].ending) {
            entity.endBottom = true;
        } else {
            entity.endBottom = false;
        }
        
        //WARP CHECK
        if (gp.tileM.tile[leftHitPos1].warp1 || gp.tileM.tile[leftHitPos2].warp1) {
            entity.warp1Left = true;
        } else {
            entity.warp1Left = false;
        }
        
        if (gp.tileM.tile[rightHitPos1].warp2 || gp.tileM.tile[rightHitPos2].warp2) {
            entity.warp2Right = true;
        } else {
            entity.warp2Right = false;
        }
        
        if (gp.tileM.tile[bottomHitPos1].warp3 || gp.tileM.tile[bottomHitPos2].warp3) {
            entity.warp3Bottom = true;
        } else {
            entity.warp3Bottom = false;
        }
       
        
    }
    
}