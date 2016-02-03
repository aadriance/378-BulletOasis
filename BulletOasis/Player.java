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
    String shoot = "player-shoot.png";
    String jump = "player-jump.png";
    String shootJump = "player-jump-shoot.png";
    int step = 0;
    int dir = 1;
    int frame = 0;
    boolean flipped = false;
    
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
        
        if (frame % 10 == 0) { 
           flipped = false;
           if ( Greenfoot.isKeyDown("a") ||  Greenfoot.isKeyDown("d"))
           {
               step = (step + 1) % walkCycle.length;
           }
           else {
               step = 0;
           }
           
           subActor.setImage(walkCycle[step]);
           
        }
        
        subActor.setLocation(getX(), getY());
        
        if ( Greenfoot.isKeyDown("a") )
           {
               moveLeft();
           }
           else if ( Greenfoot.isKeyDown("d") )
           {
               moveRight();
           }
        
        if ( Greenfoot.isKeyDown("w") ) {
            flipped = false;
            frame = 0;
            jump();
            subActor.setImage(jump);
           }
        
        if(dir == 1 && Greenfoot.getMouseInfo().getX() < getX()) {
            dir *= -1;
        }
        
        if(Greenfoot.getMouseInfo() != null && dir == -1 && Greenfoot.getMouseInfo().getX() > getX()) {
            dir *= -1;
        }
        
        if(Greenfoot.mousePressed(null)) {
            frame = 0;
            flipped = false;
            shoot(Greenfoot.getMouseInfo());
            if(getOnGround()) {
               subActor.setImage(shoot); 
            }
            else {
                subActor.setImage(shootJump);
            }
        }
        
        if (dir == -1 && !flipped) {
               flipped = true;
               subActor.getImage().mirrorHorizontally();
        }
    } 
    
    public Player() {
        super();
        getImage().setTransparency(1);
    }
    
    public void die() {}
}
