package de.programmierenlernenhq.panzerhq;

/**
 *
 * @author ProgrammierenLernenHQ
 */
public abstract class GameObject {
    
    private Coordinate objectPosition;
    private double width;
    private double height;
    private double movingAngle;
    private double movingDistance;
    /**
     * @param objectPosition
     * @param width
     * @param height
     */
    public GameObject(Coordinate objectPosition, double width, double height) {
       this.width = width; 
       this.height = height; 
       this.objectPosition = objectPosition; 
       movingAngle = 0;
       movingDistance = 0;
        
        
    }
    /**
     * @return objectPosition
     */
    public Coordinate getObjectPosition() {
        return objectPosition;
    }
    /**
     * @param objectPosition
     */
    public void setObjectPosition(Coordinate objectPosition) {
       this.objectPosition = objectPosition; 
    }
    /**
     * @return (width+80)
     */
    public double getWidth() {
        return (width+80);
    }
    /**
     * @param width
     */
    public void setWidth(double width) {
       this.width = width;
    }
    /**
     * @return (height+60)
     */
    public double getHeight() {
        return (height+60);
    }
    /**
     * @param height
     */
    public void setHeight(double height) {
       this.height = height; 
    }
    /**
     * @return movingAngle
     */
    public double getMovingAngle() {
        return movingAngle;
    }
    /**
     * @param movingAngle
     */
    public void setMovingAngle(double movingAngle) {
       this.movingAngle = movingAngle;
    }
    /**
     * @return movingDistance
     */
    public double getMovingDistance() {
        return movingDistance;
    }
    /**
     * @param movingDistance
     */
    public void setMovingDistance(double movingDistance) {
        this.movingDistance = movingDistance;
    }
    /**
     * @param that
     * @return this.getObjectPosition().getX() + this.getWidth() < that.getObjectPosition().getX()
     */
    public boolean isLeftOf(GameObject that) {
        return this.getObjectPosition().getX() + this.getWidth() < that.getObjectPosition().getX();
    }
    /**
     * @param that
     * @return this.getObjectPosition().getY() + this.getHeight() < that.getObjectPosition().getY();
     */
    public boolean isAbove(GameObject that) {
        return this.getObjectPosition().getY() + this.getHeight() < that.getObjectPosition().getY();
    }
    /**
     * @param that
     * @return false/true
     */
    public boolean touches(GameObject that) {
        if(this.isLeftOf(that)) return false;
        if(that.isLeftOf(this)) return false;
        if(this.isAbove(that))  return false;
        if(that.isAbove(this))  return false;

        return true;
    }
    /**
     * @param angle
     * @return new Coordinate(x, y)
     */
    public static Coordinate polarToCartesianCoordinates(double angle) {
        
        // X-Achse zeigt nach Osten, Y-Achse zeigt nach SÃ¼den beim Zeichnen
        double x = Math.cos(angle);
        double y = Math.sin(angle);
        
        return new Coordinate(x, y); 
    }
    public void moveGameObject() {
        
        Coordinate direction = polarToCartesianCoordinates(movingAngle);
        
        objectPosition.setX(objectPosition.getX() + direction.getX() * movingDistance);
        objectPosition.setY(objectPosition.getY() + direction.getY() * movingDistance);        
    }
            
    public void makeMove() {
        moveGameObject();
    }
    /**
     * @param g
     */
    protected abstract void paintMe(java.awt.Graphics g);     

}