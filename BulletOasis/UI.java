import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class UI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UI extends Actor
{
    int barSize = 10;
    int padding = 20;
    int wordOffset = 75;
    Player player;
    
    public UI(Player newPlayer) {
        player = newPlayer;
        setImage(new GreenfootImage(300, 100));

    }
    
    /**
     * Act - do whatever the UI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       imageUpdate(); 
    }  
    
    public void imageUpdate() {
        getImage().clear();
        getImage().setColor(Color.black);
        getImage().drawString("Health:", padding, padding);
        getImage().drawString("Buccaneer:", padding, padding * 2);
        //health bar
        getImage().setColor(Color.red);
        getImage().fillRect(padding + wordOffset, padding/2, player.life * barSize, padding /2);
        //bucc bar
        getImage().setColor(Color.blue);
        getImage().fillRect(padding + wordOffset, padding + padding/2, player.buccaneer * barSize, padding /2);
    }
}
