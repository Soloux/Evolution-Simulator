import greenfoot.*;

public class BerryCreator  
{
   private World world;
   Berry food = new Berry();
   Meat food2 = new Meat();

   int Berry;
   int Meat;
   public int depression;
   public int suicide;
        

    public BerryCreator(World world)
    {
         this.world = world;
         depression = 10;
         suicide = 10;
    }
    
        public void addfood() 
    {
        Berry food = new Berry();
        world.addObject(food, randomRange(0, world.getWidth()), randomRange(0,  world.getHeight()  )  );
    }
        
        public void randomBerry()
    {
        if(depression >= suicide)//change these names
        {
            for(int i = 0; i < 100; i++)
            {
                addfood();
            }
        }
        }
          
             public void randomMeat()
    {
       for(int i = 0; i < 10; i++)
        {
            addfood();
           
            
        }
        }
    
    private int randomRange(int low, int high)
    {
        return (int) ((high - low) * Math.random()) + low;
    }    
}
