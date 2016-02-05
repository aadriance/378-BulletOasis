import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Collidable
{
    double speed = 8;
    double dx;
    double dy;
    double angle;
    Actor owner;
    public Bullet() {
        setCanCollide(false);
    }
    
    public Bullet(double deltaX, double deltaY){
        setCanCollide(false);
        setDxDy(deltaX, deltaY);
    }
    
    public void setDxDy(double deltaX, double deltaY) {
        dx = deltaX * speed;
        dy = deltaY * speed;
        angle = Math.atan2(dy,dx)*180.0/Math.PI;
        setRotation( (int)angle );
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(((GameWorld)getWorld()).timeFrozen && owner.getClass() != Player.class) {
            return;
        }
        
        move();
    }  
    
    public void move() {
        setLocation(getX() + (int)dx, getY() + (int)dy);
        
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
