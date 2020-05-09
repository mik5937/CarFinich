import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
import java.awt.FlowLayout;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener {
    int random_number;
    int time_for_spawn=8000;
    Image img = new ImageIcon("Image/1.jpg").getImage();

    Timer timer = new Timer(20, this);
    // Timer timerScore = new Timer(20, this);
    Player player = new Player();
    Bots bots1 = new Bots();
    Bots bots2 = new Bots();
    Bots bots3 = new Bots();
    Bots bots4 = new Bots();
    Bots bots5 = new Bots();
    Bots bots6 = new Bots();
    int sizeBots=6;
    Bots[] arr = {bots1, bots2, bots3, bots4, bots5, bots6};
    JFrame frame;
    public Main(JFrame frame) {
        this.frame = frame;
        timer.start();
        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        player.ScorePlus();
                        Thread.sleep(200); //1000 - 1 сек
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        //run.start();
        Thread Spawnbots = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        random_number = (int) (Math.random() * 6);
                        System.out.println(random_number);
                        switch (random_number) {

                            case 0:
                                spawnBots(arr, 10, -200);
                                break;
                            case 1:
                                spawnBots(arr, 120, -200);
                                break;
                            case 2:
                                spawnBots(arr, 220, -200);
                                break;
                            case 3:
                                spawnBots(arr, 320, -200);
                                break;
                            case 4:
                                spawnBots(arr, 420, -200);
                                break;
                            case 5:
                                spawnBots(arr, 520, -200);
                                break;
                        }
                        Thread.sleep(time_for_spawn); //1000 - 1 сек
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        run.start();
        Spawnbots.start();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                player.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                player.keyReleased(e);
            }
        });

    }
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
        g.drawImage(player.pl, player.getMapX(), player.getMapY(), null);
        for (int i = 0; i < sizeBots; i++) {
            arr[i].move();
            if(i % 2 == 1) {
                g.drawImage(arr[i].bot, arr[i].getMapX(), arr[i].getMapY(), null);
            }//визуальное расп машины
            else
            g.drawImage(arr[i].bot1, arr[i].getMapX(), arr[i].getMapY(), null);
        }
    }
    void Clash(Bots a) {
        if ((player.getMapX() > a.getMapX() - player.w) && (player.getMapX() < a.getMapX() + a.w) && (player.getMapY() > a.getMapY() - player.h) && (player.getMapY() < a.getMapY() + a.h)) {
            JOptionPane.showMessageDialog(null, "Вы столкнулись и проиграли ваш счет: " + player.score);
            System.exit(0);
        }
    };
    void spawnBots(Bots arr[], int x, int y) {
        for (int i = 0; i < sizeBots; i++) {
            if (arr[i].getcoin() == 1) {
                arr[i].setMapX(x);
                arr[i].setMapY(y);
                arr[i].setcoin(0);
                break;
            }
        }
    };
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
        player.move();
        if(player.score==10)
        {
            bots1.setSpeed(3);
            bots3.setSpeed(3);
            time_for_spawn=5000;
        }
        if(player.score==20)
        {
            bots5.setSpeed(3);
            bots2.setSpeed(3);
            time_for_spawn=1000;
        }
        for (int i = 0; i < sizeBots; i++) {
            Clash(arr[i]);
        }
    }
}
