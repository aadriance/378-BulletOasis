import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollingRandomWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollingRandomWorld extends ScrollingWorld
{

    /**
     * Constructor for objects of class ScrollingRandomWorld.
     * 
     */
    public ScrollingRandomWorld()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        setPaintOrder(PhysWalker.class);
        
        Player physwalker = new Player();
        addObject(physwalker,282,194);
        physwalker.setLocation(283,188);

        setScrollee(physwalker);
        
        Block temp;
        for(int i = 0; i <= getScrollSize() + getWidth(); i += temp.getImage().getWidth()) {
            temp = new Block("sand-1.png");
            addObject(temp, i, getHeight() - temp.getImage().getHeight()/2);
            if (Greenfoot.getRandomNumber(100) > 90) {
                Scenery scenery = new Scenery();
                addObject(scenery, i, getHeight() - temp.getImage().getHeight()/2 - scenery.getImage().getHeight());
            }
        }
        LevelEnd checkPoint = new LevelEnd();
        addObject(checkPoint, getScrollSize() + getWidth() - checkPoint.getImage().getHeight()/2, getHeight() -  checkPoint.getImage().getHeight());
    }
}
