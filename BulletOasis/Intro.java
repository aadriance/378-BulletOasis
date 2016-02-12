import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends ExpositionWorld
{
    String[] ns = {
        "images/1-1.png",
        "images/1-2.png", 
        "images/1-3.png",
        "images/1-4.png", 
        "images/1-5.png"
    };
    Narration n;
    int i = 0;

    /**
     * Constructor for objects of class Intro.
     * 
     */
    public Intro()
    {
        super();
        n = new Narration("images/1-1.png");
        addObject(n, 300, 200);
        currWorld = 0;
    }
    
    public void act(){
        super.act();
        if(Greenfoot.mouseClicked(null)){
            i++;
            if(i < ns.length){
                n.changePath( ns[i] );
                if(i == 1){
                    setBackground("images/cut2.png");
                }
                if(i == 4){
                    setBackground("images/cut1.png");
                }
            }else{
                GameWorld.nextWorld();
                //Greenfoot.setWorld(new Intro2());
            }
        }
    }
}
