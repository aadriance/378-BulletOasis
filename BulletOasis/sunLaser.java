import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sunLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sunLaser extends Bullet
{
    sun ownerSun;
    int frame, count = 0;
    GreenfootImage sprite2 = new GreenfootImage("images/laser2.png");
    GreenfootImage sprite1 = new GreenfootImage("images/laser1.png");
    
    public sunLaser(Actor own, sun ownSun){
        owner = own;
        ownerSun = ownSun;
    }
    
    public void act() 
    {
        setLocation(ownerSun.getX(), getY());
        flash();
        frame++;
        if(frame == 60){
            getWorld().removeObject(this);
        }
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
