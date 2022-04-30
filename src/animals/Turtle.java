package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.ChewerAnimal;
import utilities.MessageUtility;

import static privateutil.MyStrings.TURTLE;

/**
 * The class Turtle.
 *Turtle is a herbivore.
 *initial location of a turtle is Point(x:80, y:0)
 *initial weight of a turtle to 1 kg.
 * @see Animal
 * @see Herbivore
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public class Turtle extends ChewerAnimal{
    private int Age = 1; // The default age of a turtle is 1 year.
    private final int min_age = 0; //minimum age of a turtle is 0 years.
    private final int max_age = 500; //maximum age of a turtle is 500 years.

    //Constructors------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Turtle constructor.
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of turtle
     */
    public Turtle(String name){
        super(name,new Point(80, 0),1, new Herbivore());
        MessageUtility.logConstractor(TURTLE,name);
    }

    /**
     * Turtle constructor.
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of turtle
     * @param location location of turtle
     */
    public Turtle(String name, Point location){
        super(name, location, 1, new Herbivore());
        MessageUtility.logConstractor(TURTLE,name);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * chew prints "Retracts its head in then eats quietly" when the turtle chews.
     */
    public void chew(){
        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");

    }

}
