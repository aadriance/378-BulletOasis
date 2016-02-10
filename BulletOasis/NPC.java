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
    boolean dead = false;
    
    public NPC() {
        super();
        canCollide = true;
        life = 2;
    }
    
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(((GameWorld)getWorld()).timeFrozen) {
            return;
        }
        
        if(getX() > 0 && getX() < getWorld().getWidth()) {
           frame += 1;
           List<Player> players = getObjectsInRange(getWorld().getHeight(), Player.class);
           super.act();
           
           if(frame%15 == 0 && players != null && players.size() > 0 && !dead) {
              setImage("enem1.png");
              if(players.get(0).getX() < getX()) {
                 getImage().mirrorHorizontally();
              }      
           }
        
        
           if(players != null && players.size() > 0 && frame%28 == 0 &&
           Greenfoot.getRandomNumber(100) > 55 && !dead) {
               shoot(players.get(0).getX(), players.get(0).getY());
           }
           
           if(dead && frame == 100) {
               getWorld().removeObject(this);
           }
       }
    }
    
    public void die() {
        frame = 0;
        setImage("enem1-dead.png");
        dead = true;
        List<Player> players = getObjectsInRange(getWorld().getHeight(), Player.class);
        if(players != null && players.size() > 0) {
              if(players.get(0).getX() < getX()) {
                 getImage().mirrorHorizontally();
              }      
           }
    }
    
    public void hit() {
        super.hit();
        GreenfootSound sound = new GreenfootSound("enHit.wav");
                  sound.play(); 
    }
}
