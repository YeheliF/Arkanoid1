//ID:207233222
package interfaces;

import biuoop.DrawSurface;

/**
 * this interface have two functions for objects that are Sprite.
 */
public interface Sprite {
    /**
     * this function draw the sprite to the screen she gets.
     *
     * @param d - the screen where the sprite should be.
     */
    void drawOn(DrawSurface d);

    /**
     * this function notify the sprite that time has passed.
     */
    void timePassed();
}