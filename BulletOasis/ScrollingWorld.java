import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingWorld extends GameWorld
{
    Actor scrollee;
    static int scrollTollerance = 30;
    int scrollSize;
    int displacement = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ScrollingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        scrollSize = getWidth() * 2;
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
    
    public void act() {
        if(scrollee != null) {
            int diff = scrollee.getX() - getWidth()/2;
            int newLoc;
            if(diff > scrollTollerance || diff < -1 * scrollTollerance) {
                if (diff > scrollTollerance) {
                    diff -= scrollTollerance + 1;
                    newLoc = getWidth()/2 + scrollTollerance;
                }
                else {
                    diff += scrollTollerance + 1;
                    newLoc = getWidth()/2 - scrollTollerance;
                }
                if((diff < 0 && getDisplacement() >= 0) || 
                   (diff > 0 && getDisplacement() <= getScrollSize())) {
                   List<ScrollingActor> scrollers = getObjects(ScrollingActor.class);
                   setDisplacement(getDisplacement() + diff);
                   for(int i = 0; i < scrollers.size(); i++) {
                      if(scrollers.get(i).getScrolls() == true) {
                          scrollers.get(i).setLocation(scrollers.get(i).getX() - diff,
                          scrollers.get(i).getY());
                       }
                   }
                }
            }
        }
    }
    
    public Actor getScrollee(){
        return scrollee;
    }
    public void setScrollee(Actor a) {
        scrollee = a;
    }
    
    public int getDisplacement() {
        return displacement;
    }
    public void setDisplacement(int newVal) {
        displacement = newVal;
    }
    public int getScrollSize() {
        return scrollSize;
    }
}
