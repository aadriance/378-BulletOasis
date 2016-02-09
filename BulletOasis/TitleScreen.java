import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends GameWorld
{
    public TitleScreen() {
        super(600, 400, 1, true);
        prepare();
    }
    
    public void act() {
        super.act();
        if(bg == null || bg.isPlaying() == false) {
            bg = new GreenfootSound("Drankin_Song_titleScreen.mp3");
            bg.playLoop();
        }
        if(Greenfoot.mouseClicked(null)){
            Greenfoot.setWorld(new Intro());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        /*PlayGame button = new PlayGame();
        addObject(button,241,178);
        button.setLocation(295,204);*/
        Textbox title = new Textbox("MAGIC COWBOY: BULLET OASIS", 40, false);
        addObject(title,300,100);
        
        Textbox t = new Textbox("Click to start", 20, false);
        addObject(t,300,201);
        
        Textbox t2 = new Textbox("Andrew Adriance, Gideon Wong", 15, false);
        addObject(t2,300,350);
    }
}
