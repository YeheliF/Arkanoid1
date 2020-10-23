//ID:207233222
package information;

import interfaces.HitListener;
import organizethegame.GameLevel;
import theplayers.Ball;
import theplayers.Block;

/***
 * this class is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor- creat a kind of game and a counter of how many blocks there is in the game.
     *
     * @param gameLevel     - the game we are need to control.
     * @param removedBlocks - a counter of how many blacks do we have in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * this function removes balls that are hit from the game, from the game
     * and also remove this listener from the ball.
     *
     * @param beingHit - the block that we need to remove because it was hittes.
     * @param hitter   - the ball that hitted the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        int decreaseOneBlock = 1;
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(decreaseOneBlock);
    }
}