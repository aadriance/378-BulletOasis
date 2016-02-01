import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Walker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Walker extends Collidable
{
    /**
     * Act - do whatever the Walker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ( Greenfoot.isKeyDown("left") )
        {
            moveCollidable(getX() - 4, getY());
        }
        else if ( Greenfoot.isKeyDown("right") )
        {
            moveCollidable(getX() + 4, getY());
        }
        else if ( Greenfoot.isKeyDown("up") )
        {
            moveCollidable(getX(), getY() - 4);
        }
        else if ( Greenfoot.isKeyDown("down") )
        {
            moveCollidable(getX(), getY() + 4);
        }
    } 

}
