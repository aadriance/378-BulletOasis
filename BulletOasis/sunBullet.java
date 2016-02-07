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
    int ttl;
    int count;
    GreenfootImage sprite1, sprite2;
    
    /**
     * Act - do whatever the sunBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public sunBullet(double spd, double maxspd, double accel, int angle, GreenfootImage spr1, GreenfootImage spr2, Actor owner){
        speed = spd;
        maxspeed = maxspd;
        this.accel = accel;
        setRotation(angle);
        this.angle = angle;
        this.owner = owner;
        
        sprite1 = spr1;
        sprite2 = spr2;
        setImage(spr1);
    }
    
    public void act() 
    {
        if(((GameWorld)getWorld()).timeFrozen && owner.getClass() != Player.class)
            return;
        
        move((int)speed);
        
        if(speed < maxspeed)
            speed += accel;
        
        if (isAtEdge())
            getWorld().removeObject(this);
            
        flash();
    }
    
    public void flash(){
        count++;
        if(count == 2){
            setImage(sprite2);
        }
        if(count == 4){
            setImage(sprite1);
            count = 0;
        }
    }
}
