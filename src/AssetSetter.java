/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class AssetSetter {
    public GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObjectShark(){ //instantiate default objs and place them on the map
        gp.obj[0] = new OBJ_Shark();
        gp.obj[0].worldX = 53*gp.tileSize;
        gp.obj[0].worldY = 11*gp.tileSize;
        
        gp.obj[1] = new OBJ_Shark();
        gp.obj[1].worldX = 81*gp.tileSize;
        gp.obj[1].worldY = 7*gp.tileSize;
        
        gp.obj[2] = new OBJ_Shark();
        gp.obj[2].worldX = 56*gp.tileSize;
        gp.obj[2].worldY = 33*gp.tileSize;
    }
    
    public void setObjectOctopus(){ //instantiate default objs and place them on the map
        gp.obj2[0] = new OBJ_Octopus();
        gp.obj2[0].worldX = 91*gp.tileSize;
        gp.obj2[0].worldY = 40*gp.tileSize;
        
        gp.obj2[1] = new OBJ_Octopus();
        gp.obj2[1].worldX = 46*gp.tileSize;
        gp.obj2[1].worldY = 24*gp.tileSize;
    }
    
        public void setItemSquid() {
        gp.item1[0] = new Item_Squid();
        gp.item1[0].worldX = 80*gp.tileSize;
        gp.item1[0].worldY = 7*gp.tileSize;
        
        gp.item1[1] = new Item_Squid();
        gp.item1[1].worldX = 19*gp.tileSize;
        gp.item1[1].worldY = 12*gp.tileSize;
        
        gp.item1[2] = new Item_Squid();
        gp.item1[2].worldX = 77*gp.tileSize;
        gp.item1[2].worldY = 23*gp.tileSize;
        
        gp.item1[5] = new Item_Squid();
        gp.item1[5].worldX = 61*gp.tileSize;
        gp.item1[5].worldY = 32*gp.tileSize;
        
        gp.item1[4] = new Item_Squid();
        gp.item1[4].worldX = 68*gp.tileSize;
        gp.item1[4].worldY = 40*gp.tileSize;
        
        gp.item1[5] = new Item_Squid();
        gp.item1[5].worldX = 43*gp.tileSize;
        gp.item1[5].worldY = 36*gp.tileSize;
    }
        
        public void setItemAnemone() {
        gp.item2[0] = new Item_Anemone();
        gp.item2[0].worldX = 49*gp.tileSize;
        gp.item2[0].worldY = 7*gp.tileSize;
        
        gp.item2[1] = new Item_Anemone();
        gp.item2[1].worldX = 52*gp.tileSize;
        gp.item2[1].worldY = 42*gp.tileSize;
        
        gp.item2[2] = new Item_Anemone();
        gp.item2[2].worldX = 52*gp.tileSize;
        gp.item2[2].worldY = 32*gp.tileSize;
    }
                
        public void setItemSeagrass1() {}
        
        public void setItemSeagrass2() {
        gp.item4[0] = new Item_Seagrass2();
        gp.item4[0].worldX = 8*gp.tileSize;
        gp.item4[0].worldY = 12*gp.tileSize;
        
        gp.item4[1] = new Item_Seagrass2();
        gp.item4[1].worldX = 97*gp.tileSize;
        gp.item4[1].worldY = 29*gp.tileSize;
        
        gp.item4[2] = new Item_Seagrass2();
        gp.item4[2].worldX = 97*gp.tileSize;
        gp.item4[2].worldY = 42*gp.tileSize;
        
        gp.item4[3] = new Item_Seagrass2();
        gp.item4[3].worldX = 68*gp.tileSize;
        gp.item4[3].worldY = 34*gp.tileSize;
        
        gp.item4[4] = new Item_Seagrass2();
        gp.item4[4].worldX = 40*gp.tileSize;
        gp.item4[4].worldY = 24*gp.tileSize;
        
        gp.item4[5] = new Item_Seagrass2();
        gp.item4[5].worldX = 50*gp.tileSize;
        gp.item4[5].worldY = 28*gp.tileSize;
    }       
}
