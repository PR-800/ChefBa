
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
public class Item_Seagrass2 extends SuperObject {
    
    public Item_Seagrass2() {
        name = "seagrass1";
        try {
            imageOct = ImageIO.read(getClass().getResourceAsStream("/res/items/seagrass2.png"));
        } catch (IOException ex) {
            Logger.getLogger(Item_Seagrass2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
