package organizethegame;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/***
 * this class creat the background of the level 4.
 */
public class Level4Animation implements Sprite {
    /**
     * this function draw the sprite to the screen she gets.
     *
     * @param d - the screen where the sprite should be.
     */
    @Override
    public void drawOn(DrawSurface d) {
        //creat one clawed.
        d.setColor(new Color(102, 153, 255));
        d.fillRectangle(0, 20, 800, 600);
        d.setColor(new Color(244, 244, 244));
        d.fillCircle(80, 400, 25);
        d.fillCircle(100, 400, 25);
        d.fillCircle(130, 400, 25);
        d.fillCircle(155, 400, 25);
        d.fillCircle(90, 420, 25);
        d.fillCircle(120, 420, 25);
        //creat second clawed.
        d.fillCircle(480, 400, 25);
        d.fillCircle(500, 400, 25);
        d.fillCircle(530, 400, 25);
        d.fillCircle(555, 400, 25);
        d.fillCircle(490, 420, 25);
        d.fillCircle(520, 420, 25);
        int x1 = 80;
        int xLocation1 = 0;
        //creat ten lines
        for (int i = 0; i < 10; i++) {
            d.drawLine(x1, 420, xLocation1, 600);
            x1 += 5;
            xLocation1 += 7;
        }
        int x2 = 480;
        int xLocation2 = 500;
        //creat more ten lines.
        for (int i = 0; i < 10; i++) {
            d.drawLine(x2, 420, xLocation2, 600);
            x2 += 5;
            xLocation2 += 7;
        }
    }

    /**
     * this function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
