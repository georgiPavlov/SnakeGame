import java.awt.*;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Game extends Canvas implements Runnable {
    public static Snake snake;
    private Thread runThread;
    private Graphics globalGraphics;
    static boolean gameRunning = false;
    public  static final int ROWS = 30;
    public  static final int COLS = 30;
    public  static final int SIZE = 20;
    public  static final int WIDTH = COLS*SIZE;
    public  static final int HEIGHT = ROWS*SIZE;
    public  static Apple apple;



    public void paint(Graphics g){
        globalGraphics=g.create();
        if(runThread == null){
            runThread = new Thread(this);
            runThread.start();
            gameRunning=true;
        }


    }


    public Game(){
        snake=new Snake();
        apple = new Apple();
    }

    public void render(Graphics g){
        g.clearRect(0,0,WIDTH,HEIGHT);
        snake.drawSnake(g);
        apple.drawApple(g);

    }




    @Override
    public void run() {

       while (gameRunning){
           snake.tick();
           render(globalGraphics);
           try {
               Thread.sleep(75);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }
}
