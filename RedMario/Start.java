import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Start extends TextImg
{
    private GreenfootImage s1 = new GreenfootImage("s1.png");
    private GreenfootImage s2 = new GreenfootImage("s2.png");
    private GreenfootImage s3 = new GreenfootImage("s3.png");

    private int frame = 1; 
    private int animateCounter = 0; 
    public void animate(){
        if(frame == 1){
            setImage(s1); 
        }else if (frame == 2){
            setImage(s2); 
        }else if (frame == 3){
            setImage(s3); 
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
        
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new TutorWorld()); 
        }
    }    
}
