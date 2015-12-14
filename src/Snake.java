import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by georgipavlov on 14.12.15.
 */
public class Snake {
    public  static LinkedList<Box> body;
    public static Box head;
    private int vel1,vel2;

    public int getVel1() {
        return vel1;
    }

    public void setVel1(int vel1) {
        this.vel1 = vel1;
    }

    public int getVel2() {
        return vel2;
    }

    public void setVel2(int vel2) {
        this.vel2 = vel2;
    }

    public Snake() {
        body = new LinkedList<>();
        Collections.addAll(body,
                new Box(1,2),
                new Box(2,2),
                new Box(3,2),
                new Box(4,2)
         );
        head = body.peek();
        vel1=1;
        vel2=0;
    }

    public void drawSnake(Graphics g){
        for (Box box: body){
            g.setColor(Color.green);
            g.fillRect(box.x*box.BOX_SIZE,box.y*box.BOX_SIZE,
                    box.BOX_SIZE,box.BOX_SIZE);
            g.setColor(Color.black);
            g.drawRect(box.x*box.BOX_SIZE,box.y*box.BOX_SIZE,
                    box.BOX_SIZE,box.BOX_SIZE);
        }
    }

    public  void tick(){

        head = body.peekLast();
        Box nextPos = new Box(head.x +vel1 ,head.y+vel2);
        for (int i = 0; i <body.size()-1 ; i++) {
            body.set(i, body.get(i + 1));
        }
        body.set(body.size() - 1, nextPos);
    }
}
