//ID:207233222
package geometry;

/**
 * this class creat a point.
 */

public class Point {
    private static final double EPSILON = 0.0001;
    private double x;
    private double y;

    /**
     * contructor- creat a point from 2 arguments.
     *
     * @param x =int from the user.
     * @param y =int from the user.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * the function gets a point ,and returns the distance between both of them.
     * <p>
     * the function subtract the value of x from both points, and subtract the value of y from both points
     * and return the distance between them in absolute value.
     * <p>
     *
     * @param other - the function gets a Point.
     * @return the distance between the two points in absolute value.
     */
    public double distance(Point other) {
        double disx = this.x - other.x;
        double disy = this.y - other.y;
        return Math.sqrt(disx * disx + disy * disy);
    }

    /**
     * the function gets a point ,and check if this point and the point she got are the same.
     * <p>
     * the function compare between the value of x in this point and in the other point,and also compare the value of y
     * if the two values are the same- the function returns true,otherwise-false.
     * <p>
     *
     * @param other - the function gets a Point.
     * @return true- if the Points are the same, false- if they are not.
     */
    public boolean equals(Point other) {
        //if the value of x in those points are the same
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }

    /**
     * the function returns the value of x in this point.
     * <p>
     *
     * @return the value of x in this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * the function returns the value of y in this point.
     * <p>
     *
     * @return the value of y in this point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * this function chackes if the intersection point is in the range of the giving line.
     * she send the maximum,minimun and the point to the function :checkEpsilon"
     *
     * @param line - the line that the check if the point is on him.
     * @return - true - is the point is in the range of the line, false - if it doesnt.
     */
    public boolean isPointIntersection(Line line) {
        //if the function "checkEpsilon" return true for the X value and the Y value of the point.
        if ((checkEpsilon(line.minX(), line.maxX(), this.x)) && (checkEpsilon(line.minY(), line.maxY(), this.y))) {
            return true;
        }
        return false;
    }

    /**
     * the function check if the distance between the X or Y value of the point
     * to the maximum or minimum of the line is smaller that EPSILON-a very small value.
     *
     * @param minValue   - the smallest value.
     * @param maxValue   - the bigest value..
     * @param checkValue - the value that need to be between the others.
     * @return - true - if the distance is smaller that EPSILON between the maximum and minimum value,false- otherwise.
     */
    public boolean checkEpsilon(double minValue, double maxValue, double checkValue) {
        //if the distance from the maximum/minimum value to the check value is smaller than EPSILON.
        if ((checkValue - maxValue <= EPSILON) && (minValue - checkValue <= EPSILON)) {
            return true;
        }
        return false;
    }
}
