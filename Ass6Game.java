//ID:207233222


import biuoop.KeyboardSensor;
import information.AnimationRunner;
import interfaces.LevelInformation;
import organizethegame.GameFlow;
import organizethegame.Level2;
import organizethegame.Level3;
import organizethegame.Level4;
import organizethegame.Level1;

import java.util.ArrayList;
import java.util.List;

/**
 * this class creat a new game.
 */
public class Ass6Game {
    /**
     * this function creat a new game with a lot of levels, calles the initialize function, and then run the game.
     *
     * @param args - an array with the numbers of the levels the game will run on.
     */
    public static void main(String[] args) {
        AnimationRunner animationRunner = new AnimationRunner();
        KeyboardSensor keyboardSensor = animationRunner.getGui().getKeyboardSensor();
        List<LevelInformation> levels = new ArrayList();
        //for each arg on the args list.
        for (String level : args) {
            //if the arg is 1
            if (level.equals("1")) {
                levels.add(new Level1());
            }
            //if the arg is 2
            if (level.equals("2")) {
                levels.add(new Level2());
            }
            //if the arg is 3
            if (level.equals("3")) {
                levels.add(new Level3());
            }
            //if the arg is 4
            if (level.equals("4")) {
                levels.add(new Level4());
            }
        }
        //if the list of levels is empty.
        if (levels.isEmpty()) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor);
        gameFlow.runLevels(levels);
    }
}
