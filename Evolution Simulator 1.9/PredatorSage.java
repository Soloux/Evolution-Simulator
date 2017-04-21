import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
import java.lang.Math;

public class PredatorSage extends Creature
{
    int hatchtime;
    
        public PredatorSage(int duration, int rotation,Color color, int origDuration)
            {
                super(duration, rotation,color, origDuration);
                speed = 1;
                duration = origDuration;
                origDuration = duration;
                turn(0);
                energy = 1000;           
            } 
      
            
            protected void addedToWorld(World world)
        {
            img = new GreenfootImage(10, 10);
            img.setColor(color);
            img.fillRect(0, 0, 10, 10);
            setImage(img);
        }   
        
         public void PrioritySpinner()
            {

                     if(getWorld() != null )
                    {
                       List<Sage> Sage = (List<Sage>) getObjectsInRange(1000, Sage.class);
                        if(Sage.size() >= 0)
                        {
                              spinTowardsSages();
                        }
                        
                    
                  
                    }
                    
                   if(getWorld() != null)
                  {
                    List<Meat> Meats = (List<Meat>) getObjectsInRange(10000, Meat.class);
                    if(Meats.size() >= 0)
                    {
                        spinTowardsMeats();
                    }
                    
                    
                   }
            }
            
        public void spinTowardsMeats()
        {
            
    
            if(getWorld() != null)
            {
            
            List<Meat> Meats = (List<Meat>) getObjectsInRange(100, Meat.class);
            
            if (Meats.size() > 0)
            {
                Meat m = Meats.get(0);
                
                for(int i = 1; i < Meats.size(); i++)
                {
                    if(getDistance(Meats.get(i)) < getDistance(m) )
                    {
                        m = Meats.get(i);
                    }
                }
           
                turnTowards(m.getX(),m.getY());
            }
            
            }
        }
    
        
        public void spinTowardsSages()
        {
             
            if(getWorld() != null)
            {
            
            List<Sage> Sages = (List<Sage>) getObjectsInRange(100, Sage.class);
            
            if (Sages.size() > 0)
            {
                Sage s = Sages.get(0);
                
                for(int i = 1; i < Sages.size(); i++)
                {
                    if(getDistance(Sages.get(i)) < getDistance(s) )
                    {
                        s = Sages.get(i);
                    }
                }
           
                turnTowards(s.getX(),s.getY());
            }
            
            }
        }
        
        private double getDistance(Actor other)
        {
            double a = Math.pow( (double) getX() - (double) other.getX(), 2);
            double b = Math.pow( (double) getY() - (double) other.getY(), 2);
            return Math.sqrt(a + b);
        }        
      
        
    
          public void devour()
          {
              if(getWorld() != null)
              {
              Sage b = (Sage) getOneIntersectingObject(Sage.class);    
              PredatorSage N = (PredatorSage) getOneIntersectingObject(PredatorSage.class);
              Meat a = (Meat) getOneIntersectingObject(Meat.class);
                if(b != null)
                  {
                   World rage = getWorld();
                   energy = energy + 200;
                   speed = speed + (int) t;
                   duration = duration + 100;
                   addEnergy();
                   addChildPSage();
                   turn(180);
                   rage.removeObject(b);
                  }
                  
                  // else if(N != null)
                  // {
                      // World eat = getWorld();
                      // energy = energy + 200;
                      // speed = speed + (int) t;
                      // duration = duration + 100;
                      // addEnergy();
                      // addChild();
                      // hatchtime = 0;
                      // eat.removeObject(N);
                  // } 
                  
                else if(a != null)
                  {
                    World matthew = getWorld();
                    energy = energy + 200;
                    duration = duration + 100;
                    addEnergy();
                    matthew.removeObject(a);
                                 
                 }
            }
         }
         
          public void  bounceFromEachOther()
            {
                    
              if(getWorld() != null)
                    {
                    PredatorSage e = (PredatorSage) getOneIntersectingObject(PredatorSage.class);
                      if(e != null)
                      {
                        turn(degree);
                        move(speed);
                        move(speed);
                      }
                    }
            }
            
        
        
       public void energyLevel()
        {
             Meat b = new Meat() ;
            if(getWorld() != null &&  energy <= 0)
            {
                getWorld().addObject(b,getX(),getY());
                getWorld().removeObject(this);
                
               
            }
       }
            
        
        public int randomRange(int low, int high)
        {
            return (int) ((high - low) * Math.random()) + low;
        }
        
        public void act() 
        {
          PrioritySpinner();
          bounceFromEachOther();
          super.act();
          devour();
           
        }    
}
