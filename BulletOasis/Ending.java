import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ending here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ending extends ExpositionWorld
{
    public Ending() {
        removeObjects(getObjects(null));
        Textbox boxy = new Textbox("THE END", 30, false);
        addObject(boxy, getWidth()/2, getHeight()/2);
    }
    
    public void prepare() {
    }
}
