import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class narration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Narration extends Actor
{
    public Narration(String path){
        GreenfootImage img = new GreenfootImage(path);
        setImage(img);
    }
    
    public void changePath(String path){
        GreenfootImage img = new GreenfootImage(path);
        setImage(img);
    }
}
