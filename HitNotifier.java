//ID:207233222
package interfaces;

/***
 * this interface is save all the Hitlistener that we need to listen to.
 */
public interface HitNotifier {


    /**
     * Add hl as a listener to hit events.
     *
     * @param hl - the hit listener we need to add.
     */
    void addHitListener(HitListener hl);


    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl - the hitlistener we need to remove.
     */
    void removeHitListener(HitListener hl);
}
