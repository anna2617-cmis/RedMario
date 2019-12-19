import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor implements Movable, Attackable 
{
    private int health; 
    private boolean isLeft; 
    private int frame = 1; 
    private int animationCounter = 0; 
    private int speed; 
    private final int GRAVITY = 1; 
    private int velocity; 
    private int deathCounter = 10; 

    private GreenfootImage monL1 = new GreenfootImage("monL1.png");
    private GreenfootImage monL2 = new GreenfootImage("monL2.png");
    private GreenfootImage monL3 = new GreenfootImage("monL3.png");
    private GreenfootImage monR1 = new GreenfootImage("monR1.png");
    private GreenfootImage monR2 = new GreenfootImage("monR2.png");
    private GreenfootImage monR3 = new GreenfootImage("monR3.png");
    public Enemy(){
        if(Math.random() < 0.5)
            isLeft = true;
        else 
            isLeft = false; 
        health = 20; 
        speed = 3; 
    }

    public void moveLeft(){
        setLocation(getX() - speed, getY()); 
        if (animationCounter % 5 == 0){
            animateLeft();
            animationCounter = 0; 
        }
    } 

    public void moveRight(){
        setLocation(getX() + speed, getY()); 
        if (animationCounter % 5 == 0){
            animateRight();
            animationCounter = 0; 
        }
    } 
    
    public int getHealth(){
        return health; 
    }

    public void fall(){
        setLocation(getX(),getY()+velocity);
        velocity += GRAVITY; 
    }

    public void animateLeft(){
        if(frame == 1){
            setImage(monL1); 
        }else if (frame == 2){
            setImage(monL2); 
            frame = 1; 
            return; 
        }
        frame ++; 
    }

    public void animateRight(){
        if(frame == 1){
            setImage(monR1); 
        }else if (frame == 2){
            setImage(monR2); 
            frame = 1; 
            return; 
        }
        frame ++; 
    }

    public void getKilled(){
        if(health == 0 || getY() > 765){
            getWorld().removeObject(this); 
        }
    }

    public void animateDeath(){
        for (int a = 0; a < 10; a ++){
            if (getImage().equals(monL1)||getImage().equals(monL2))
                setImage(monL3); 
            else if (getImage().equals(monR1)||getImage().equals(monR2))
                setImage(monR3); 
        }
    }

    public boolean isAlive(){
        if (health > 5){
            return true; 
        }
        return false; 
    }

    public void deductHealth(int dmg){
        health -= dmg; 
    } 
    
    public boolean atEdge(){
        if(getX() < 10 || getX() > getWorld().getWidth()-10){
            return true; 
        }
        if(getY() < 10 || getY() > getWorld().getHeight()-10){
            return true; 
        }else{
            return false; 
        }
    }

    public void changeDirection(){
        if (hitBlock() || atEdge())
            isLeft = !isLeft; 
    }
    
    public void changeDirection(boolean condition){
        isLeft = condition; 
    }

    public void getHit(){
        if (isTouching(Weapon.class) || isTouching(CrystalSplat.class)){
            deductHealth(5); 
        }
    }

    private boolean onGround(){
        Actor under = getOneObjectAtOffset(0,getImage().getHeight()/2 + 5, Floor.class);
        Actor underBR = getOneObjectAtOffset(-getImage().getHeight()/2,getImage().getHeight()/2 + 5, Floor.class);
        Actor underBL = getOneObjectAtOffset(getImage().getHeight()/2,getImage().getHeight()/2 + 5, Floor.class);
        return (under != null || underBR != null ||  underBL != null);  
    }

    private boolean hitBlock(){
        Actor hitL = getOneObjectAtOffset(-getImage().getWidth()/2,0, Floor.class);
        Actor hitR = getOneObjectAtOffset(getImage().getWidth()/2,0, Floor.class);
        if (hitL != null){
            return hitL != null; 
        } else if (hitR != null){
            return hitR != null; 
        }
        return false; 
    }

    public void checkFalling(){
        if (onGround()== false){
            fall(); 
        }
    }

    public void act() 
    {
        getHit(); 
        changeDirection(); 
        checkFalling(); 
        if(isAlive()){
            if (isLeft){
                moveLeft(); 
            }else{
                moveRight(); 
            }
        }else
            animateDeath(); 
        getKilled(); 
    }    
}