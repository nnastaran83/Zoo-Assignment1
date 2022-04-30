package privateutil;

import animals.Animal;
import diet.IDiet;
import mobility.Point;

/**
 * The class ChewerAnimal defines the characteristics common to animals that chew.
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public abstract class ChewerAnimal extends Animal {
    public ChewerAnimal(String name, Point location) {
        super(name, location);
    }

    public ChewerAnimal(String name, Point location, double weight, IDiet diet){
        super(name ,location ,weight ,diet);
    }

    @Override
    public void makeSound() {
        chew();
    }

    /**
     * prints individual message for the animal that chews
     */
    public abstract void chew();
}
