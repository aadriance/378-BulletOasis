import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FoundBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FoundBoss extends ExpositionWorld
{
    String[] ns = {
        "images/4-1.png",
        "images/4-2.png", 
        "images/4-3.png"
    };
    Narration n;
    int i = 0;
    
    public FoundBoss()
    {
        super();
        n = new Narration("images/4-1.png");
        addObject(n, 300, 200);
        currWorld = 0;
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(null)){
            i++;
            if(i < ns.length){
                n.changePath( ns[i] );
            }else{
                GameWorld.nextWorld();
                //Greenfoot.setWorld(new Intro2());
            }
        }
    }
}
