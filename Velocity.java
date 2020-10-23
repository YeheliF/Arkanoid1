// ID:207233222
package information;

import geometry.Point;

/**
 * this class creat a velocity from an angle and speed or from two values.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * contructor- creat a velocity from an angle and a speed.
     * the velocity is creating by a mathematical formula with cosinus and sinus.
     *
     * @param angle =the angle that the ball is aimed at.
     * @param speed = the speed the ball is about to move.
     * @return a new velocity.
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double newAngle = Math.toRadians(angle);
        double dx = Math.sin(newAngle) * speed;
        double dy = -Math.cos(newAngle) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * contructor- creat a velocity from an arguments..
     *
     * @param dx =with the 'dy' they creat the new velocity.
     * @param dy =with the 'dy' they creat the new velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * the function returns the dx value from the velocity.
     * <p>
     *
     * @return the value of dx from the velocity.
     */
    public double getDx() {
        return dx;
    }

    /**
     * the function returns the dy value from the velocity.
     * <p>
     *
     * @return the value of dy from the velocity.
     */
    public double getDy() {
        return dy;
    }

    /**
     * this function return the angle of the velocity.
     * the angle is calculated with a mathematical formula with cosinus and sinus.
     *
     * @return - the angle of the velocity.
     */
    public double getAngle() {
        double angle = Math.atan(this.getDx() / this.getDy());
        return angle;
    }

    /**
     * this function return the speed of the velocity.
     * the speed is calculated with the angle and a mathematical formula with cosinus and sinus.
     *
     * @return - the speed of the velocity.
     */
    public double getSpeed() {
        return (this.getDx() / Math.sin(this.getAngle()));
    }

    /**
     * the function updating the dx value from the velocity.
     * <p>
     *
     * @param newDx = the new dx value we updating the velicity.
     */

    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * the function updating the dy value from the velocity.
     * <p>
     *
     * @param newDy = the new dy value we updating the velicity.
     */
    public void setDy(double newDy) {
        this.dy = newDy;
    }

    /**
     * the function get a point, and add the value of dx to her x, and add tha value of dy to her y
     * and creat a new point.
     *
     * @param p - the point we want to change.
     * @return a new point.
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + dx;
        double newY = p.getY() + dy;
        return new Point(newX, newY);
    }
}

