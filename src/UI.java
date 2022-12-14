import java.awt.BasicStroke;
import java.awt.*;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    Font maruMonica;
    
    public int slotCol = 0;
    public int slotRow = 0;
    
    public UI(GamePanel gp) {
        
        this.gp = gp;
        
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        
    }
    
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
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
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
        
    }

    private void drawSubWindow(int frameX, int frameY, int frameWidth, int frameHeight) {
        
    }

}
