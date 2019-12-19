import greenfoot.*;  
import java.util.*;
public class Cirno extends Actor implements Movable
{
    private int speed = 4; 
    private final int GRAVITY = 1; 
    private int velocity; 
    private int jumpHeight; 
    private int mana; 
    private static int death = 0; 

    private GreenfootImage cirnoL1 = new GreenfootImage("cirnoL1.png"); 
    private GreenfootImage cirnoL2 = new GreenfootImage("cirnoL2.png");
    private GreenfootImage cirnoL3 = new GreenfootImage("cirnoL3.png");
    private GreenfootImage cirnoL4 = new GreenfootImage("cirnoL4.png");
    private GreenfootImage cirnoR1 = new GreenfootImage("cirnoR1.png");
    private GreenfootImage cirnoR2 = new GreenfootImage("cirnoR2.png");
    private GreenfootImage cirnoR3 = new GreenfootImage("cirnoR3.png");
    private GreenfootImage cirnoR4 = new GreenfootImage("cirnoR4.png");
    private int frame = 1; 
    private int animationCounter = 0; 

    public Cirno(){
        velocity = 0; 
        jumpHeight = -22; 
        mana = 0; 
    }

    public int getDeath(){
        return death; 
    }

    public void moveLeft(){
        setLocation(getX() - speed, getY()); 
        if (animationCounter % 5 == 0){
            animateLeft();
            animationCounter = 0; 
        }
    }

    public void animateLeft(){
        if(frame == 1){
            setImage(cirnoL1); 
        }else if (frame == 2){
            setImage(cirnoL2);
        }else if (frame == 3){
            setImage(cirnoL3);
        }else if (frame == 4){
            setImage(cirnoL4);
            frame = 1; 
            return; 
        }
        frame ++; 
    }

    public void moveRight(){
        setLocation(getX() + speed, getY()); 
        if (animationCounter % 5 == 0){
            animateRight();
            animationCounter = 0; 
        }
    }

    public void animateRight(){
        if(frame == 1){
            setImage(cirnoR1); 
        }else if (frame == 2){
            setImage(cirnoR2);
        }else if (frame == 3){
            setImage(cirnoR3);
        }else if (frame == 4){
            setImage(cirnoR4);
            frame = 1; 
            return; 
        }
        frame ++; 
    }

    public boolean step(){
        Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2 + 5, Enemy.class);
        Actor underBR = getOneObjectAtOffset(-getImage().getHeight()/2,getImage().getHeight()/2 + 5, Enemy.class);
        Actor underBL = getOneObjectAtOffset(getImage().getHeight()/2,getImage().getHeight()/2 + 5, Enemy.class);
        return (under != null || underBR != null ||  underBL != null);    
    }

    public void getKilled(){
        if ((isTouching(Attackable.class)) || getY() > 765 || isTouching(FallF.class)){
            if(!step()){
                getWorld().removeObject(this); 
                death ++; 
                Greenfoot.setWorld(new Lose()); 
            }else{
                jump(); 
                fall(); 
            }
        }
    }

    public void fall(){
        setLocation(getX(),getY()+velocity);
        velocity += GRAVITY; 
    }

    public void jump(){
        velocity = jumpHeight; 
    }

    public boolean onGround(){
        Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2 + 5, Floor.class);
        return under != null;   
    }

    public boolean hitBlockU(){
        Actor upC = getOneObjectAtOffset(0,-getImage().getHeight()/2 - 10, Floor.class);
        Actor upR = getOneObjectAtOffset(getImage().getWidth()/2,-getImage().getHeight()/2 - 10, Floor.class);
        Actor upL = getOneObjectAtOffset(-getImage().getWidth()/2,-getImage().getHeight()/2 - 10, Floor.class);
        return (upC != null || upR != null ||  upL != null); 
    }

    public boolean hitBlockL(){
        Actor hitLC = getOneObjectAtOffset(-getImage().getWidth()/2,0, Floor.class);
        Actor hitLR = getOneObjectAtOffset(-getImage().getWidth()/2,getImage().getHeight()/2 -20, Floor.class);
        Actor hitLL = getOneObjectAtOffset(-getImage().getWidth()/2,-getImage().getHeight()/2, Floor.class);
        return (hitLC != null || hitLR != null || hitLL != null); 
    }

    public boolean hitBlockR(){
        Actor hitRC = getOneObjectAtOffset(getImage().getWidth()/2,0, Floor.class);
        Actor hitRR = getOneObjectAtOffset(getImage().getWidth()/2,getImage().getHeight()/2 -20, Floor.class);
        Actor hitRL = getOneObjectAtOffset(getImage().getWidth()/2,-getImage().getHeight()/2, Floor.class);
        return (hitRC != null || hitRR != null || hitRL != null); 
    }

    public void hitDrop(){
        if (hitBlockU()){
            velocity = 5; 
            fall(); 
        }
    }

    public void checkFalling(){
        if (onGround()== false && !step()){
            fall(); 
        }
    }

    public void fire(){
        Weapon weapon = new Weapon(); 
        getWorld().addObject(weapon, getX(), getY() + 20); 
        if(getImage().equals(cirnoL1)||getImage().equals(cirnoL2)||getImage().equals(cirnoL3)||getImage().equals(cirnoL4)){
            weapon.setRotation(180); 
            weapon.move(60); 
        }else{
            weapon.move(60); 
        }
    }

    public void control(){
        if (Greenfoot.isKeyDown("a") && !hitBlockL()){
            moveLeft(); 
        }else if (Greenfoot.isKeyDown("d") && !hitBlockR()){
            moveRight(); 
        }
        if (Greenfoot.isKeyDown("w") && (onGround() == true)){
            jump(); 
            fall(); 
        }
        if ("space".equals(Greenfoot.getKey()) && mana > 50 ){
            fire();  
            mana = 0; 
        }
    }

    public void act() 
    {
        mana ++; 
        hitDrop(); 
        control(); 
        checkFalling(); 
        animationCounter ++; 
        getKilled(); 
    }    
}
