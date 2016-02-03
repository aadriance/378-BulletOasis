import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends GameWorld
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {
        Actor button = new TryAgain();
        addObject(button, getWidth()/2, getHeight()/2);
    }
}
