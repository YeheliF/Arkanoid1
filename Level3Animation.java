package organizethegame;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/***
 * this class creat the background of the level 3.
 */
public class Level3Animation implements Sprite {
    /**
     * this function draw the sprite to the screen she gets.
     *
     * @param d - the screen where the sprite should be.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(255, 153, 255));
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(new Color(102, 153, 255));
        d.fillRectangle(80, 400, 100, 200);
        d.setColor(new Color(102, 153, 255));
        d.fillRectangle(120, 320, 20, 80);
        d.setColor(new Color(102, 153, 255));
        d.fillRectangle(105, 380, 55, 20);
        d.setColor(new Color(255, 255, 153));
        d.fillCircle(130, 310, 10);
        d.setColor(Color.gray);
        int x = 90;
        int y = 420;
        //creat the lines
        for (int j = 0; j < 4; j++) {
            //creat the columns.
            for (int i = 1; i < 4; i++) {
                d.fillRectangle(x, y, 20, 30);
                x += 30;
            }
            y += 50;
            x = 90;
        }

    }

    /**
     * this function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
