import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Status extends Actor
{
    private int lifeNum; 

    public String getLife(){
        Cirno cirno = ((Lose)getWorld()).getCirno(); 
        lifeNum = cirno.getDeath(); 
        String num = "" + lifeNum; 
        return num; 
    }

    public void act() 
    {
        GreenfootImage img = getImage();  
        img.drawString(getLife(), 20, 20); 
        setImage(img);
    }    
}
