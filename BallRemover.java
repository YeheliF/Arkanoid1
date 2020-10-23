//ID:207233222
package information;

import interfaces.HitListener;
import organizethegame.GameLevel;
import theplayers.Ball;
import theplayers.Block;


/***
 * this class is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor- creat a kind of game and a counter of how many balls there is in the game.
     *
     * @param gameLevel     - the game we are need to controll.
     * @param removedBalles - a counter of how many balls do we have in the game.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalles) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalles;
    }

    /**
     * this function removes balls that are hit from the game, and also remove this listener from the ball.
     *
     * @param beingHit - the block that we need to remove because it was hittes.
     * @param hitter   - the ball that hitted the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        int decreaseOneBall = 1;
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(decreaseOneBall);
    }
}