/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class OBJ_Shark extends SuperObject{
    public OBJ_Shark(){
        name = "shark";
        try{
            imageShark = ImageIO.read(getClass().getResourceAsStream("/objects/smallShark.png"));
        } 
        catch (IOException ex) {
            Logger.getLogger(OBJ_Shark.class.getName()).log(Level.SEVERE, null, ex);
        }
        collision = true;
    }
}
