package organizethegame;

import biuoop.DrawSurface;
import information.Counter;
import interfaces.Animation;

/***
 * this class organize all the screens on the end of the game.
 */
public class EndScreen implements Animation {
    private Counter score;
    private String winLose;
    private boolean stop;

    /**
     * constructor - decide the case of the screen - lose or win, how much the score is.
     *
     * @param cases - win or lose.
     * @param score - what is the score on the end.
     */
    public EndScreen(String cases, Counter score) {
        this.winLose = cases;
        this.score = score;
        this.stop = false;
    }

    /**
     * this function draw in the frame the end screen.
     * if the case is win - the screen shows tou won and his score.
     * if the case is lose - the screen shows tou lost and his score.
     *
     * @param d - the screen that the animations need to ba running on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        //if the player won.
        int startXLocation = 50;
        int startYLocation = 400;
        int sizeWriting = 30;
        if (winLose == "win") {
            d.drawText(startXLocation, startYLocation, "You Win! Your score is " + score.getValue(), sizeWriting);
        } else {
            d.drawText(startXLocation, startYLocation, "Game Over. Your score is " + score.getValue(), sizeWriting);
        }
    }

    /**
     * this function decide if the animetion should stop showing or continue.
     *
     * @return - false - if it stiil need to be shown. true - if it should stop.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}
