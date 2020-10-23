package organizethegame;

import biuoop.KeyboardSensor;
import information.AnimationRunner;
import information.Counter;
import interfaces.LevelInformation;

import java.util.List;

/***
 * this class flows the whole game.
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * constructor - get the Animation Runner and the Key board Sensor , and initialize the score to zero.
     *
     * @param ar - the animation.
     * @param ks - the key board sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        score = new Counter(0);
    }

    /**
     * this function runs all the levels she got.
     * she go over all the list of the levels, and run them one after one if the player didnt lose the game.
     * at the end - she calls to the end screen.
     *
     * @param levels - the list of all the levels of the current game.
     */
    public void runLevels(List<LevelInformation> levels) {
        int noMore = 0;
        //go over all the levels on the list.
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.keyboardSensor, score);

            level.initialize();
            //while the are still balls and blocks on the game.
            while (level.getBallCounter() > noMore && level.getBlocksCounter() > noMore) {
                level.run();
            }
            //if there isn't balls on the screen.
            if (level.getBallCounter() == noMore) {

                animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new EndScreen("lose", score)));
                animationRunner.getGui().close();
            }
        }
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                new EndScreen("win", score)));
        animationRunner.getGui().close();
    }
}
