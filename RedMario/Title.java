import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends TextImg
{
    private int frame = 1; 
    private int animateCounter = 0; 
    public void animate(){
        if(frame == 1){
            getImage().scale(1200,650 ); 
        }else if (frame == 3){
            getImage().scale(1222,662); 
            frame = 1; 
            return; 
        }
        frame ++; 
    }

    public void act() 
    {
        if (animateCounter % 10 == 0){
            animate(); 
            animateCounter = 0; 
        }
        animateCounter++; 
    }    
}
