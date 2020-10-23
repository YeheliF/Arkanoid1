package organizethegame;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/***
 * this class creat the background of the level 2.
 */
public class Level2Animation implements Sprite {
    /**
     * this function draw the sprite to the screen she gets.
     *
     * @param d - the screen where the sprite should be.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(255, 204, 153));
        int location = 0;
        //creat 100 lines on the screen.
        for (int i = 0; i < 100; i++) {
            d.drawLine(150, 150, location, 300);
            location += 10;
        }
        d.fillCircle(150, 150, 70);
        d.setColor(new Color(250, 250, 102));
        d.fillCircle(150, 150, 50);
        d.setColor(new Color(250, 250, 51));
        d.fillCircle(150, 150, 30);

    }

    /**
     * this function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
