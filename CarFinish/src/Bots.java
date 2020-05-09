import javax.swing.*;
import java.awt.*;

public class Bots  {
    public int h =200;
    public int w = 99;
    private int speed = 2;
    private int x = 0;
    private int y = 0;
    private int mapX = 0;
    private int mapY = 600;
    private int coin=1;
    Image bot = new ImageIcon("Image/4.png").getImage();
    Image bot1 = new ImageIcon("Image/5.png").getImage();
    public void move() {
       // for (int i=0;i>10;i++)
        mapY+=speed;
        if(mapY>600 ){
           // speed=0;
            coin=1;
        }
       // else{speed=2;};
       // System.out.println(getY());
    };

    public int getSpeed() {
        return speed;
    }
    public int setSpeed(int a) {
        return speed=3;
    }

    public int getX() {
        return x;
    }
    public int getMapX() {
        return mapX;
    }
    public int getMapY(int a) {
        return mapY;
    }
    public int setMapX(int a) {
        return mapX=a;
    }
    public int setMapY(int a) {
        return mapY=a;
    }

    public int getY() {
        return y;
    }
    public int getcoin() {
        return coin;
    }
    public int setcoin(int a) {
        return coin=a;
    }
    public int getMapY() {
        return mapY;
    }
}
