import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elevator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elevator extends GroundBlock
{
    private boolean isLeft; 
    public Elevator (){
        if(Math.random() < 0.5)
            isLeft = true;
        else 
            isLeft = false; 
    }

    public void moveLeft(){
        setLocation(getX() - 2, getY()); 

    } 

    public void moveRight(){
        setLocation(getX() + 2, getY()); 

    }

    public boolean atEdge(){
        if(getX() < 10 || getX() > getWorld().getWidth()-10){
            return true; 
        }
        if(getY() < 10 || getY() > getWorld().getHeight()-10){
            return true; 
        }else{
            return false; 
        }
    }

    public void changeDirection(){
        if (isTouching(Floor.class) || atEdge())
            isLeft = !isLeft; 
    }

    public void act() 
    {
        changeDirection();
        if (isLeft){
            moveLeft(); 
        }else{
            moveRight(); 
        }
    }    
}
