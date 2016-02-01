import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    static GameWorld[] worlds = {new TitleScreen(), new Intro(), new ScrollingRandomWorld(),
    new GotBullet(), new ScrollingRandomWorld(), new FoundBoss(), new ScrollingRandomWorld(),
    new Ending()};
    static int currWorld = 0;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {  
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //Greenfoot.setWorld(new TitleScreen());
    }
    
    public GameWorld(int w, int h, int tile, boolean bool)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(w, h, tile, bool); 
    }
    
    public static void nextWorld() {
        if (currWorld < worlds.length - 1) {
            currWorld += 1;
            Greenfoot.setWorld(worlds[currWorld]);
        
        }
    }
}
