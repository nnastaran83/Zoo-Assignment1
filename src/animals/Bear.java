package animals;

import diet.Omnivore;
import mobility.Point;
import privateutil.RoarerAnimal;
import utilities.MessageUtility;

import static privateutil.MyStrings.BEAR;

/**
 * The class Bear.
 * Bear is omnivore
 *initial weight of a bear is 308.2 kg.
 * bear is omnivore
 * @see Omnivore
 * @see Animal
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public class Bear extends RoarerAnimal {
    private enum colors{BLACK, WHITE,GRAY};//Bear can be BLACK , WHITE OR GRAY
    private String furColor = colors.GRAY.toString();

    //Constructors----------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     *Bear constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of bear
     */
    public Bear(String name){
        super(name, new Point(100, 5),308.2, new Omnivore());
        MessageUtility.logConstractor(BEAR, name);
    }

    /**
     *Bear constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name of bear
     * @param location location of bear
     *
     */
    public Bear(String name, Point location){
        super(name, location, 308.2,new Omnivore());
        MessageUtility.logConstractor(BEAR,name);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * roar.prints "Stands on its hind legs, roars and scratches its belly" when the bear roars.
     */
    public void roar(){
        MessageUtility.logSound(getName(), "Stands on its hind legs, roars and scratches its belly");

    }


}
