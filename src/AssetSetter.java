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
}
