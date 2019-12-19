import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlyMon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlyMon extends Enemy
{
    private final int GRAVITY = 1; 
    private int velocity = -30; 
    private boolean isTouch = false; 
    public void fall(){
        setLocation(getX(),getY()+velocity);
        velocity += GRAVITY; 
    }
    
    public boolean touches(){
        Cirno cirno = ((Stage3)getWorld()).getCirno(); 
        if (cirno.getX() >= this.getX() - 95 ){
            isTouch = true; 
        }
        return isTouch; 
    }
   
    public void remove(){
        if(touches()){
            fall(); 
        }
    }

    public void act() 
    {
        remove(); 
        if (getY() == 5 || getY() == 767){
            getWorld().removeObject(this); 
        }

    }         
}
