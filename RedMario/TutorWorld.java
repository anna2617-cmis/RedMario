import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorWorld extends World
{
    private Cirno cirno;     
    public TutorWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1240, 768, 1); 
        cirno = new Cirno(); 
        prepare(); 
    }

    public void act(){
        if (cirno.getX() > 1200){
            Greenfoot.setWorld(new Stage1()); 
        }
    }

    public void prepare(){
        addObject(new Tutor(), 300, 230); 
        addObject(new endTutor(), 900, 370); 
        addObject(new Ground(), 620, 725); 
        addObject(new Enemy(), 1150, 640); 
        addObject(new RecF(), 620, 480); 
        addObject(cirno, 80, 600);
    } 

    public Cirno getCirno(){
        return cirno; 
    }
    
    
}
