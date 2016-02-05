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
    GreenfootSound shot = new GreenfootSound("bullet.wav");
    /**
     * Act - do whatever the PhysShooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        if (bullet != null && bullet.owner.getClass() != this.getClass() &&
           (!((GameWorld)getWorld()).timeFrozen || bullet.owner.getClass() == Player.class) ) {
           getWorld().removeObject(bullet);
           hit();
        }
    }
    
    public void shoot(MouseInfo mouse) {
        shoot(mouse.getX(), mouse.getY());
    }
    
    public void shoot(double x, double y) {
        shoot(x, y, new Bullet());
    }
    
    public void shoot(double x, double y, Bullet bull) {
        shot.setVolume(80);
        shot.play();
        double dx = x - getX();
        double dy = y - getY();
        double unitScale = Math.sqrt(dx * dx + dy * dy);
        dx /= unitScale;
        dy /= unitScale;
        bull.setDxDy(dx, dy);
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
