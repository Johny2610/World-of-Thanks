package de.programmierenlernenhq.panzerhq;

/**
 *
 * @author ProgrammierenLernenHQ
 */
public class Coordinate {
    private double x;
    private double y;
    /**
     * @param x
     * @param y
     */
    public Coordinate(double x, double y) {
      this.x = x;
      this.y = y;
    }             
    /**
     * @return x
     */
    public double getX() {
        return this.x;
    }
    /**
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * @return y
     */
    public double getY() {
        return this.y;
    }
    /**
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

}