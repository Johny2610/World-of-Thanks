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

    public GameObject(Coordinate objectPosition, double width, double height) {
        
        
        
        
        
        
    }

    public Coordinate getObjectPosition() {
        
    }

    public void setObjectPosition(Coordinate objectPosition) {
        
    }

    public double getWidth() {
        
    }

    public void setWidth(double width) {
       
    }

    public double getHeight() {
        
    }

    public void setHeight(double height) {
        
    }

    public double getMovingAngle() {
        
    }

    public void setMovingAngle(double movingAngle) {
       
    }

    public double getMovingDistance() {
        
    }

    public void setMovingDistance(double movingDistance) {
        
    }
    
    public boolean isLeftOf(GameObject that) {
        return this.getObjectPosition().getX() + this.getWidth() < that.getObjectPosition().getX();
    }

    public boolean isAbove(GameObject that) {
        return this.getObjectPosition().getY() + this.getHeight() < that.getObjectPosition().getY();
    }

    public boolean touches(GameObject that) {
        if(this.isLeftOf(that)) return false;
        if(that.isLeftOf(this)) return false;
        if(this.isAbove(that))  return false;
        if(that.isAbove(this))  return false;

        return true;
    }
    
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
    
    protected abstract void paintMe(java.awt.Graphics g);     

}