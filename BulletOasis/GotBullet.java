import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GotBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GotBullet extends ExpositionWorld
{
    String[] ns = {
        "images/2-1.png",
        "images/2-2.png", 
        "images/2-3.png",
        "images/2-4.png", 
        "images/2-5.png",
        "images/3-1.png",
        "images/3-2.png"
    };
    Narration n;
    int i = 0;
    
    public GotBullet()
    {
        super();
        n = new Narration("images/2-1.png");
        addObject(n, 300, 200);
        currWorld = 0;
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(null)){
            i++;
            if(i < ns.length){
                n.changePath( ns[i] );
                if(i == 5){
                    setBackground("images/cut4.png");
                }
                if(i == 6){
                    setBackground("images/cut3.png");
                }
            }else{
                GameWorld.nextWorld();
                //Greenfoot.setWorld(new Intro2());
            }
        }
    }
}
