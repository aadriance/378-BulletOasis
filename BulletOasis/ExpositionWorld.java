import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExpositionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExpositionWorld extends GameWorld
{

    /**
     * Constructor for objects of class ExpositionWorld.
     * 
     */
    public ExpositionWorld()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlayGame playgame = new PlayGame();
        addObject(playgame,480,342);
    }
}
