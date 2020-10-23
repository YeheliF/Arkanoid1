package organizethegame;

import geometry.Point;
import geometry.Rectangle;
import information.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import theplayers.Block;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/***
 * this class in charge of the first level.
 */
public class Level1 implements LevelInformation {
    /**
     * this fucntion returns the number of ball in this level.
     *
     * @return - the number of balls.
     */
    @Override
    public int numberOfBalls() {
        int one = 1;
        return one;
    }

    /**
     * this function returns a list of all the velocities of the balls in the level.
     *
     * @return - a list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        int angle = 0;
        int speed = 7;
        Velocity level1 = Velocity.fromAngleAndSpeed(angle, speed);
        List<Velocity> velocity = new ArrayList();
        velocity.add(level1);
        return velocity;
    }

    /**
     * this fucntion returns the speed of the paddle in this level.
     *
     * @return - the peed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        int speed = 5;
        return speed;
    }

    /**
     * this fucntion returns the width of the paddle in this level.
     *
     * @return - the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        int width = 80;
        return width;
    }

    /**
     * this function return the level name..
     *
     * @return -the level name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * this function returns a sprite with the background of the level.
     *
     * @return - a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Level1Animation();
    }

    /**
     * this function returns a list with the blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return - a list with the blocks of the level.
     */
    @Override
    public List<Block> blocks() {
        List blocks = new ArrayList();
        Rectangle rectangle = new Rectangle(new Point(400, 150), 20, 20);
        Block block1 = new Block(rectangle, Color.red);
        blocks.add(block1);
        return blocks;
    }

    /**
     * this function returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return - number of blocks that should be removed
     */
    @Override
    public int numberOfBlocksToRemove() {
        int one = 1;
        return one;
    }
}
