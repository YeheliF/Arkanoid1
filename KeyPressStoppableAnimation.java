package organizethegame;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/***
 * this class in charge of a case that akey was pressed.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor - get the Animation Runner and the Key board Sensor , and get the key that can be pressed.
     *
     * @param sensor    - the  Key board Sensor
     * @param key       - the key that can be pressed.
     * @param animation - the Animation Runner.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.animation = animation;
        this.key = key;
        stop = false;
        isAlreadyPressed = true;
    }

    /**
     * this fucntion notice if the key was pressed and updating the stop function.
     *
     * @param d - the screen that the animations need to ba running on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        //if the key was pressed
        if (this.sensor.isPressed(key)) {
            //if the key was already pressed.
            if (isAlreadyPressed) {
                return;
            }
            stop = true;
            isAlreadyPressed = false;
            return;
        }
        isAlreadyPressed = false;
    }

    /**
     * this function decide if the animation should stop showing or continue.
     *
     * @return - false - if it stiil need to be shown. true - if it should stop.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}
