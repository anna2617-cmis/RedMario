import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Floor
{
    public void act(){
        if (isTouching(Cirno.class)){
            getWorld().addObject(new RecF(), getX(), getY()); 
            getWorld().removeObject(this); 
        }
    }
}
