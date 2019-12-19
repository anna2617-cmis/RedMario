import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Win extends World
{
    private Cirno cirno; 
    public Win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1240, 768, 1); 
        setBackground("end.png"); 
        cirno = new Cirno();
        prepare(); 
    }

    public void prepare(){
        addObject(new Icon(), 620, 380); 
        WinTxt winTxt = new WinTxt();
        addObject(winTxt,629,511);
    }

    public Cirno getCirno(){
        return cirno; 
    }
}
