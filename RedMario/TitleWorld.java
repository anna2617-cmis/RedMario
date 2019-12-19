import greenfoot.*;  
public class TitleWorld extends World
{

    /**
     * Constructor for objects of class Title.
     * 
     */
    public TitleWorld()
    {    
        super(1240, 768, 1); 
        prepare(); 
    }
    
    public void prepare(){
        addObject(new Title(), 580, 400); 
        addObject(new Start(), 620, 640); 
    } 
}
