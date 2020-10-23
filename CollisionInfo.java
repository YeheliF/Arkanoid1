//ID:207233222
package information;

import geometry.Point;
import interfaces.Collidable;

/**
 * this class organize all the information of the collidable -
 * on which collidable the hit was, and where is the point.
 */

public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidableObject;

    /**
     * constructor - creat the information of the collidable - where it happened and between which collidable.
     *
     * @param collisionPoint   - the point at which the collision occurs.
     * @param collidableObject - the collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collidableObject) {
        this.collisionPoint = collisionPoint;
        this.collidableObject = collidableObject;
    }

    /**
     * this function returns the point at which the collision occurs.
     *
     * @return - the point of the collision.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * this function returns the collidable object involved in the collision.
     *
     * @return - the object that was in the collision.
     */
    public Collidable collisionObject() {
        return this.collidableObject;
    }
}