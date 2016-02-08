import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    
    boolean timeFrozen = false;
    
    static GameWorld[] worlds = {
        new Intro(),
        new ScrollingRandomWorld(false),
        new GotBullet(),
        new ScrollingRandomWorld(true),
        new FoundBoss(),
        new BossLevel(),
        new Ending()
    };
    static int currWorld = 0;
    static GreenfootSound bg;
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
        bg.stop();
        if (currWorld < worlds.length) {
            currWorld ++;
            Greenfoot.setWorld(worlds[currWorld]);
        }
    }
    
    public static void restart() {
        bg.stop();
        GameWorld[] newWorlds = {
             new Intro(), 
             new ScrollingRandomWorld(false),
             new GotBullet(),
             new ScrollingRandomWorld(true), 
             new FoundBoss(), 
             new BossLevel(),
             new Ending()
        };
        worlds = newWorlds;
        /*if (currWorld < worlds.length - 1) {
            Greenfoot.setWorld(worlds[0]);
        
        }*/
        Greenfoot.setWorld(worlds[0]);
    }
}
