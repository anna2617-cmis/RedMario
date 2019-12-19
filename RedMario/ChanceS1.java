import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ChanceS1 extends Floor
{
    private int hits = 2; 
    private int respondTime = 0; 
    public void act() 
    {
        if (isTouching(Cirno.class) && hits == 2){
            getWorld().addObject(new Plant(), getX(), getY()-65);
            hits --; 
        }else if (isTouching(Cirno.class) && hits == 1){
            getWorld().addObject(new BrickWarn(), 260, 95);
            hits --; 
        }else if (isTouching(Cirno.class) && hits == 0){
            getWorld().addObject(new Enemy(), getX() + 30, getY()-60);
            getWorld().addObject(new Enemy(), getX(), getY()-60);
            getWorld().addObject(new Enemy(), getX() - 30, getY()-60);
            hits --; 
        }
    }    
}
