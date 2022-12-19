/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.image.BufferedImage;

/**
 *
 * @author FiFa-PC
 */
public class Tile {
    public BufferedImage image;
    public boolean collision = false;
    public boolean climbableLeft = false;
    public boolean climbableRight = false;
    public boolean trap = false;
    public boolean ending = false;
    public boolean warp1, warp2, warp3;
}
