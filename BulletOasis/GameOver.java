import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends GameWorld
{
    
    public void act() {
        super.act();
        if(bg.isPlaying()){
            bg.stop();
        }
        if(Greenfoot.mouseClicked(null)){
            GameWorld.restart();
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
