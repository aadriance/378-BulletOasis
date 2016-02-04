import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysObj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysObj extends Collidable
{
    int dx = 0;
    float vi = 0;
    int a = 9;
    float t = 0;
    
    public Float getYDis() {
          return vi*t + (a * t * t)/2;
    }
    public Float getVf() {
         return vi + a*t;  
    }
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        t += 0.05;
        
        if (moveCollidable(getX(), getY() + getVf().intValue()) == false) {
            t = 0;
            vi = 0f;
        }
        moveCollidable(getX() + getDX(), getY());
        
    }
    
    public int getDX() {
        return dx;
    }
    public void setDx(int newVal) {
        dx = newVal;
    }
    public void setVi(int newVal) {
        vi = newVal;
        t = 0;
    }
    public float getVi() {
        return vi;
    }
    public boolean getOnGround() {
        Collidable obj = (Collidable)getOneObjectAtOffset(0, getImage().getHeight(), Collidable.class);
        return obj != null && obj.getCanCollide();
    }
}
