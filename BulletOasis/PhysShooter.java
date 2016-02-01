import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysShooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysShooter extends PhysWalker
{
    /**
     * Act - do whatever the PhysShooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(Greenfoot.mousePressed(null)) {
            shoot(Greenfoot.getMouseInfo());
        }
    }
    
    public void shoot(MouseInfo mouse) {
        double dx = mouse.getX() - getX();
        double dy = mouse.getY() - getY();
        double unitScale = Math.sqrt(dx * dx + dy * dy);
        dx /= unitScale;
        dy /= unitScale;
        Bullet bull = new Bullet(dx, dy);
        
        int offset = getImage().getWidth()/2;
        
        if (mouse.getX() < getX()) {
            offset *= -1;
        }
        
        getWorld().addObject(bull,getX() + offset,getY());
    }
}
