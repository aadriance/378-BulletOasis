import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Collidable
{
    double speed = 10;
    double dx;
    double dy;
    public Bullet(double deltaX, double deltaY) {
        setCanCollide(false);
        dx = deltaX * speed;
        dy = deltaY * speed;
        System.out.println(dx);
        System.out.println(dy);
        double angle = Math.atan2(dy,dx)*180.0/Math.PI;
        setRotation( (int)angle );
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + (int)dx, getY() + (int)dy);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }    
}
