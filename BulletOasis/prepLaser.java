import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class prepLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class prepLaser extends ScrollingActor
{
    sun ownerSun;
    int frame, count = 0;
    Actor owner;
    
    public prepLaser(Actor own, sun ownSun){
        owner = own;
        ownerSun = ownSun;
        getImage().setTransparency(50);
    }
    
    public void act() 
    {
        setLocation(ownerSun.getX(), getY());
        frame++;
        flash();
        if(frame == 80){
            getWorld().addObject(new sunLaser(owner, ownerSun), getX(), getY());
            getWorld().removeObject(this);
        }
    }
    
    public void flash(){
        count++;
        if(count == 2){
            getImage().setTransparency(100);
        }
        if(count == 4){
            getImage().setTransparency(50);
            count = 0;
        }
    }
}
