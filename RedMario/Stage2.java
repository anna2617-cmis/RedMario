import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lv2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2 extends World
{
    private Cirno cirno; 
    private boolean blocked; 
    public Stage2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1240, 768, 1); 
        cirno = new Cirno(); 
        blocked = true; 
        prepare(); 
    }

    public void prepare(){
        Enemy ball = new Enemy(); 
        ball.changeDirection(true); 
        addObject(ball, 1005,264); 

        GroundBlock groundBlock = new GroundBlock();
        addObject(groundBlock,103,725);
        GroundBlock groundBlock2 = new GroundBlock();
        addObject(groundBlock2,308,725);
        GroundBlock groundBlock3 = new GroundBlock();
        addObject(groundBlock3,595,725);
        GroundBlock groundBlock4 = new GroundBlock();
        addObject(groundBlock4,800,725);
        GroundBlock groundBlock5 = new GroundBlock();
        addObject(groundBlock5,1230,725);
        GroundBlock groundBlock6 = new GroundBlock();
        addObject(groundBlock6,918,725);

        RecF flr = new RecF();
        flr.setImg(1);
        addObject(flr,353,649);
        addObject(new RecF(),238,649);
        addObject(new RecF(),238,589);
        addObject(new RecF(),353,589);
        addObject(new RecF(),353,529);
        addObject(new RecF(),353,469);

      
        addObject(new RecF(),664,649);
        addObject(new RecF(),664,589);

        for (int a = 0; a < 4; a++){
            addObject(new RecF(),549,649 - a*60);
        }
        
        addObject(new RecF(),1184,649);
        addObject(new RecF(),1184,589);
        
        addObject(new RecF(),740,291); 
        addObject(new RecF(),1000,349);
        addObject(cirno, 80, 600); 
    } 

    public Cirno getCirno(){
        return cirno; 
    }
    
    
    public void act(){
        if (cirno.getX() > 660 && cirno.getY() > 470 && blocked){
            addObject(new Block(),673,350);
            addObject(new Block(),787,350);
            addObject(new Block(),902,350);
            addObject(new Block(),1016,409);
            blocked = false; 
        }
        if (cirno.getX() > 1200){
            Greenfoot.setWorld(new Stage3()); 
        }
    }
}
