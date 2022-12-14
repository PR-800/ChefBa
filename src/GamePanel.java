/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author Fluk
 */
public class GamePanel extends JPanel implements Runnable{
    //Screen Settings
    final int originalTileSize = 16;    //16*16 tile
    final int scale = 4;
    
    //set fullscreen
    private GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice device = environment.getDefaultScreenDevice();
    private GraphicsConfiguration config = device.getDefaultConfiguration();

    public final int tileSize = originalTileSize * scale;  //128*128 tile
    public final int maxScreenCol = 25;
    public final int maxScreenRow = 14;
//    public final int screenWidth = tileSize*maxScreenCol;  //1024
//    public final int screenHeight = tileSize*maxScreenRow; //768
    public final int screenWidth = config.getBounds().width;
    public final int screenHeight = config.getBounds().height;
    
    // WORLD SETTINGS
    public final int maxWorldCol = 100;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
        
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH =  new KeyHandler();
    Thread gameThread;
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    
    public Player player = new Player(this,keyH);
    /////// put Item//////////
    public SuperObject obj[] = new SuperObject[10]; // 10 -> means 10 slots -> can display up to 10 objs in same time // shark
    public SuperObject obj2[] = new SuperObject[10]; // octopus
    public AssetSetter aSetter = new AssetSetter(this);
    
    //Set Player defult position
   
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);   //smoother
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    /////// put Item//////////
    public void setupGame(){ // set up before game start // shark
        aSetter.setObjectShark();
        aSetter.setObjectOctopus();
    }
    /////////////////////////
    
    public void startGameThread() {
 
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;   //0.1666 sec
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null) {
            
            //UPDATE
            update();
            //DRAW
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }
    public void update() {
        player.update();
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);
        /////// put Item//////////
        for (int i = 0; i < obj.length; i++){
            if (obj[i] != null){
                obj[i].drawShark(g2, this);
            }
        }
        for (int i = 0; i < obj2.length; i++){
            if (obj2[i] != null){
                obj2[i].drawOctopus(g2, this);
            }
        }
        /////////////////////////////
        player.draw(g2);
        
        g2.dispose();
    }
}
