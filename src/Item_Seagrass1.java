
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Fluk
 */
public class Item_Seagrass1 extends SuperObject {
    
    public Item_Seagrass1() {
        name = "seagrass1";
        try {
            imageSeagrass1 = ImageIO.read(getClass().getResourceAsStream("/res/items/seagrass1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Item_Seagrass1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
