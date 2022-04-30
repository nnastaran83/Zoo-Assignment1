package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.ChewerAnimal;
import utilities.MessageUtility;

import static privateutil.MyStrings.*;

/**
 * The class Elephant.
 * Elephant is herbivore.
 * initial location of an elephant is Point(x:50, y:90)
 * initial weight of an elephant to 500 kg.
 * @see Herbivore
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public class Elephant extends ChewerAnimal{
    private double trunkLength = 1; // the default value of the elephant's trunk length is 1 meter.
    private final double min_trunk_length = 0.5; //minimum trunk length of an elephant can be 0.5 meter.
    private final double max_trunk_length = 3; //maximum trunk length of an elephant can be 3 meters.

    //Constructors----------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     *Elephant constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of elephant
     *
     */
    public Elephant(String name){
        super(name, new Point(50, 90), 500, new Herbivore());
        MessageUtility.logConstractor(ELEPHANT,name);
    }

    /**
     *Elephant constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of elephant
     * @param location location of elephant
     */
    public Elephant(String name, Point location){
        super(name, location, 500, new Herbivore());
        MessageUtility.logConstractor(ELEPHANT,name);

    }

    //Setters--------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * sets trunk length of the elephant if  0.5 <= trunk length <= 3
     * @see MessageUtility#logSetter(String, String, Object, boolean)
     * @param trunkLength trunkLength
     * @return true is trunk length was set, else return false
     */
    public boolean setTrunkLength(double trunkLength){
        boolean is_successful = (trunkLength >= 0.5 && trunkLength <= 3);
        if(is_successful){
            this.trunkLength = trunkLength;
        }
        MessageUtility.logSetter(getName(), SETTRUNKLENGTH, trunkLength, is_successful);
        return is_successful;
    }
    //Getters--------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * get trunk length of the elephant
     * @see MessageUtility#logGetter(String, String, Object)
     * @return the trunkLength of the elephant
     */
    public double getTrunkLength(){
        MessageUtility.logGetter(getName(),GETTRUNKLENGTH,trunkLength);
        return this.trunkLength;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * chew prints "Trumpets with joy while flapping its ears, then chews" when the elephant chews.
     */
    public void chew(){
        MessageUtility.logSound(getName(), "Trumpets with joy while flapping its ears, then chews");

    }

}
