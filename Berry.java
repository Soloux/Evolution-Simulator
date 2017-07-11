import greenfoot.*;


public class Berry extends Food
{

   int Berry;
   private World world;
   
    public Berry()
    {
        GreenfootImage img = getImage();
        img.scale(10, 10);
        setImage(img);
    }
    
         private void addFood() 
    {    
        Berry food = new Berry();
        world.addObject(food, randomRange(0, world.getWidth()), randomRange(0,  world.getHeight()  )  );
    }
    
        private int randomRange(int low, int high)
    {
        return (int) ((high - low) * Math.random()) + low;
    }    
    }
    
    
    
    
    
   
    
    
    
