//ID:207233222
package information;

/***
 * this class save a counter that count the number of items in the game.
 */
public class Counter {
    private int counter;

    /**
     * contructor- get an int that will be the started number of the item is in the game.
     *
     * @param count - how much started number of the item is in the game
     */
    public Counter(int count) {
        this.counter = count;
    }

    /**
     * this function add number to current count.
     *
     * @param number - the number we need to add to our counter.
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * this function subtract number from current count.
     *
     * @param number - the number we need to Subtract from our counter.
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     * this function return the current count.
     *
     * @return - the counter.
     */
    public int getValue() {
        return counter;
    }
}
