//ID:207233222
package organizethegame;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import information.CollisionInfo;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;
/***
 * this class hold all the collidables of the game on a array list.
 */

public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<>();

    /**
     * this funcion add the given collidable to the environment.
     * @param c - the collidable that the function need to add to the list.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    /**
     * this function remove the collidable c from the collidable list.
     * @param c - the collidable we need to remove from the game.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * this function return the information about the closest collision that is going to occur
     * <p>
     * the function creat two lists - one of all the collidables,
     * and one for all the points that each collidible have with the line.
     * the function add the closest point of each collidable with the line to the list,
     * and save also the specific collidable in a nother list.
     * then she calles to the finction "findClosestPoint" and
     * return a CollisionInfo with the closest collidable and the collision point.
     * <p>
     * @param trajectory - the line that the object move on.
     * @return - the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> specificP = new ArrayList<>();
        List<Collidable> specificC = new ArrayList<>();
        //for each collidable in the list.
        for (Collidable c : collidables) {
            Rectangle r = c.getCollisionRectangle();
            Point intersection = trajectory.closestIntersectionToStartOfLine(r);
            //if there is intersection.
            if (intersection != null) {
                specificP.add(intersection);
                specificC.add(c);
            }
        }
        //if the lost of all the intersection points is noe empty.
        if (specificP.size() == 0) {
            return null;
        } else {
            Point closest = findClosestPoint(specificP, trajectory);
            Collidable closestC = specificC.get(specificP.indexOf(closest));
            return new CollisionInfo(closest, closestC);
        }
    }

    /**
     * this function the closest point of the collisions point
     * that there is on the list she gets with the giving line.
     * and return the closest point.
     * @param specific - a list with all the collision point.
     * @param trajectory - the line that the collision point is with.
     * @return - the closest point of all the list.
     */
    public Point findClosestPoint(List<Point> specific, Line trajectory) {
        //if the list is not empty.
        if (specific != null) {
            Point closestP = specific.get(0);
            //for all the points in the list.
            for (Point p : specific) {
                //if the distance is closer to the start of the line.
                if (p.distance(trajectory.start()) < closestP.distance(trajectory.start())) {
                    closestP = p;
                }
            }
            return closestP;
        }
        return null;
    }
}