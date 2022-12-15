/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObjectShark(){ //instantiate default objs and place them on the map
        gp.obj[0] = new OBJ_Shark();
        gp.obj[0].worldX = 31*gp.tileSize;
        gp.obj[0].worldY = 14*gp.tileSize;
        
        gp.obj[1] = new OBJ_Shark();
        gp.obj[1].worldX = 70*gp.tileSize;
        gp.obj[1].worldY = 13*gp.tileSize;
        
        gp.obj[2] = new OBJ_Shark();
        gp.obj[2].worldX = 56*gp.tileSize;
        gp.obj[2].worldY = 36*gp.tileSize;
    }
    
    public void setObjectOctopus(){ //instantiate default objs and place them on the map
        gp.obj2[0] = new OBJ_Octopus();
        gp.obj2[0].worldX = 63*gp.tileSize;
        gp.obj2[0].worldY = 36*gp.tileSize;
        
        gp.obj2[1] = new OBJ_Octopus();
        gp.obj2[1].worldX = 90*gp.tileSize;
        gp.obj2[1].worldY = 44*gp.tileSize;
    }
    
        public void setItemSquid() {
        gp.item1[0] = new Item_Squid();
        gp.item1[0].worldX = 80*gp.tileSize;
        gp.item1[0].worldY = 8*gp.tileSize;
        
        gp.item1[1] = new Item_Squid();
        gp.item1[1].worldX = 20*gp.tileSize;
        gp.item1[1].worldY = 40*gp.tileSize;
        
        gp.item1[2] = new Item_Squid();
        gp.item1[2].worldX = 7*gp.tileSize;
        gp.item1[2].worldY = 12*gp.tileSize;
        
        gp.item1[3] = new Item_Squid();
        gp.item1[3].worldX = 12*gp.tileSize;
        gp.item1[3].worldY = 12*gp.tileSize;
        
        gp.item1[4] = new Item_Squid();
        gp.item1[4].worldX = gp.tileSize;
        gp.item1[4].worldY = gp.tileSize;
        
        gp.item1[5] = new Item_Squid();
        gp.item1[5].worldX = gp.tileSize;
        gp.item1[5].worldY = gp.tileSize;
    }
        
        public void setItemAnemone() {
        gp.item2[0] = new Item_Anemone();
        gp.item2[0].worldX = gp.tileSize;
        gp.item2[0].worldY = gp.tileSize;
        
        gp.item2[1] = new Item_Anemone();
        gp.item2[1].worldX = gp.tileSize;
        gp.item2[1].worldY = gp.tileSize;
        
        gp.item2[2] = new Item_Anemone();
        gp.item2[2].worldX = gp.tileSize;
        gp.item2[2].worldY = gp.tileSize;
    }
                
        public void setItemSeagrass1() {
        gp.item3[0] = new Item_Seagrass1();
        gp.item3[0].worldX = gp.tileSize;
        gp.item3[0].worldY = gp.tileSize;
        
        gp.item3[1] = new Item_Seagrass1();
        gp.item3[1].worldX = gp.tileSize;
        gp.item3[1].worldY = gp.tileSize;
        
        gp.item3[2] = new Item_Seagrass1();
        gp.item3[2].worldX = gp.tileSize;
        gp.item3[2].worldY = gp.tileSize;
        
    }
        
        public void setItemSeagrass2() {
        gp.item4[0] = new Item_Seagrass2();
        gp.item4[0].worldX = 3*gp.tileSize;
        gp.item4[0].worldY = 12*gp.tileSize;
        
        gp.item4[1] = new Item_Seagrass2();
        gp.item4[1].worldX = gp.tileSize;
        gp.item4[1].worldY = gp.tileSize;
        
        gp.item4[1] = new Item_Seagrass2();
        gp.item4[1].worldX = gp.tileSize;
        gp.item4[1].worldY = gp.tileSize;
    }       
}
