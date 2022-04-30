package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.ChewerAnimal;
import utilities.MessageUtility;

import static privateutil.MyStrings.GIRAFFE;

/**
 * The class Giraffe.
 * Giraffe is a herbivore
 * initial location of a giraffe is Point(x:0, y:50)
 * initial weight of a giraffe is 450 kg.
 * @see Animal
 * @see Herbivore
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public class Giraffe extends ChewerAnimal{
    private double neckLength = 1.5; // The default value for giraffe neck length is 1.5 meters.
    private final double min_neckLength = 1; //minimum neck length of a giraffe is 1 meter.
    private final double max_neckLength = 2.5;//maximum neck length of a giraffe is 2.5 meters.
    private Herbivore herbivore = new Herbivore(); //Giraffe is a herbivore

    //Constructors--------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Giraffe constructor.
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of giraffe
     */
    public Giraffe(String name) {
        super(name, new Point(0,50), 450, new Herbivore());
        MessageUtility.logConstractor(GIRAFFE,name);
    }

    /**
     * Giraffe constructor.
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of giraffe
     * @param location location of giraffe
     */
    public Giraffe(String name, Point location){
        super(name, location, 450, new Herbivore());
        MessageUtility.logConstractor(GIRAFFE,name);
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * chew prints "Bleats and Stomps its legs, then chews" when the giraffe chews.
     */
    public void chew(){
        MessageUtility.logSound(getName(), "Bleats and Stomps its legs, then chews");
    }


}
