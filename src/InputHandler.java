import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class InputHandler implements KeyListener {

    public InputHandler(Game game){
        game.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP){
            if(Game.snake.getVel2() !=1) {
                Game.snake.setVel1(0);
                Game.snake.setVel2(-1);
            }
        }else if(keyCode == KeyEvent.VK_DOWN){
            if(Game.snake.getVel2() !=-1) {
            Game.snake.setVel1(0);
            Game.snake.setVel2(1);
            }
        }else if(keyCode == KeyEvent.VK_RIGHT){
            if(Game.snake.getVel1() !=-1) {
                Game.snake.setVel1(1);
                Game.snake.setVel2(0);
            }
        }else if(keyCode == KeyEvent.VK_LEFT){
                if(Game.snake.getVel1() !=1) {
                    Game.snake.setVel1(-1);
                    Game.snake.setVel2(0);
                }
        }
        if(keyCode == KeyEvent.VK_ESCAPE);


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
