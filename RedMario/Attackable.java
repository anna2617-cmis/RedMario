import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Attackable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Attackable 
{   /** remove the object that gets killed from the world */
    public void getKilled(); 
    /** @param dmg  the amount of danmage taken from the Cirno
    *   @return a integer representing the left over health 
    */
    public void deductHealth(int dmg); 
    /** change the moving direction and the img direction of the monster */
    public void changeDirection(); 
    public int getHealth(); 
}
