import greenfoot.*; 
import java.util.List;
import java.awt.Color;
/**
 * Write a description of class testWold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testWorld extends World
{
    private BerryCreator foodCreator;
    private CreatureCreator creatureCreator;
    int tick = 0;
    Label label;
    int numberOfCreatures;
    int XValue = 10;
    int YValue = 10;
    public testWorld()
    {    
        super(1200,800, 1); 
        XValue = 5200;//this value makes it easy to change the map size
        YValue = 3800;//this value makes it easy to change the map size
        //creatures
        creatureCreator = new CreatureCreator(this);//creates a new object
        creatureCreator.randomCreatureSage();//places it randomly on the map
        creatureCreator.randomCreaturePredatorSage();//places it randomly on the map
        //label
        label = new Label(getPopulation(), 40);//sets label as a new object
        addObject(label, 20, 20);//puts this label in the world
        //berry
         foodCreator = new BerryCreator(this);//renames berrycreator
         foodCreator.randomBerry();//calls randomberry from berrycreator
    }
    
    public testWorld(int XValue, int YValue)//second constructor
    {    
        super(XValue, YValue, 1); //this calls the original map size
        this.XValue = XValue;//this value makes it easy to change the map size
        this.YValue = YValue;//this value makes it easy to change the map size
        //creatures
        creatureCreator = new CreatureCreator(this);//creates a new object
        creatureCreator.randomCreatureSage();//places it randomly on the map, initially
        creatureCreator.randomCreaturePredatorSage();//places it randomly on the map,initially
        //berry
        foodCreator = new BerryCreator(this);//renames berrycreator
        foodCreator.randomBerry();//calls randomberry from berrycreator
        //label
        label = new Label(getPopulation(), 40);//sets label as a new object
        addObject(label, 20, 20);//puts this label in the world
    }
    
        public void act()
    {       
       keyCommands();
       checkDead();//calls checkDead
       label.setValue(getPopulation());//gets the number for the label
       numberOfCreatures = getPopulation();//sets the number to a variable
       tick++;//adds        
       if(tick % 10 == 0)//adds food every ten acts
       {
           foodCreator.addfood();
        }
    }
    
    public int getPopulation()
    { 
        List<Creature> creatures =  (List<Creature>)  getObjects(Creature.class);
        return creatures.size();
    }
    
    public int randomRange(int low, int high)//makes us able to actually get a random number
        {
            return (int) ((high - low) * Math.random()) + low;
        }
    
    
    public void addCreatureSage() 
    {
        int duration = randomRange(800,1200);
        int rotation = randomRange(0, 360);
        int origDuration = duration;
         Color color = CreatureCreator.randomColor();
        
        Sage sage = new Sage(duration, rotation, color, origDuration);
        addObject(sage,randomRange(0,getWidth()),randomRange(0,getHeight()));
    }
    
    public void addCreaturePredatorSage() 
    {
        int duration = randomRange(800,1200);
        int rotation = randomRange(0, 360);
        int origDuration = duration;
        
         Color color = CreatureCreator.randomColor();

        PredatorSage predatorSage = new PredatorSage(duration, rotation, color, origDuration);
        addObject(predatorSage,randomRange(0,getWidth()),randomRange(0,getHeight()  )  );
        
    }
    public void keyCommands()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            addCreatureSage();
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            addCreaturePredatorSage();
        }
        
        
    }
        
    public void checkDead() //this checks to see if every creature is dead, it then adds one of each type of sage
    {
        if(numberOfCreatures <= 10)//checks to see if there are any creatures are in the world
        {
           addCreatureSage();//calls addCreatureSage
           addCreaturePredatorSage();//Calls addCreaturePredatorSage
        }
    }
}
