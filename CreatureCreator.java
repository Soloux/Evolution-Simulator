   import greenfoot.*;
   import java.awt.Color;
   
   public class CreatureCreator  
{
    private World world;
    private long creatureCounter;
 
    public CreatureCreator(World world)
    {
        this.world = world;
        creatureCounter = System.currentTimeMillis();
    }
    
    
    
    public void randomCreatureSage()
    {
       for(int i = 0; i < 10; i++)
        {
            addCreatureSage();
        }
    }
    
    public void randomCreaturePredatorSage()
    {
       for(int i = 0; i < 1; i++)
        {
            addCreaturePredatorSage();
        }
    }

    public void addCreatureSage() 
    {
        int duration = randomRange(world.getWidth(),world.getHeight());
        int rotation = randomRange(0, 360);
        int origDuration = duration;
        Sage sage = new Sage(duration, rotation, randomColor(),origDuration);
        world.addObject(sage, randomRange(0, world.getWidth()), randomRange(0,  world.getHeight()  )  );
    }
    
    public void addCreaturePredatorSage() 
    {
        int duration = randomRange(world.getWidth(),world.getHeight());
        int rotation = randomRange(0, 360);
        int origDuration = duration;
        Color color = randomColor();
        
        
        PredatorSage predatorSage = new PredatorSage(duration, rotation,color,origDuration);
        world.addObject(predatorSage, randomRange(0, world.getWidth()), randomRange(0,  world.getHeight()  )  );
        
    }
    
    public static int randomRange(int low, int high)
    {
        return (int) ((high - low) * Math.random()) + low;
    }
    
    public static Color randomColor()
    {
        int r = randomRange(0, 256);
        int g = randomRange(0, 256);
        int b = randomRange(0, 256);
        return new Color(r, g, b);
    }
    
}

