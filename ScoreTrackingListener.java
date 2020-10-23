//ID:207233222
package information;

import interfaces.HitListener;
import theplayers.Ball;
import theplayers.Block;

/***
 * this class tracking after the score we got on the game.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor- get a counter and save him in the class.
     *
     * @param scoreCounter - the started counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * when there is a hit of the ball to a block' this function added a 5 to the counter she save.
     *
     * @param beingHit - the block we hitted.
     * @param hitter   - the ball that hitted.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        int hitBlockScore = 5;
        currentScore.increase(hitBlockScore);
    }
}