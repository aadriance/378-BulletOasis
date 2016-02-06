import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenery extends ScrollingActor
{
    String[] imageList = {"cactus.png", "shrub.png"};
    public Scenery() {
        setImage(imageList[Greenfoot.getRandomNumber(imageList.length)]);
    }
    /**
     * Act - do whatever the Scenery wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
