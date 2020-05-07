import javax.swing.*;
import java.awt.*;

public class Bots  {
    public int h =200;
    public int w = 102;
    private int speed = 2;
    private int x = 0;
    private int y = 0;
    private int mapX = 0;
    private int mapY = -200;
    Image bot = new ImageIcon("Image/4.jpg").getImage();
    public void move() {
       // for (int i=0;i>10;i++)
        mapY+=speed;
       // System.out.println(getY());
    };

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }
    public int getMapX(int a) {
        return mapX=+a;
    }

    public int getY() {
        return y;
    }
    //if((player.getMapX()>bots1.getMapX()-player.w)&&(player.getMapX()<bots1.getMapX()+bots1.w)&&(player.getMapY()>bots1.getMapY()-player.h)&&(player.getMapY()<bots1.getMapY()+bots1.h))



    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }
}
