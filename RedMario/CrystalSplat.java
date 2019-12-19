import greenfoot.*;  
public class CrystalSplat extends Actor
{
    private int lifeTime; 
    
    public CrystalSplat(){
        lifeTime = 10; 
    }
    
    public void act() 
    {
        lifeTime--; 
        if (lifeTime == 0 || isTouching(Enemy.class)){
            getWorld().removeObject(this); 
        }
    }    
}
