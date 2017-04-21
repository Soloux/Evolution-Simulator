import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
public class Sage extends Creature
    {
       
        List<Double> distances = new ArrayList<Double>();
        boolean isMale;
      
            public Sage(int duration, int rotation, Color color,int origDuration)
            {
                super(duration, rotation, color,origDuration);
                speed = 2;
                duration = origDuration;
                origDuration = duration;
                turn(0);
                energy = 1000;  
                
            } 
            
            
            public boolean isMale()
            {
                int i = randomRange(0,2);
                
                if(i == 1)
                {
                     return isMale = true;   
                }
                
                else 
                {
                      return isMale = false;
                }
                
            }
            
            public void PrioritySpinner()
            {

                     if(getWorld() != null )
                    {
                       List<PredatorSage> PredatorSage = (List<PredatorSage>) getObjectsInRange(1000, PredatorSage.class);
                        if(PredatorSage.size() >= 0)
                        {
                              spinAwayFromPredatorSage();
                        }
                        
                    
                  
                    }
                    
                   if(getWorld() != null)
                  {
                    List<Berry> berries = (List<Berry>) getObjectsInRange(10000, Berry.class);
                    if(berries.size() >= 0)
                    {
                        spinTowardsBarry();
                    }
                    
                    
                   }
            }
        
            public void spinTowardsBarry()
                {
                     
                    if(getWorld() != null)
                    {
                    
                    List<Berry> berries = (List<Berry>) getObjectsInRange(100, Berry.class);
                    
                    if (berries.size() > 0)
                    {
                        Berry b = berries.get(0);
                        
                        for(int i = 1; i < berries.size(); i++)
                        {
                            if(getDistance(berries.get(i)) < getDistance(b) )
                            {
                                b = berries.get(i);
                            }
                        }               
                        turnTowards(b.getX(),b.getY());
                    }
                    }
                }
                
                 public void spinAwayFromPredatorSage()
            {
                
        
                if(getWorld() != null)
                {
                
                List<PredatorSage> PredatorSage = (List<PredatorSage>) getObjectsInRange(20, PredatorSage.class);
                
                if (PredatorSage.size() > 0)
                {
                    PredatorSage m = PredatorSage.get(0);
                    
                    for(int i = 1; i < PredatorSage.size(); i++)
                    {
                        if(getDistance(PredatorSage.get(i)) < getDistance(m) )
                        {
                            m = PredatorSage.get(i);
                        }
                    }
               
                    turnTowards(m.getX(),m.getY());
                    turn(180);
                }
                
                }
            }
            
            private double getDistance(Actor other)
            {
                double a = Math.pow( (double) getX() - (double) other.getX(), 2);
                double b = Math.pow( (double) getY() - (double) other.getY(), 2);
                return Math.sqrt(a + b);
            }
                     
             public void getEnergy()
            {
                if(getWorld() != null)
                    {
                    Berry e = (Berry) getOneIntersectingObject(Berry.class);
                      if(e != null)
                      {
                        World nicholas = getWorld();
                        energy = energy + 150;
                        addEnergy();
                        addChildSage();  
                        nicholas.removeObject(e);
                        duration = duration + 2;
                      }
                    }
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
        
        
        
            public int randomRange(int low, int high)
            {
                return (int) ((high - low) * Math.random()) + low;
            }
            
            public void act() 
            {
               bounceFromEachOther();
               PrioritySpinner();
               getEnergy();
               super.act();
            }    
}
