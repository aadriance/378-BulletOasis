import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends PhysShooter
{
    Actor subActor;
    String[] walkCycle = {"player-stand.png", "player-walk2.png", "player-walk3.png"};
    int step = 0;
    int dir = 1;
    int frame = 0;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        frame += 1;
        
        if (subActor == null) {
            subActor = new SubImage();
            getWorld().addObject(subActor, getX(), getY());
        }
        super.act();
        
        if (frame % 3 == 0) { 
        
           if ( Greenfoot.isKeyDown("left") )
           {
               moveLeft();
               step = (step + 1) % walkCycle.length;
               if (dir == 1) {
                   dir *= -1;
               }
           }
           else if ( Greenfoot.isKeyDown("right") )
           {
               moveRight();
               step = (step + 1) % walkCycle.length;
               if (dir == -1) {
                   dir *= -1;
               }
           }
           else {
               step = 0;
           }
           
           if ( Greenfoot.isKeyDown("up") ) {
            jump();
           }
           
           subActor.setImage(walkCycle[step]);
           if (dir == -1) {
               subActor.getImage().mirrorHorizontally();
           }
           subActor.setLocation(getX(), getY());
        }
        
        if(Greenfoot.mousePressed(null)) {
            shoot(Greenfoot.getMouseInfo());
        }
    } 
    
    public Player() {
        super();
        getImage().setTransparency(1);
    }
}
