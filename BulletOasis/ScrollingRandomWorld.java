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
            bg.setVolume(85);
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
        
        if(hasMagic){
            ScrollText st = new ScrollText("Press SHIFT to stop time and become invulnerable.");
            addObject(st, 400, 100);
            ScrollText st2 = new ScrollText("Expends all accumulated Buccaneer.");
            addObject(st2, 400, 15000);
        }else{
            ScrollText st = new ScrollText("WASD. Aim and shoot with mouse");
            addObject(st, 400, 100);
            ScrollText st2 = new ScrollText("R to reload (Automatic reload after using all 6 shots)");
            addObject(st2, 400, 150);
        }
        
        Player physwalker = new Player();
        physwalker.hasMagic = hasMagic;
        addObject(physwalker,282,194);
        physwalker.setLocation(283,188);

        setScrollee(physwalker);
        double randWeight = 0;
        Block temp;
        boolean justSpawned = false;
        for(int i = 0; i <= getScrollSize() + getWidth(); i += temp.getImage().getWidth()) {
            temp = new Block("sand-1.png");
            addObject(temp, i, getHeight() - temp.getImage().getHeight()/2);
            if (Greenfoot.getRandomNumber(100) > 75) {
                Scenery scenery = new Scenery();
                addObject(scenery, i, getHeight() - temp.getImage().getHeight() - scenery.getImage().getHeight()/2);
            }
            
            if (Greenfoot.getRandomNumber(98) + randWeight > 94 && !justSpawned) {
                randWeight = 0;
                NPC enemy = new NPC();
                addObject(enemy, i, getHeight() - temp.getImage().getHeight()/2 - enemy.getImage().getHeight());
                justSpawned = true;
            }else {
                randWeight += 0.1;
                justSpawned = false;
            }
            
            if (Greenfoot.getRandomNumber(96) + randWeight > 94) {
                spawnPlatform(i, getHeight()/2 + 75);
                randWeight = 0;
            }
            else {
                randWeight += 1;
            }
            
        }
        LevelEnd checkPoint = new LevelEnd();
        addObject(checkPoint, getScrollSize() + getWidth() - checkPoint.getImage().getWidth(), getHeight() -  checkPoint.getImage().getHeight());
    }
    
    private void spawnPlatform(int startX, int startY) {
        int offset = 0;
        boolean justSpawned = false;
        for(int i = 0; i < 4; i++) {
            Block plat = new Block("sand-2.png");
            addObject(plat, startX + offset, startY);
            
            if (Greenfoot.getRandomNumber(100) > 83 && !justSpawned) {
                NPC enemy = new NPC();
                justSpawned = true;
                addObject(enemy, startX + offset, startY - plat.getImage().getHeight()/2 - enemy.getImage().getHeight());
            }else{
                justSpawned = false;
            }
            
            offset += plat.getImage().getWidth();
        }
    }
}
