import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sunBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sunBullet extends Bullet
{
    double maxspeed;
    double accel;
    
    /**
     * Act - do whatever the sunBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public sunBullet(double spd, double maxspd, double accel, int angle, GreenfootImage sprite, Actor owner){
        speed = spd;
        maxspeed = maxspd;
        this.accel = accel;
        setRotation(angle);
        this.angle = angle;
        this.owner = owner;
        setImage(sprite);
    }
    
    public void act() 
    {
        if(((GameWorld)getWorld()).timeFrozen && owner.getClass() != Player.class) {
            return;
        }
        
        move((int)speed);
        if(speed < maxspeed){
            speed += accel;
        }
        
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }    
}
