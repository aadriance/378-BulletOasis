import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Bullet
{
    int currX = 0;
    int currY = 0;
    int frame = 0;
    ArrayList<Bullet> lasers = new ArrayList<>();
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frame += 1;
        if (frame % 7 == 0) {
            super.act();
        }
        if(frame > 200) {
            removeAll();
        }
        return;
    } 
    
    public Laser(double deltaX, double deltaY) {
        super(deltaX, deltaY);
    }
    
    public void move() {
        DumbyLaser las = new DumbyLaser(0, 0);
        las.setRotation( (int)angle );
        las.owner = this.owner;
        currX += (int)dx * 2;
        currY += (int)dy * 2;
        getWorld().addObject(las, getX() + currX, getY() + currY);
        lasers.add(las);
        if (isAtEdge()) {
            removeAll();
        }
    }
    
    public void removeAll() {
       for(int i = 0; i < lasers.size(); i++) {
                getWorld().removeObject(lasers.get(i));
            }
            getWorld().removeObject(this); 
    }
}
