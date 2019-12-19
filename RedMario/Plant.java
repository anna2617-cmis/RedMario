import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author Young Il Kim
 * @version (a version number or a date)
 */
public class Plant extends Actor implements Attackable
{
    private int health = 10;
    
    public Plant(){

    }
    
    public void getKilled(){
        if (health <= 0){
            getWorld().removeObject(this);
        }
    }

    /** @param dmg  the amount of danmage taken from the Cirno
     *   @return a integer representing the left over health 
     */
    public void deductHealth(int dmg){
        this.health -= dmg;
    }

    /** change the moving direction and the img direction of the monster */
    public void changeDirection(){
    }

    public int getHealth(){
        return health;
    }
}
