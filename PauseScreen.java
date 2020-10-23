package organizethegame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/***
 * this class in charge of a case with a pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor - gets the key board , and initialize the stop to false.
     *
     * @param k - the key board sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * this function draw on the screen the pause screen in the game.
     *
     * @param d - the screen that the animations need to ba running on.
     */
    public void doOneFrame(DrawSurface d) {
        int xLocation = 10;
        int yLocation = d.getHeight() / 2;
        int sizeWriting = 32;
        d.drawText(xLocation, yLocation, "paused -- press space to continue", sizeWriting);
    }

    /**
     * this function decide if the animetion should stop showing or continue.
     *
     * @return - false - if it stiil need to be shown. true - if it should stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}