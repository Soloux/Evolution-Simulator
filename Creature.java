import greenfoot.*; 
import java.awt.Color;
 

public class Creature extends Actor implements Impassable
{
    int speed;
    int origSpeed;
    long timer;
    int duration;
    int energy;
    int origDuration;
    int origEnergy;
    int degree;
    double p;
    double s;
    double sp;
    double t;
    int counter;
    GreenfootImage img;
    protected Color color;
   
    
         
       public Creature(int duration, int rotation, int origDuration)
    {   
        duration = 120;
        degree = randomRange(0,360);
        turn(degree);  
        this.duration = duration;
        }
        
  
        
       public Creature(int duration, int rotation, Color color,int origDuration)
    {
        duration = 500; 
        degree = randomRange(0,360);        
      
        this.color = color;
        turn(rotation);  
        this.duration = duration; 
        }
        
            public void act() 
    {
        
    }
    
    public void moveAround()
    {
        
        if(hitImpassable() == false && getWorld() != null)
                {  
                   move(speed);
                    if(Greenfoot.getRandomNumber(100) < 10)
                    {turn(Greenfoot.getRandomNumber(90) - 45);
                     
                    }
                }
                
                
          else if(hitImpassable() && getWorld() != null)
          {
              bounceFromEachOther();
            }

    }
    
    
    
    public void Lifetime()
    {
      if (getWorld() != null && duration <= 0)
        {
            getWorld().addObject(new Meat(), getX(), getY());
            getWorld().removeObject(this);   
        }

    }
    
    
      public void energyLevel()
      {
        if(getWorld() != null &&  energy <= 0)
        {
            getWorld().addObject(new Meat(), getX(), getY()); 
            getWorld().removeObject(this);
        }
    }
       
   public void counter()
   {
            if(counter < 10)
            {
                counter++;
            }
            if(counter == 10)
            {
                speed++;
                counter = 0;
            }
    }
    
    protected void addedToWorld(World world)
    {
        img = new GreenfootImage(10, 10);
        img.setColor(color );
        img.fillOval(0, 0, 10, 10);
       
        setImage(img);
    }   
    
   
    
           public void bounceFromWall()
    {
            
      if (isAtEdge() == true)
        {
             turn(degree);
        }
            
         else  
         {
         }
    }
    
   
    
       public void addChildSage()
         {
            if(getWorld() != null)
            {
                
                World w = getWorld();
                int inheritedDuration = randomRange(-30, 30);
                Sage s = new Sage(duration, getRotation() + 10, color,origDuration);
                origDuration = duration;
                origDuration = origDuration + inheritedDuration;
                w.addObject(s, getX(), getY());
            }
    
       }
    
      public void addChildPSage()
         { 
            
                   if(getWorld() != null)
                {
                   
                    World w = getWorld();
                    int inheritedDuration = randomRange(-30, 30);
                    PredatorSage s = new PredatorSage(duration, getRotation() + 10,color, origDuration);
                    turn(180);
                    w.addObject(s, getX()+10, getY()+10);
                    origDuration = duration;
                    origDuration = origDuration + inheritedDuration;;
                }  
                   
        }    
        
        protected boolean hitImpassable()
    {
        if(isTouching(Impassable.class))
        {
            return true;
            
        }
        
        return false;
    }
    
    public void  bounceFromEachOther()
            {
                    
              if(getWorld() != null)
                    {
                    Sage e = (Sage) getOneIntersectingObject(Sage.class);
                      if(e != null)
                      {
                        turn(degree);
                        move(speed);
                        move(speed);
                        move(speed);
                      }
                    }
            }
    
    public int getOriginalVariables()
    {
        origDuration = duration;
        return origDuration;
    }
    
    public void addEnergy()
    {
        this.duration = duration + 10;
    }
    
    public int randomRange(int low, int high)
    {
        return (int) ((high - low) * Math.random()) + low;
    }
    
    private double randomRange(double low, double high)
    {
        return (double) ((high - low) * Math.random()) + low;
    }
    

}
