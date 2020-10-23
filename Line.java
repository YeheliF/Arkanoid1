//ID:207233222
package geometry;

import java.util.List;

import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * this class creat a line with two points- start point and end point.
 */

public class Line {
    private Point start;
    private Point end;
    private Point middle;

    /**
     * constructor- creat a line from 2 points.
     *
     * @param start =a point that will be the start of the line.
     * @param end   = a point that will be the end of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * contructor- creat a line from 4 arguments.
     *
     * @param x1 = with y1 they will be a point that will be the start of the line.
     * @param y1 = with x1 they will be a point that will be the start of the line.
     * @param x2 = with y2 they will be a point that will be the end of the line.
     * @param y2 = with x2 they will be a point that will be the end of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * the function returns the distance between the start point and the end point- the length of the line.
     * <p>
     * the function calls the function distance from the point class with
     * the value of the start point and the end point of the line.
     * <p>
     *
     * @return the length of the line.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * the function find the point that in the middle of the line.
     * <p>
     * the function find the middle between the x value of the start and end point,
     * and between the y value of the start and end point.
     * then the function creat a new point with the two arguments she found- and return that point.
     * <p>
     *
     * @return the point in the middle of the line.
     */
    public Point middle() {
        double half = 2;
        double midx = (start.getX() + end.getX()) / half;
        double midy = (start.getY() + end.getY()) / half;
        this.middle = new Point(midx, midy);
        return this.middle;
    }

    /**
     * the function returns the start point of this line.
     * <p>
     *
     * @return the value of the point start of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * the function returns the end point of this line.
     * <p>
     *
     * @return the value of the point end of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * the function find the slope of the line:the 'm' of the equasion of a line.
     * <p>
     * the function use the value of the start and end points,
     * and with mathematical formula it gets the slope of the line:
     * <p>
     *
     * @return slope of the line.
     */
    public double slope() {
        double slope = (end.getY() - start.getY()) / (end.getX() - start.getX());
        return slope;
    }

    /**
     * the function find the point of intersection with the y axis:the 'b' of the equasion of a line.
     * <p>
     * the function use the value of the start and end points,
     * the slope of this line from the 'slope function'
     * and with mathematical formula it gets the intersection of the line with the y axis.
     * <p>
     *
     * @return the intersection of the line with the y axis.
     */
    public double intercept() {
        double m = slope();
        double intercept = end.getY() - m * end.getX();
        return intercept;
    }

    /**
     * the function returns the minimum value of x from the line.
     * <p>
     * the function compare between the x value of the start point and the x value of the end point,
     * and returns the minimum between them.
     *
     * @return the minimum value of x from the line.
     */
    public double minX() {
        return min(start.getX(), end.getX());
    }

    /**
     * the function returns the maximum value of x from the line.
     * <p>
     * the function compare between the x value of the start point and the x value of the end point,
     * and returns the maximum between them.
     *
     * @return the maximum value of x from the line.
     */
    public double maxX() {
        return max(start.getX(), end.getX());
    }

    /**
     * the function returns the minimum value of y from the line.
     * <p>
     * the function compare between the y value of the start point and the y value of the end point,
     * and returns the minimum between them.
     *
     * @return the minimum value of y from the line.
     */
    public double minY() {
        return min(start.getY(), end.getY());
    }

    /**
     * the function returns the maximum value of y from the line.
     * <p>
     * the function compare between the y value of the start point and the y value of the end point,
     * and returns the maximum between them.
     *
     * @return the maximum value of y from the line.
     */
    public double maxY() {
        return max(start.getY(), end.getY());
    }

    /**
     * the function checks if the lines are intersecting.
     * <p>
     * The function is divided into cases:1)if the lines are parallel to the x-axis
     * 2)if just one line is parallel to the x-axis.
     * 3)otherwise-no one of the lines are parallel to the x-axis.
     *
     * @param other -the function gets another line.
     * @return true-if the lines are intersecting, false-if there are not.
     */
    public boolean isIntersecting(Line other) {
        //if the value of x in the start and end point of the two lines are the same=option number 1.
        if (start.getX() == end.getX() && other.start.getX() == other.end.getX()) {
            Point bothParallels = bothParallels(other);
            return bothParallels != null;
        }
        //if the value of x in the start and end point of of one of the lines are the same=option number 2.
        if (start.getX() == end.getX() || other.start.getX() == other.end.getX()) {
            Point oneParallels = oneParallels(other);
            return oneParallels != null;
        } else {
            Point sharedPoint = findShared(other);
            //if there isn't a shared point between the two lines.
            if (sharedPoint == null) {
                return false;
            }
            return sharedPoint.getX() >= this.minX() && sharedPoint.getX() >= other.minX()
                    && sharedPoint.getX() <= this.maxX() && sharedPoint.getX() <= other.maxX();
        }
    }

    /**
     * the function finds the point that the two lines have in common if the lines are not parallel to the x-axis.
     * <p>
     * the function using the functions 'scope' and 'intercept',and find the 'm' and the 'b' of the equasion of a line.
     * then,with mathematical formula it gets point that the two lines have in common.
     *
     * @param other - the function gets another line.
     * @return sharedPoint=the point that the two lines have in common or null-if they dont have that point.
     */
    public Point findShared(Line other) {
        double b = this.intercept();
        double m = this.slope();
        double bOther = other.intercept();
        double mOther = other.slope();
        //if the two lines don't have the same slope.
        if (m != mOther) {
            double xShared = (b - bOther) / (mOther - m);
            double yShared = m * xShared + b;
            Point sharedPoint = new Point(xShared, yShared);
            return sharedPoint;
        }
        //if one line begins right after the other line.-if they have a common point at the edges.
        if (start.equals(other.start) || start.equals(other.end)) {
            Point sharedPoint = start;
            return sharedPoint;
        }
        //if one line begins right after the other line.-if they have a common point at the edges.
        if (end.equals(other.start) || end.equals(other.end)) {
            Point sharedPoint = end;
            return sharedPoint;
        }
        //if the two lines have the same intersection with the y axis.
        if (b == bOther) {
            return null;
        }
        return null;
    }

    /**
     * the function finds the point that the two lines have in common if one of the lines is parallel to the x-axis.
     * <p>
     * the function using the functions 'scope' and 'intercept',and find the 'm' and the 'b' of the equasion of a line
     * that don't parallel to the x-axis.
     * then,with mathematical formula it gets point that the two lines have in common.
     *
     * @param other - the function gets another line.
     * @return sharedPoint=the point that the two lines have in common or null-if they dont have that point.
     */
    public Point oneParallels(Line other) {
        //if the value of x in the start and end point of the first line are the same.
        if (start.getX() == end.getX()) {
            double bOther = other.intercept();
            double mOther = other.slope();
            double yShared = mOther * start.getX() + bOther;
            //if the value of y in the shared point is in the range of the line that parallel to the x-axis.
            if (yShared >= this.minY() && yShared <= this.maxY()) {
                Point sharedPoint = new Point(start.getX(), yShared);
                return sharedPoint;
            } else {
                return null;
            }
        }
        if (other.start.getX() <= this.maxX() && other.start.getX() >= this.minX()) {
            double b = this.intercept();
            double m = this.slope();
            double yShared = m * other.start.getX() + b;
            //if the value of y in the shared point is in the range of the line that parallel to the x-axis.
            if (yShared >= other.minY() && yShared <= other.maxY()) {
                Point sharedPoint = new Point(other.start.getX(), yShared);
                return sharedPoint;
            }
            return null;
        }
        return null;
    }


    /**
     * the function finds the point that the two lines have in common if both lines are parallel to the x-axis.
     * <p>
     * the function check if the two lines have the same value of x in the all line
     * and if they have just one point in common.
     *
     * @param other - the function gets another line.
     * @return sharedPoint=the point that the two lines have in common or null-if they dont have that point.
     */
    public Point bothParallels(Line other) {
        //if the two lines have the same value of x in the all line.
        if (start.getX() == other.start.getX()) {
            //if the minimum value of one line is equals to the maximum value of the other line.
            if (this.minY() == other.maxY() || other.minY() == this.maxY()) {
                Point shared = new Point(start.getX(), this.minY());
                return shared;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * the function finds the point that the two lines have in common if they have one.
     * <p>
     * The function is divided into cases:1)if the function 'isIntersection' return false.
     * 2)if the lines are parallel to the x-axis
     * 3)if just one line is parallel to the x-axis.
     * 3)otherwise-no one of the lines are parallel to the x-axis.
     * in every case the function finds the point they have in common and return it.
     *
     * @param other -the function gets another line.
     * @return sharedPoint=the point that the two lines have in common or null-if they dont have that point.
     */
    public Point intersectionWith(Line other) {
        //if the function 'isIntersection' return false=the lines dont have a common point.
        if (!isIntersecting(other)) {
            return null;
        }
        //if the value of x in the start and end point of the two lines are the same=option number 2.
        if (start.getX() == end.getX() && other.start.getX() == other.end.getX()) {
            Point bothParallels = bothParallels(other);
            return bothParallels;
        }
        //if the value of x in the start and end point of of one of the lines are the same=option number 3.
        if (start.getX() == end.getX() || other.start.getX() == other.end.getX()) {
            Point oneParallels = oneParallels(other);
            return oneParallels;
        }
        Point sharedPoint = findShared(other);
        return sharedPoint;
    }

    /**
     * the function checks if the lines are the same one.
     * <p>
     * the function checks if the start point and the end point of the lines are the same.
     * if they are-the lines are the same one, otherwise-they don't.
     *
     * @param other -the function gets a nother line
     * @return true- if the lines are the same, false- if they are not the same.
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    /**
     * this function returns the point of the closes intersection of a rectangle to the start of a line.
     * <p>
     * the function send the rectangle shr gets to the function "intersectionPoints"
     * and get back a list of all the intersections between the rectangle and the line.
     * if the list is not empty, the function find the closest one and return it.
     * <p>
     *
     * @param rect - the rectangle that we need to get the closest intersection of her with the line.
     * @return - the closest point intersection between the rectangle and the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        int firstPlace = 0;
        //if the list of all the points intersection is not empty.
        if (rect.intersectionPoints(this).size() != firstPlace) {
            List<Point> intersections = rect.intersectionPoints(this);
            Point closestP = intersections.get(firstPlace);
            double closestD = intersections.get(firstPlace).distance(this.start);
            //for each point in the list.
            for (Point point : intersections) {
                if (point.distance(this.start) < closestD) {
                    closestD = point.distance(this.start);
                    closestP = point;
                }
            }
            return closestP;
        } else {
            return null;
        }
    }
}
