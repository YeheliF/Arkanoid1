//ID:207233222
package interfaces;

import theplayers.Ball;
import theplayers.Block;

/***
 * this interface organize all the classes we need to call when there is a hit in the game.
 */
public interface HitListener {

    /**
     * This function is called whenever the beingHit object is hit.
     *
     * @param beingHit - the block that was hitted.
     * @param hitter   - the ball that was hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
