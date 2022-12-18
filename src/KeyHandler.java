 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Fluk
 */
public class KeyHandler implements KeyListener {
    
    GamePanel gp;
    Player p;
    MainWindow main = new MainWindow();
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
        main.getMainFrame().dispose();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P) {
            if (gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            }
            else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }
        if(code == KeyEvent.VK_ESCAPE) {
            int skip = JOptionPane.showConfirmDialog(null, "Exit to Main Menu", "Confirm Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(skip == JOptionPane.YES_OPTION) {
                int confirm = JOptionPane.showConfirmDialog(null, "This action will abandon your current stage and restart the game, are you sure ?", "Confirm Action", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(confirm == JOptionPane.YES_OPTION) {
                    JFrame gpFrame = (JFrame) gp.getTopLevelAncestor();  //get JFrame
                    gpFrame.dispose();                  
                    main.getMainFrame().setVisible(true);
                }
            }                      
        }
        if (gp.gameState == gp.gameOverState) {
                gameOverState(code);
            }
    }
    
    public void gameOverState(int code) {
        
        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 1;
            }
        }
        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 1) {
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
            if (gp.ui.commandNum == 0) {
                //Restart
//                JFrame gpFrame = (JFrame) gp.getTopLevelAncestor();  //get JFrame
//                gpFrame.dispose();
                gp.getPlayer().setWX(gp.getPlayer().getTS()*12);
                gp.getPlayer().setWY(gp.getPlayer().getTS()*9);
                gp.gameState = gp.playState;
//                main.getMainFrame().setVisible(true);
                
            }
            else if (gp.ui.commandNum == 1) {
                //Quit
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
    
}
