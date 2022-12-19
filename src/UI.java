import java.awt.BasicStroke;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UI {
    
    public GamePanel gp;
    public Graphics2D g2;
    public Font vcr;
    
    BufferedImage squidImage, anemoneImage, seagrass2Image;
    
    public int slotCol = 0;
    public int slotRow = 0;
    public int commandNum = 0;
    
    public UI(GamePanel gp) {
        
        this.gp = gp;
        
        InputStream is = getClass().getResourceAsStream("res/font/VCR_OSD_MONO.ttf");
        try {
            vcr = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException ex) {}
        
        Item_Squid squid = new Item_Squid();
        squidImage = squid.imageSquid;  //name form Superobj
        
        Item_Anemone anemone = new Item_Anemone();
        anemoneImage = anemone.imageAnemone;
        
        Item_Seagrass2 seagrass2 = new Item_Seagrass2();
        seagrass2Image = seagrass2.imageSeagrass2;
        
    }
    
    public void draw(Graphics2D g2) {
        
        this.g2 = g2;
        
        g2.setFont(g2.getFont().deriveFont(50f));
        g2.setColor(Color.white);
        
        g2.drawImage(squidImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.numSquid, 102, 75);
        g2.drawImage(anemoneImage, gp.tileSize/2, 3*gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.numAnemone, 102, 145);
        g2.drawImage(seagrass2Image, gp.tileSize/2, 5*gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.numSeagrass2, 102, 210);
        
        
        if (gp.gameState == gp.playState) {}
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        
        //GAME OVER STATE
        if (gp.gameState == gp.gameOverState) {
            drawGameOverScreen();
        }
    }
    
    public void drawGameOverScreen() {
        
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
         
        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
        
        text = "Game Over";
        //Shadow
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text, x, y);
        //Main
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);
        
        //Restart
        g2.setFont(g2.getFont().deriveFont(60f));
        text = "Restart";
        x = getXforCenteredText(text);
        y += gp.tileSize*6;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString("->", x-90, y);
        }
        
        //Quit
        text = "Quit";
        x = getXforCenteredText(text);
        y += 75;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString("->", x-90, y);
        }
        
    }
    
    public void drawPauseScreen() {
        
        g2.setFont(g2.getFont().deriveFont(60f));
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
