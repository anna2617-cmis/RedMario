import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class RecF extends Floor
{
    private GreenfootImage rf0 = new GreenfootImage("rf1.png");
    private GreenfootImage rf1 = new GreenfootImage("rf2.png");
    private GreenfootImage rf2 = new GreenfootImage("rf3.png");
    private GreenfootImage rf3 = new GreenfootImage("rf4.png");
    private GreenfootImage rf4 = new GreenfootImage("rf5.png");

    private List<GreenfootImage> recFloor = new ArrayList<GreenfootImage>(); 

    public RecF(){
        recFloor.add(rf0); 
        recFloor.add(rf1); 
        recFloor.add(rf2); 
        recFloor.add(rf3);
        recFloor.add(rf4); 
        setImage(recFloor.get((int)(Math.random()*5)));
    }

    public void setImg(int num){
        setImage(recFloor.get(num));
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
