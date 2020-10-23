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
 * this class in charge of the second level.
 */
public class Level2 implements LevelInformation {
    /**
     * this fucntion returns the number of ball in this level.
     *
     * @return - the number of balls.
     */
    @Override
    public int numberOfBalls() {
        int numberOfBalls = 10;
        return numberOfBalls;
    }

    /**
     * this function returns a list of all the velocities of the balls in the level.
     *
     * @return - a list of velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocity = new ArrayList();
        int nAngle = -50;
        int pAngle = 10;
        int speed = 7;
        //make 5 velocities with a negative angle.
        for (int i = 0; i < 5; i++) {
            Velocity vBallN = Velocity.fromAngleAndSpeed(nAngle, speed);
            velocity.add(vBallN);
            nAngle += 10;
        }
        //make 5 velocities with a positive angle.
        for (int i = 0; i < 5; i++) {
            Velocity vBallP = Velocity.fromAngleAndSpeed(pAngle, speed);
            velocity.add(vBallP);
            pAngle += 10;
        }
        return velocity;
    }

    /**
     * this fucntion returns the speed of the paddle in this level.
     *
     * @return - the peed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        int speed = 10;
        return speed;
    }

    /**
     * this fucntion returns the width of the paddle in this level.
     *
     * @return - the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        int width = 500;
        return width;
    }

    /**
     * this function return the level name..
     *
     * @return -the level name.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * this function returns a sprite with the background of the level.
     *
     * @return - a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Level2Animation();
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
        double width = 50.5;
        double height = 20;
        double restartX = 730;
        double xPoint = restartX;
        double yPoint = 300;
        int maxColumn = 15;
        //creat all the blocks.
        for (int j = 0; j < maxColumn; j++) {
            Rectangle moreR = new Rectangle(new Point(xPoint, yPoint), width, height);
            Block moreB = new Block(moreR, getColor(j));
            blocks.add(moreB);
            xPoint -= width;
        }
        return blocks;
    }

    /**
     * this function has a cases to creat each two blocks the same color.
     *
     * @param j - the couple that we are now on the loop.
     * @return - the function returns the color to the specific block.
     */
    public Color getColor(int j) {
        //the first couple.
        if (j > -1 && j < 2) {
            return Color.CYAN;
        }
        //the second couple.
        if (j > 1 && j < 4) {
            return Color.PINK;
        }
        //the third couple.
        if (j > 3 && j < 6) {
            return Color.blue;
        }
        //the fourth couple.
        if ((j > 5) && (j < 9)) {
            return Color.green;
        }
        //the five couple.
        if (j > 8 && j < 11) {
            return Color.yellow;
        }
        //the six couple.
        if (j > 10 && j < 13) {
            return Color.orange;
        }
        //the last couple.
        if (j > 12 && j < 15) {
            return Color.red;
        }
        return null;
    }

    /**
     * this function returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return - number of blocks that should be removed
     */
    @Override
    public int numberOfBlocksToRemove() {
        int numberOfBlocks = 15;
        return numberOfBlocks;
    }
}

