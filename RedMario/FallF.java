import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallF extends RecF
{
    private final int GRAVITY = 1; 
    private int velocity = 0; 
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
        if (getY() == 767){
            getWorld().removeObject(this); 
        }

    }       
}
