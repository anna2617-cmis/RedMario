import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class P1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1 extends World
{
    private Cirno cirno; 
    private Block block; 
    public Stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1240, 768, 1); 
        cirno = new Cirno(); 
        block = new Block(); 
        prepare(); 
    }

    public void prepare(){

        addObject(new Ground(), 210, 725); 
        addObject(new GroundBlock(), 1138, 725); 
        addObject(new MoveBlock(), 933, 725); 
        addObject(new Enemy(), 635, 430); 
        addObject(new RecF(), 772, 649); 
        addObject(block, 890, 220); 
        RecF recf2 = new RecF();
        addObject(recf2,664,656);
        recf2.setLocation(658,649);
        RecF recf3 = new RecF();
        addObject(recf3,665,596);
        recf3.setLocation(658,590);
        RecF recf4 = new RecF();
        addObject(recf4,784,593);
        recf4.setLocation(772,590);
        RecF recf5 = new RecF();
        addObject(recf5,779,535);
        recf5.setLocation(772,530);
        RecF recf6 = new RecF();
        addObject(recf6,782,479);
        recf6.setLocation(772,470);
        addObject(new ChanceS1(), 85, 340); 
        addObject(cirno, 80, 600); 
    } 

    public void act(){
        if (cirno.getX() > 1200){
            Greenfoot.setWorld(new Stage2()); 
        }
    }

    public Cirno getCirno(){
        return cirno; 
    }

}
