package animals;

import diet.Carnivore;
import food.IEdible;
import mobility.Point;
import privateutil.RoarerAnimal;
import utilities.MessageUtility;

import java.util.Random;

import static privateutil.MyStrings.*;

/**
 * The class Lion.
 * Predator only (eats meat).
 * Lion can't be eaten.
 * initial location of a lion is Point(x:20, y:0)
 * initial weight of lion is 408.2 kg.
 * @see Animal
 * @see Carnivore
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public class Lion extends RoarerAnimal {
    private int scarCount = 0;

    //Constructors---------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Lion constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name
     */
    public Lion(String name){
        super(name,new Point(20, 0), 408.2, new Carnivore());
        MessageUtility.logConstractor(LION,name);
    }

    /**
     * Lion constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of lion
     * @param location location of lion
     */
    public Lion(String name, Point location){
        super(name, location, 408.2, new Carnivore());
        MessageUtility.logConstractor(LION,name);
    }

    //Getters------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * get Scar Count
     * @see MessageUtility#logGetter(String, String, Object)
     * @return number of scars of the lion
     */
    public int getScarCount() {
        MessageUtility.logGetter(getName(),GETSCARCOUNT,scarCount);
        return scarCount;
    }

    //Setters------------------------------------------------------------------------------------------------------------------------------------------------------\

    /**
     *
     * @param scarCount the number of the scars of the lion
     * @return true if scarCount >= 0 , else return false
     */
    public boolean setScarCount(int scarCount) {
        boolean is_successful = (scarCount >= 0);
        this.scarCount = scarCount;
        MessageUtility.logSetter(getName(),SETSCARCOUNT, scarCount,is_successful);
        return is_successful;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * each time a lion eats, there is a chance of 50% that it gets a new scar.
     * if lion can eat edible, then eat
     * @param edible edible
     * @return true if the lion could eat,  else return false
     */
    @Override
    public boolean eat(IEdible edible) {
        boolean is_successful = super.eat(edible);
        if(is_successful){
            if(new Random().nextInt(2)==1){
                setScarCount(getScarCount()+1);
            }
        }
        return is_successful;
    }

    /**
     * roar. prints "Roars, then stretches and shakes its mane" when the lion roars.
     */
    public void roar(){
        MessageUtility.logSound(getName(), "Roars, then stretches and shakes its mane");

    }


}
