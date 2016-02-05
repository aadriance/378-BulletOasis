import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossLevel extends GameWorld
{

    /**
     * Constructor for objects of class BossLevel.
     * 
     */
    public BossLevel()
    {
        Block temp = new Block("sand-1.png");
        for(int i = 0; i <= getWidth(); i += temp.getImage().getWidth()) {
            temp = new Block("sand-1.png");
            addObject(temp, i, getHeight() - temp.getImage().getHeight()/2);
        }
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Honcho honcho = new Honcho();
        addObject(honcho,294,141);
        Player player = new Player();
        addObject(player,287,360);
    }
    
    public void act() {
        super.act();
        if(bg == null || bg.isPlaying() == false) {
            bg = new GreenfootSound("Robo-Western_boss.mp3");
            bg.playLoop();
        }
    }
}
