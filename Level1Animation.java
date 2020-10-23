package organizethegame;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/***
 * this class creat the background of the level 1.
 */
public class Level1Animation implements Sprite {
    /**
     * this function draw the sprite to the screen she gets.
     *
     * @param d - the screen where the sprite should be.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(Color.blue);
        d.drawLine(410, 50, 410, 150);
        d.drawLine(410, 170, 410, 270);
        d.drawLine(420, 160, 520, 160);
        d.drawLine(400, 160, 300, 160);
        d.drawCircle(410, 160, 70);
        d.drawCircle(410, 160, 30);
        d.drawCircle(410, 160, 100);
    }

    /**
     * this function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
