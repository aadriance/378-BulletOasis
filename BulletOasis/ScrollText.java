import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollText extends ScrollingActor
{
    public ScrollText(String text){
        GreenfootImage img;
        img = new GreenfootImage(text, 20, null, null);
        this.setImage(img);
    }
}
