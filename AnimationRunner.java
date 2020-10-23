package information;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;

/***
 * this class runs the animation on the game.
 */
public class AnimationRunner {
    static final int WIDTH_GUI = 800;
    static final int HEIGHT_GUI = 600;
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor - creat the gui, a sleeper and the time between frames.
     */
    public AnimationRunner() {
        this.framesPerSecond = 60;
        this.gui = new biuoop.GUI("Arkanoid", WIDTH_GUI, HEIGHT_GUI);
        this.sleeper = new Sleeper();
    }

    /**
     * this function runs the animation it get as an argument.
     * the function runs the animation until the animation should stop.
     *
     * @param animation - the animation the function need to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        //while the animation dont need to stop.
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * this function return the gui of this - the animation we run.
     *
     * @return - th gui of the animation.
     */
    public GUI getGui() {
        return this.gui;
    }
}
