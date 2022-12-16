import java.awt.BasicStroke;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    Font maruMonica;
    
    BufferedImage squidImage, anemoneImage, seagrass2Image;
    
    public int slotCol = 0;
    public int slotRow = 0;
    
    public UI(GamePanel gp) {
        
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        
        Item_Squid squid = new Item_Squid();
        squidImage = squid.imageSquid;  //name form Superobj
        
        Item_Anemone anemone = new Item_Anemone();
        anemoneImage = anemone.imageAnemone;
        
        Item_Seagrass2 seagrass2 = new Item_Seagrass2();
        seagrass2Image = seagrass2.imageSeagrass2;
        
    }
    
    public void draw(Graphics2D g2) {
        
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
        g2.drawImage(squidImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.numSquid, 102, 75);
        g2.drawImage(anemoneImage, gp.tileSize/2, 3*gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.numAnemone, 102, 145);
        g2.drawImage(seagrass2Image, gp.tileSize/2, 5*gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.numSeagrass2, 102, 210);
        
        
        if (gp.gameState == gp.playState) {
            
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        
    }
    
    public void drawPauseScreen() {
        
        g2.setFont(arial_40);
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
    public void drawInventory() {
        
        //Frame
        int frameX = gp.tileSize*9;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize*6;
        int frameHeight = gp.tileSize*5;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        
        //Slot
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;
        
        //Cursor
        int cursorX = slotXstart + (gp.tileSize * slotCol);
        int cursorY = slotYstart + (gp.tileSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        //Draw Cursor
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
        
    }

    private void drawSubWindow(int x, int y, int width, int height) {
        
        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

}
