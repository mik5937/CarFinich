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
    int random_number=1;
    Image img = new ImageIcon("Image/1.jpg").getImage();

    Timer timer = new Timer(20, this);
    Timer timerScore = new Timer(20, this);
    Player player = new Player();
    Bots bots1= new Bots();
    Bots bots2= new Bots();
    Bots bots3= new Bots();
    Bots bots4= new Bots();
    Bots[] arr = {bots1,bots2,bots3,bots4};
    JFrame frame;
    public Main(JFrame frame) {
        this.frame = frame;
        timer.start();

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
        g.drawImage(img, 0, 0,frame.getWidth(), frame.getHeight(), null);
        g.drawImage(player.pl, player.getMapX(), player.getMapY(), null);

        switch(random_number) {
            case 1:
                bots1.getMapX(160);
                g.drawImage(bots1.bot, 160, 0+bots1.getMapY(), null);
               // bots1.getX()=160+bots1.getMapX();
                break;
            case 2:
                bots2.getMapX(20);
                g.drawImage(bots2.bot, 20, 0+bots2.getMapY(), null);
                break;
            case 3:
                bots3.getMapX(260);
                g.drawImage(bots3.bot, 260, 0+bots3.getMapY(), null);
                break;
            case 4:
                bots4.getMapX(460);
                g.drawImage(bots4.bot, 460, 0+bots4.getMapY(), null);
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
      //  random_number =(int) (Math.random() * 4);
        player.move();
        bots1.move();

        bots2.move();
        bots3.move();
        bots4.move();
        if((player.getMapX()>bots1.getMapX()-player.w)&&(player.getMapX()<bots1.getMapX()+bots1.w)&&(player.getMapY()>bots1.getMapY()-player.h)&&(player.getMapY()<bots1.getMapY()+bots1.h))
        {
            /*System.out.println("X");
            System.out.println(player.getX());
            System.out.println("x");
            System.out.println(bots1.getX());
            System.out.println("MY");
            System.out.println(player.getMapY());
            System.out.println("My");
            System.out.println(bots1.getMapY());
            System.out.println("Bdish");*/

            JOptionPane.showMessageDialog(null, "Вы столкнулись и проиграли ваш счет: "+ player.score);


            System.exit(0);
        }

    }
   /* Thread run = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    random_number = (int) (Math.random() * 4);
                    Thread.sleep(1000); //1000 - 1 сек
                } catch (InterruptedException ex) {
                }
            }
        }
    });
       // run.start();*/


}