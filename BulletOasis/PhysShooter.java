import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysShooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysShooter extends PhysWalker
{
    int life = 3;
    /**
     * Act - do whatever the PhysShooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        if (bullet != null && bullet.owner != this) {
           getWorld().removeObject(bullet);
           hit();
        }
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
        bull.owner = this;
        
        int offset = getImage().getWidth()/2;
        
        if (x < getX()) {
            offset *= -1;
        }
        
        getWorld().addObject(bull,getX() + offset,getY());
    }
    
    public void hit() {
        life -= 1;
        if(life == 0) {
            die();
        }
    }
    
    public void die() {
        getWorld().removeObject(this);
    }
}
