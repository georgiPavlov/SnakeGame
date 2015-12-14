import java.awt.*;
import java.util.Random;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Apple {
    private Box appBox;
    private Random random;

    public Apple() {
        appBox = createApple(Game.snake);

    }

    private Box createApple(Snake s){
        random = new Random();
        int x = random.nextInt(Game.COLS);
        int y = random.nextInt(Game.ROWS);

        Box b = new Box(x,y);
        if(s.body.contains(b)){
            return  createApple(s);
        }
        return b;
    }

    public void drawApple(Graphics g){
        g.setColor(Color.red);
        g.fillOval(appBox.x*appBox.BOX_SIZE,appBox.y*appBox.BOX_SIZE,
               appBox.BOX_SIZE,appBox.BOX_SIZE );
    }

    public Box getAppleBox(){
        return appBox;

    }

}
