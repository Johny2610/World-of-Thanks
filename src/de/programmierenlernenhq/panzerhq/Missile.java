package de.programmierenlernenhq.panzerhq;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author ProgrammierenLernenHQ
 */
public class Missile extends GameObject {    
   
    private int range = 100;
    /**
     * @param position
     * @param size
     * @param movingAngle
     * @param movingDistance
     */
    public Missile (Coordinate position, double size, double movingAngle, double movingDistance) {
        super(position, movingAngle, movingDistance);
        
        setMovingAngle(movingAngle);
        setMovingDistance(movingDistance);
    }
    /**
     * @return range
     */
    public int getRange() {
        return this.range;
    }
    /**
     * @param range
     */
    public void setRange(int range) {
        this.range = range;
    }
    @Override
    public void makeMove() {
        if (range > 0) super.makeMove();
        range--;
    }
    
    @Override
    public void paintMe(java.awt.Graphics g) { 
               
        Graphics2D g2d = (Graphics2D) g;   
        g2d.setColor(Color.BLACK);        
        
        AffineTransform transform = new AffineTransform();        
        RoundRectangle2D missileShape = new RoundRectangle2D.Double(getObjectPosition().getX(), 
                                                                    getObjectPosition().getY(), 
                                                                    getWidth()*0.1, getHeight()*0.1, 3, 3); 
        
        transform.rotate(getMovingAngle(),missileShape.getCenterX(), missileShape.getCenterY());
        Shape transformedMissileShape = transform.createTransformedShape(missileShape);
        
        g2d.fill(transformedMissileShape);
        
    }
    
}