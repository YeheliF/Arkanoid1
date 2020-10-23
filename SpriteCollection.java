//ID:207233222
package organizethegame;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/***
 * this class hold all the sprites that there is in the game in a list.
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<>();

    /**
     * this function add a sprite she gets to the list.
     *
     * @param s - the sprite that the function need to add to the list.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * this function removethe sprite s from the sprites list.
     *
     * @param s - the sprite we need to remove from the game.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * this function go over all the sprites on the list and call the function "timePassed" on all sprites.
     */
    public void notifyAllTimePassed() {
        //for each sprite on the list copy to another list.
        List<Sprite> sprites1 = new ArrayList<>();
        for (Sprite s : sprites) {
            sprites1.add(s);
        }
        //for each sprite on the new list.
        for (Sprite s : sprites1) {
            s.timePassed();
        }
    }

    /**
     * this function go over all the sprites on the list and call the function "drawOn" on all sprites.
     *
     * @param d - the screen where the function need to draw all the sprites.
     */
    public void drawAllOn(DrawSurface d) {
        //for each sprite on the list.
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
