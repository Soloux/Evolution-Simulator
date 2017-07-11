import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Meat extends Food
{
   int Meat;
   private World world;
   
    public Meat()
    {
        GreenfootImage img = getImage();
        img.scale(10, 10);
        setImage(img);
    }
   
    
    
        private int randomRange(int low, int high)
    {
        return (int) ((high - low) * Math.random()) + low;
    }   
}
