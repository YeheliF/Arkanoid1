//ID:207233222
package organizethegame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import information.Counter;
import information.AnimationRunner;
import information.Velocity;
import information.BlockRemover;
import information.ScoreTrackingListener;
import information.BallRemover;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import theplayers.Block;
import theplayers.CountdownAnimation;
import theplayers.ScoreIndicator;
import theplayers.Paddle;
import theplayers.Ball;


import java.awt.Color;

/**
 * this class creat the a one game and run it.
 */
public class GameLevel implements Animation {
    static final int RADIUS_BALL = 5;
    static final int START_BALL1_X = 410;
    static final int START_BALL1_Y = 540;
    static final int SIZE_GAME_X = 800;


    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Paddle paddle;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;


    /**
     * constructor - creat the kind of the spites and environment of the level of the game.
     * and initialize the score the balls and the number of blocks.
     * and creat a ball and a block remover, a running animation and a keyboard.
     * @param levelInformation - the information about the level.
     * @param animationRunner - the animation that runns on the screen.
     * @param keyboardSensor - the key board
     * @param score - the score of the game.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner,
                     KeyboardSensor keyboardSensor, Counter score) {
        this.levelInformation = levelInformation;
        int numOfBlocks = this.levelInformation.numberOfBlocksToRemove();
        int startedBalls = this.levelInformation.numberOfBalls();
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        blockCounter = new Counter(numOfBlocks);
        this.score = score;
        ballCounter = new Counter(startedBalls);
        running = true;
        runner = animationRunner;
        keyboard = keyboardSensor;
    }

    /**
     * this function initialize the game- creat all the objects, and add them to the game.
     * <p>
     * this function creat a new screen where the game will be,
     * creat two balls with center, radios, color, environment of the game and a velocity.
     * creat the paddle of the game.
     * creat blocks-game screen borders, and more blocks in the game.
     * and add all the objects to the game with the function from Ball and Block classes.
     * <p>
     */
    public void initialize() {
        //add the background f the level.
        addSprite(levelInformation.getBackground());
        //creat the Paddle of the game, and add it.
        Rectangle thePaddle = new Rectangle(new Point(SIZE_GAME_X / 2 - this.levelInformation.paddleWidth() / 2, 560)
                , this.levelInformation.paddleWidth(), 20);
        this.paddle = new Paddle(thePaddle, Color.yellow, keyboard, this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
        BlockRemover blockRemover = new BlockRemover(this, blockCounter);
        ScoreTrackingListener updatingScore = new ScoreTrackingListener(this.score);
        //creat the game screen borders as a blocks- with rectangle, color. and add them to the game.
        Rectangle rectangle1 = new Rectangle(new Point(0, 20), 20, 580);
        Block blockLeft = new Block(rectangle1, Color.gray);
        Rectangle rectangle2 = new Rectangle(new Point(20, 20), 780, 20);
        Block blockUp = new Block(rectangle2, Color.gray);
        Rectangle rectangle3 = new Rectangle(new Point(0, 600), 780, 20);
        Block blockDown = new Block(rectangle3, Color.gray);
        blockDown.addHitListener(new BallRemover(this, ballCounter));
        Rectangle rectangle4 = new Rectangle(new Point(780, 20), 20, 580);
        Block blockRight = new Block(rectangle4, Color.gray);
        //creat the score window and add it to the game.
        ScoreIndicator scoreWindow = new ScoreIndicator(score.getValue(), this);
        scoreWindow.addToGame(this);
        Block[] blocks = new Block[]{blockUp, blockDown, blockLeft, blockRight};
        //go over all the game screen borders blocks.
        for (Block b : blocks) {
            b.addToGame(this);
        }
        //go over all the blocks of this level and add them to the hit listener of the block and updating score
        // and add the to the game.
        for (Block block : this.levelInformation.blocks()) {
            block.addHitListener(blockRemover);
            block.addHitListener(updatingScore);
            block.addToGame(this);
        }
    }

    /**
     * this function runs the game - creat a balls and use the runner to run the current animation.
     */

    public void run() {
        int numOfSeconds = 2;
        int countFrom = 3;
        this.createBallsOnTopOfPaddle();
        this.runner.run(new CountdownAnimation(numOfSeconds, countFrom, sprites));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * this function creat the balls on the paddle -
     * go over all the velocities in the game level and creat a ball of them.
     */
    public void createBallsOnTopOfPaddle() {
        //go over all the velocities in the game information and creat a ball of them.
        for (Velocity velocity : this.levelInformation.initialBallVelocities()) {
            Ball ball1 = new Ball(START_BALL1_X, START_BALL1_Y, RADIUS_BALL, Color.white, environment);
            ball1.setVelocity(velocity);
            ball1.addToGame(this);
        }
    }

    /**
     * this function remove the collidable form the list of all the collidable that in the gameEnvironment.
     *
     * @param c - the collidable we need to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * this function remove the sprite form the list of all the sprites.
     *
     * @param s - the sprite we need to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * this function draw all the sprites on the screen , and updating the running if the level should stop.
     *
     * @param d - the screen that the animations need to ba running on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        int noMore = 0;
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        // stopping condition:
        //if there is no more balls.
        if (this.ballCounter.getValue() == noMore) {
            this.running = false;
        }
        //if there is no more blocks.
        if (this.blockCounter.getValue() == noMore) {
            this.running = false;
        }
        //if the "p" key was pressed.
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(keyboard)));
        }
        int sizeWrite = 15;
        int startedXpoint = 550;
        int startedYpoint = 14;
        d.setColor(Color.BLACK);
        d.drawText(startedXpoint, startedYpoint, "Level Name: " + this.levelInformation.levelName(), sizeWrite);
    }

    /**
     * this function decide if the animation should stop showing or continue.
     *
     * @return - false - if it stiil need to be shown. true - if it should stop.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * this function add a collidable to the environment of the game.
     *
     * @param c - the collidable that add to the environment.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * this function add a sprite to the sprites list of the game.
     *
     * @param s - the sprite that need to add to the sprites list.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * this function return the score of the game.
     *
     * @return - the current score.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * this function return how much balls there is in the game.
     *
     * @return - the number of balls.
     */
    public int getBallCounter() {
        return this.ballCounter.getValue();
    }

    /**
     * this function return how much blocks there is in the game.
     *
     * @return - the number of blocks.
     */
    public int getBlocksCounter() {
        return this.blockCounter.getValue();
    }
}