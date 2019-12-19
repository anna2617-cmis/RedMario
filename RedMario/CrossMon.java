import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrossMon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrossMon extends Enemy
{
    /**
     * Act - do whatever the CrossMon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void moveLeft(){
        setLocation(getX() - 5, getY()); 

    } 

    public void act() 
    {
        moveLeft(); 
        if(getX() < 10)
            getWorld().removeObject(this);   
    }    
}
