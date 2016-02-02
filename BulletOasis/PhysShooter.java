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
    }
    
    public void shoot(MouseInfo mouse) {
        shoot(mouse.getX(), mouse.getY());
    }
    
    public void shoot(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();
        double unitScale = Math.sqrt(dx * dx + dy * dy);
        dx /= unitScale;
        dy /= unitScale;
        Bullet bull = new Bullet(dx, dy);
        
        int offset = getImage().getWidth()/2;
        
        if (x < getX()) {
            offset *= -1;
        }
        
        getWorld().addObject(bull,getX() + offset,getY());
    }
}
