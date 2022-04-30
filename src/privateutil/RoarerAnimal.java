package privateutil;

import animals.Animal;
import diet.IDiet;
import mobility.Point;

/**
 * The class RoarerAnimal defines the characteristics common to animals that roar.
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public abstract class RoarerAnimal extends Animal {
    public RoarerAnimal(String name, Point location) {
        super(name, location);
    }

    public RoarerAnimal(String name, Point location, double weight, IDiet diet){
        super(name ,location ,weight ,diet);
    }


    @Override
    public void makeSound() {
        roar();
    }

    /**
     * prints individual message for the animal that roars
     */
    public abstract void roar();
}
