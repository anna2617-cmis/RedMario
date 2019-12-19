import greenfoot.*;  

public class Weapon extends Actor
{
    private int danmage;
    private int range; 
    
    public Weapon(){ 
        danmage = 5; 
        range = (int)(Math.random()*20)+50; 
    }
        
    public int getDmg(){
        return danmage; 
    }

    public void act() 
    {
        move(10); 
        range --; 
        if (range == 0 || getX() == 0 || getX() == 1239 || isTouching(Enemy.class)){
            CrystalSplat splat = new CrystalSplat();
            getWorld().addObject(splat, getX(), getY()); 
            splat.setRotation((int)(Math.random()*360)); 
            getWorld().removeObject(this); 
        }
    }   
}
