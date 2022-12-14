
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
public class Item_Anemone extends SuperObject {
    
    public Item_Anemone() {
        name = "anemone";
        try {
            imageAnemone = ImageIO.read(getClass().getResourceAsStream("/res/items/anemone.png"));
        } catch (IOException ex) {
            Logger.getLogger(Item_Anemone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
