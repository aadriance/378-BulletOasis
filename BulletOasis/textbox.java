import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class textbox extends Actor
{
    public textbox(String text, int size, boolean whiteText){
        GreenfootImage img;
        if(whiteText){
            img = new GreenfootImage(text, size, Color.white, null);
        }else{
            img = new GreenfootImage(text, size, null, null);
        }
        this.setImage(img);
    }
}
