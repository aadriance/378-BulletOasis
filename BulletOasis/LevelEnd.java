import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelEnd extends ScrollingActor
{
    /**
     * Act - do whatever the LevelEnd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getOneIntersectingObject(PhysWalker.class) != null) {
            System.out.println("sign touched");
            GameWorld.nextWorld();
        }
    }    
}
