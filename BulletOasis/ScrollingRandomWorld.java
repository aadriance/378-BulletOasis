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
        prepare(true);
    }
    
    public ScrollingRandomWorld(boolean magic)
    {
        prepare(magic);
    }
    
    public void act() {
        super.act();
        if(bg.isPlaying() == false) {
            bg = new GreenfootSound("Neo_Western_level.mp3");
            bg.playLoop();
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    private void prepare(boolean hasMagic)
    {
        setPaintOrder(Player.class, PhysWalker.class, Block.class);
        
        Player physwalker = new Player();
        physwalker.hasMagic = hasMagic;
        addObject(physwalker,282,194);
        physwalker.setLocation(283,188);

        setScrollee(physwalker);
       
        Block temp;
        for(int i = 0; i <= getScrollSize() + getWidth(); i += temp.getImage().getWidth()) {
            temp = new Block("sand-1.png");
            addObject(temp, i, getHeight() - temp.getImage().getHeight()/2);
            if (Greenfoot.getRandomNumber(100) > 90) {
                Scenery scenery = new Scenery();
                addObject(scenery, i, getHeight() - temp.getImage().getHeight() - scenery.getImage().getHeight()/2);
            }
            
            if (Greenfoot.getRandomNumber(100) > 95) {
                NPC enemy = new NPC();
                addObject(enemy, i, getHeight() - temp.getImage().getHeight()/2 - enemy.getImage().getHeight());
            }
            
            if (Greenfoot.getRandomNumber(100) > 85) {
                spawnPlatform(i, getHeight()/2 + 60);
            }
            
        }
        LevelEnd checkPoint = new LevelEnd();
        addObject(checkPoint, getScrollSize() + getWidth() - checkPoint.getImage().getWidth(), getHeight() -  checkPoint.getImage().getHeight());
    }
    
    private void spawnPlatform(int startX, int startY) {
        int offset = 0;
        for(int i = 0; i < 4; i++) {
            Block plat = new Block("sand-2.png");
            addObject(plat, startX + offset, startY);
            
            if (Greenfoot.getRandomNumber(100) > 75) {
                NPC enemy = new NPC();
                addObject(enemy, startX + offset, startY - plat.getImage().getHeight()/2 - enemy.getImage().getHeight());
            }
            
            offset += plat.getImage().getWidth();
        }
    }
}
