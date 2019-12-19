import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoveBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoveBlock extends Floor
{
    private final int GRAVITY = 1; 
    private int velocity = 0; 

    public void fall(){
        setLocation(getX(),getY()+velocity);
        velocity += GRAVITY; 
    }
    
    public boolean touches(){
        Cirno cirno = ((Stage1)getWorld()).getCirno(); 
        if (cirno.getX() >= this.getX() - 95 ){
            return true; 
        }else{
            return false; 
        }
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
