import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;

public class Player {
    public int score =0;
    public int h =103;
    public int w = 66;
    private int x = 0;
    private int y = 0;
    private int speed = 5;
    private int mapX = 250;
    private int mapY = 250;
    enum Direction { UP, DOWN, LEFT, RIGHT, NONE }
    Image pl = new ImageIcon("Image/2.jpg").getImage();

    private Direction playerDirection = Direction.NONE;

    public void move() {
        switch(playerDirection) {
            case UP:
                if (getMapY() ==15){playerDirection = Direction.NONE;}
              //  System.out.println(getMapY());
                mapY-=speed;
                break;
            case DOWN:
                if (getMapY() ==470){playerDirection = Direction.NONE;}
                mapY+=speed;
                break;
            case LEFT:
                if (getMapX() ==15){playerDirection = Direction.NONE;}
                //System.out.println(getMapX());
                mapX-=speed;
                break;
            case RIGHT:
                if (getMapX() ==560){playerDirection = Direction.NONE;}
                mapX+=speed;
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            playerDirection = Direction.UP;
        }
        if(key == KeyEvent.VK_S) {
            playerDirection = Direction.DOWN;
        }
        if(key == KeyEvent.VK_A) {
            playerDirection = Direction.LEFT;
        }
        if(key == KeyEvent.VK_D) {
            playerDirection = Direction.RIGHT;
        }
    }
    public void ScorePlus() {
         System.out.println("S4et");
         System.out.println(score);
         score+=1;
        return;
    }

    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }
}