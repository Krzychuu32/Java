package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    //ustawienia ekranu
    final int basicSize =16; //16x16
    final int scale=3;

    public int size=basicSize*scale; //48x48
    public int screenCol=16;
    public int screenRow=12;
    public int screenWidht=size*screenCol; //768 pix
    public int screenHeight=size*screenRow; //576 pix

    KeyMotion keyMotion = new KeyMotion();
    Thread gameThread;
    Player player =new Player(this,keyMotion);
    TileManager tileM = new TileManager(this);

    //player position
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;

    //FPS
    int fps=60;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidht,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyMotion);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval=1000000000/fps;
        double nextDrawTime =System.nanoTime()+drawInterval;
        while(gameThread!=null){

            uptade();
            repaint();

            try {
                double reamainTime=nextDrawTime-System.nanoTime();
                reamainTime=reamainTime/1000000;
                Thread.sleep((long) reamainTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void uptade(){
        player.uptade();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);

        g2.dispose();
    }
}
