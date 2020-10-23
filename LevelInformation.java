package interfaces;

import information.Velocity;
import theplayers.Block;

import java.util.List;

/***
 * this interface organize all the levels of the game - all the information about them.
 */
public interface LevelInformation {
    /**
     * this function return the number of ball in the level.
     *
     * @return - the number of balls.
     */
    int numberOfBalls();


    /**
     * this function  initial the velocity of each ball on the level.
     *
     * @return - a list of all the velocities of the balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * this function return the speed of the paddle in the level.
     *
     * @return - the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * this function return the width of the paddle in the level.
     *
     * @return - the width of the paddle.
     */
    int paddleWidth();


    /**
     * this function return the level name..
     *
     * @return -the level name.
     */
    String levelName();

    /**
     * this function returns a sprite with the background of the level.
     *
     * @return - a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * this function returns a list with the blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return - a list with the blocks of the level.
     */
    List<Block> blocks();

    /**
     * this function returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return - number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}
