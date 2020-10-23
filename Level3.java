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
 * this class in charge of the third level.
 */
public class Level3 implements LevelInformation {
    /**
     * this fucntion returns the number of ball in this level.
     *
     * @return - the number of balls.
     */
    @Override
    public int numberOfBalls() {
        int numberOfBalls = 2;
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
        Velocity vBall1 = Velocity.fromAngleAndSpeed(30, 8);
        velocity.add(vBall1);
        Velocity vBall2 = Velocity.fromAngleAndSpeed(-30, 8);
        velocity.add(vBall2);
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
        return "Green 3";
    }

    /**
     * this function returns a sprite with the background of the level.
     *
     * @return - a sprite with the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return new Level3Animation();
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
        double width = 50;
        double height = 20;
        double restartX = 730;
        double xPoint = restartX;
        double yPoint = 150;
        int maxLine = 5;
        int maxColumn = 10;
        //for each line, change the place where the line is started.
        for (int i = 0; i < maxLine; i++) {
            //for each block in the same line- creat the rectangle with the same color.
            for (int j = 0; j < maxColumn - i; j++) {
                Rectangle moreR = new Rectangle(new Point(xPoint, yPoint), width, height);
                Block moreB = new Block(moreR, getColor(i));
                blocks.add(moreB);
                xPoint -= width;
            }
            xPoint = restartX;
            yPoint += height;
        }
        return blocks;
    }

    /**
     * this function has a switch case to creat each line of the blocks the same color.
     *
     * @param i - the line that we are now on the loop.
     * @return - the function returns the line to the specific line.
     */
    public Color getColor(int i) {
        switch (i) {
            //each case is for different the line.
            case 0:
                return Color.gray;
            case 1:
                return Color.red;
            case 2:
                return Color.yellow;
            case 3:
                return Color.blue;
            case 4:
                return Color.white;
            default:
                return null;
        }
    }

    /**
     * this function returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return - number of blocks that should be removed
     */
    @Override
    public int numberOfBlocksToRemove() {
        int numberOfBlocksToRemove = 40;
        return numberOfBlocksToRemove;
    }
}