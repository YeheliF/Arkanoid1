package interfaces;

import biuoop.DrawSurface;

/***
 * this interface organize all the animation there is in the program.
 */
public interface Animation {
    /**
     * this function make all the animation to do one frame of the game.
     *
     * @param d - the screen that the animations need to ba running on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this function decide if the animation should stop or continue running.
     *
     * @return - true- if the function need to stop running. false - otherwise.
     */
    boolean shouldStop();
}
