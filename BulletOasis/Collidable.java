import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Collidable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Collidable extends ScrollingActor
{
    boolean canCollide = true;
    
    public boolean getCanCollide() {
       return canCollide;  
    }
    
    public boolean moveCollidable(int x, int y){
        int oldX = getX();
        int oldY = getY();
        setLocation(x,y);
        List<Collidable> colliders = getIntersectingObjects(Collidable.class);
        if (colliders != null) {
           for (int i = 0; i < colliders.size(); i++) {
		      if (colliders.get(i).getCanCollide()) {
		          setLocation(oldX,oldY);
		          return false;
		      }
		   }    
        }
        return true;
    }
    
    public void setCanCollide(boolean newVal) {
        canCollide = newVal;
    }
}
