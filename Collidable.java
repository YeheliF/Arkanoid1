//ID:207233222
package interfaces;

import geometry.Point;
import geometry.Rectangle;
import information.Velocity;
import theplayers.Ball;

/**
 * this interface have two functions for objects that are Collidable.
 */
public interface Collidable {
    /**
     * this function return for each collidable his own shape of the rectangle.
     *
     * @return - the rectangle of the collidable.
     */
    Rectangle getCollisionRectangle();

    /**
     * the function change the velocity of the ball that hit the collidable
     * <p>
     * this function in each collidable change the velocity of the ball that hit the collidable,
     * according to the place of the collision point on the collidable.
     * <p>
     *
     * @param collisionPoint  - the point that the ball hit the collidable.
     * @param currentVelocity - the velocity of the ball when it hit the collidable.
     * @param hitter          - the ball that hitted.
     * @return - the function return the new velocity after the function change it.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}