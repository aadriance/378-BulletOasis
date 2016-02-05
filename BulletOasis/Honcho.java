import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Honcho here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Honcho extends PhysShooter
{
    
    int dir = 1;
    boolean flipped = false;
    int frame = 0;
    
    /**
     * Act - do whatever the Honcho wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        frame += 1;
        int temp = getY();
        if(dir == 1 && flipped == true) {
            getImage().mirrorHorizontally();
            flipped = false;
        }
        else if(dir == -1 && flipped == false) {
            getImage().mirrorHorizontally();
            flipped = true;
        }
        
        List<Player> players = getObjectsInRange(getWorld().getHeight(), Player.class);
        if(players != null && players.size() > 0 && frame%40 == 0 &&
           Greenfoot.getRandomNumber(100) > 65 && frame % 20 == 0) {
               shoot(players.get(0).getX(), players.get(0).getY(), new Laser(0, 0));
        }
        
        if(frame % 2 == 1) {
            if (dir == 1) {
                moveRight();
            }
            else {
                moveLeft();
            }
        }

        if(getX() < 20) {
            dir = 1;
        }
        if(getX() > getWorld().getWidth() - 20) {
            dir = -1;
        }
        super.act();
        a = 0;
    }
    
    public void die() {
        GameWorld.nextWorld();
    }
    
}
