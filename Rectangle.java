//ID:207233222
package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * this class creat a rectangle with a upper left point, a width and a height.
 */

public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor- creat a rectangle from his upperLeft, his width ,his height.
     *
     * @param upperLeft = a point that will be the the upper left point of the rectangle.
     * @param width     = the width of the the rectangle.
     * @param height    = the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * this function return the upper right point of the rectangle.
     * this point is the same as the upper left, but with the width.
     *
     * @return - upper right point of the rectangle.
     */
    public Point upperRight() {
        double newX = upperLeft.getX() + width;
        return new Point(newX, upperLeft.getY());
    }

    /**
     * this function return the down left point of the rectangle.
     * this point is the same as the upper left, but with the height.
     *
     * @return - down left point of the rectangle.
     */
    public Point downLeft() {
        double newY = upperLeft.getY() + height;
        return new Point(upperLeft.getX(), newY);
    }

    /**
     * this function return the down right point of the rectangle.
     * this point is the same as the upper left, but with the height and width.
     *
     * @return - down right point of the rectangle.
     */
    public Point downRight() {
        double newX = upperLeft.getX() + width;
        double newY = upperLeft.getY() + height;
        return new Point(newX, newY);
    }

    /**
     * this function return the upper line of the rectangle.
     * this line is from the upper left point until the upper right point.
     *
     * @return - upper line of the rectangle.
     */
    public Line upperLine() {
        return new Line(upperLeft, upperRight());
    }

    /**
     * this function return the down line of the rectangle.
     * this line is from the down left point until the down right point.
     *
     * @return - down line of the rectangle.
     */
    public Line downLine() {
        return new Line(downLeft(), downRight());
    }

    /**
     * this function return the right line of the rectangle.
     * this line is from the upper right point until the down right point.
     *
     * @return - right line of the rectangle.
     */
    public Line rightLine() {
        return new Line(upperRight(), downRight());
    }

    /**
     * this function return the left line of the rectangle.
     * this line is from the down left point until the upper left point.
     *
     * @return - left line of the rectangle.
     */
    public Line leftLine() {
        return new Line(downLeft(), upperLeft);
    }

    /**
     * this function return a list with all the points that the line have with each line of rectangle.
     * she calles the function "intersectionWith" from the point class , and if there is a point,
     * the function add it to the list.
     *
     * @param line - this is the line that we check if it has a intersection points with the rectangle.
     * @return a list of intersections point between the line and the rectangle.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<>();
        //if there is a intersection point between the line and the upper line of the rectangle
        if (line.intersectionWith(upperLine()) != null) {
            intersections.add(line.intersectionWith(upperLine()));
        }
        //if there is a intersection point between the line and the down line of the rectangle
        if (line.intersectionWith(downLine()) != null) {
            intersections.add(line.intersectionWith(downLine()));
        }
        //if there is a intersection point between the line and the right line of the rectangle
        if (line.intersectionWith(rightLine()) != null) {
            intersections.add(line.intersectionWith(rightLine()));
        }
        //if there is a intersection point between the line and the left line of the rectangle
        if (line.intersectionWith(leftLine()) != null) {
            intersections.add(line.intersectionWith(leftLine()));
        }
        return intersections;
    }

    /**
     * this function returns width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this function returns the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * this function returns the upper-left point of the rectangle.
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * this function get a chang value, and change the upper left point of the rectangle according to this value.
     *
     * @param change - the value we need to add to the X value of the upper left point of the rectangle.
     * @return - the new upper left point of the rectangle.
     */
    public Point changePoint(int change) {
        double newX = this.upperLeft.getX() + change;
        this.upperLeft = new Point(newX, this.upperLeft.getY());
        return upperLeft;
    }
}