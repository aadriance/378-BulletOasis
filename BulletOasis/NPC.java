import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NPC extends PhysShooter
{
    int frame = 0;
    
    public NPC() {
        super();
        canCollide = false;
    }
    
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frame += 1;
        List<Player> players = getObjectsInRange(getWorld().getHeight(), Player.class);
        super.act();
        
        if(players != null && players.size() > 0 && frame%35 == 0 && Greenfoot.getRandomNumber(100) > 60) {
            shoot(players.get(0).getX(), players.get(0).getY());
        }
    }    
}
