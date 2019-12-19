import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage3 extends World
{
    private Cirno cirno;
    private boolean summon = true; 
    private boolean lastB = true; 
    public Stage3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1240, 768, 1);
        cirno = new Cirno(); 
        prepare(); 
    }

    public void prepare(){
        addObject(new RecF(), 57, 649);
        addObject(new RecF(), 57, 589);
        addObject(new Ground(), 54, 725);
        addObject(new Enemy(), 667, 100);
        addObject(new FallF(), 217, 174);
        addObject(new FallF(), 332, 174);
        addObject(new FallF(), 446, 174);
        addObject(new RecF(), 561, 174);
        addObject(new RecF(), 676, 174);
        addObject(new Elevator(), 777, 725);
        addObject(cirno, 80, 480);
    }

    public void act(){
        if (cirno.getX() > 600 && summon){
            addObject(new FlyMon(), 676, 760);
            summon = false; 
        } 
        if(cirno.getX() > 600 && Math.random() < 0.8 && lastB){
            addObject(new CrossMon(),  1239, 500);
            lastB = false; 
        }
        if (cirno.getX() > 1200){
            Greenfoot.setWorld(new Win()); 
        }
    }

    public Cirno getCirno(){
        return cirno; 
    }
}
