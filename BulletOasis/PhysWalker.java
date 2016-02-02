import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysWalker extends PhysObj
{
    /**
     * Act - do whatever the PhysWalker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    } 
    
    public void moveLeft() {
        moveCollidable(getX() - 5, getY()); 
    }
    public void moveRight() {
        moveCollidable(getX() + 5, getY());
    }
    public void jump() {
        if (getOnGround()) {
               setVi(-7);
            } 
    }
}
