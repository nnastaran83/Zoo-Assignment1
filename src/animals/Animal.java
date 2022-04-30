
package animals;

import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import static privateutil.MyStrings.*;

/**
 * The class Animal defines the characteristics common to all animals.
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 March 27,22
 */
public abstract class Animal extends Mobile implements IEdible{
    private String name;
    private double weight;
    private IDiet diet;//used for eating appropriate food.

    //Constructors----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Animal constructor
     * @see MessageUtility#logConstractor(String, String)
     * @param name name
     * @param location location
     */
    public Animal(String name, Point location) {
        super(location);
        this.name = name;
        MessageUtility.logConstractor(ANIMAL,name);
    }

    /**
     * Animal constructor
     *@see MessageUtility#logConstractor(String, String)
     * @param name name of animal
     * @param location location of animal
     * @param weight weight of animal
     * @param diet is this animal carnivore, omnivore or herbivore?
     */
    public Animal(String name, Point location, double weight, IDiet diet){
        super(location);
        this.name = name;
        this.weight = weight;
        this. diet =(IDiet)diet.replicate();
        MessageUtility.logConstractor(ANIMAL,name);

    }

    //Setters----------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * set weight, if weight >= 0
     * @see MessageUtility#logSetter(String, String, Object, boolean)
     * return true if weight was set, else return false
     * @param weight weight
     */
    public boolean setWeight(double weight) {
        boolean is_successful = (weight >= 0);
        if(is_successful){
            this.weight = weight;
        }
        MessageUtility.logSetter(getName(), SETWEIGHT, weight, is_successful);
        return is_successful;
    }


    //Getters---------------------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * get name
     * @return name
     */
    public String getName() {
        MessageUtility.logGetter(name, GETNAME, this.name);
        return this.name;
    }

    /**
     * get weight
     * @return weight
     */
    public double getWeight() {
        MessageUtility.logGetter(this.name, GETWEIGHT, this.weight);
        return this.weight;
    }

    /**
     *
     * @return diet
     */
    public IDiet getDiet() {
        MessageUtility.logGetter(this.name,GETDIET, diet);
        return (IDiet) diet.replicate();
    }

    /**
     * tells which type of food is this animal; every animal's food type is MEAT except lions.
     * @return food type
     */
    public EFoodType getFoodtype() {
        if (this.getClass().getSimpleName().equals("Lion")) {
            MessageUtility.logGetter(this.name, "getFoodType", EFoodType.NOTFOOD);
            return EFoodType.NOTFOOD;
        }else{
            MessageUtility.logGetter(this.name, "getFoodType", EFoodType.MEAT);
            return EFoodType.MEAT;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Make sound.
     * this method activates the method roar for animals that can roar
     * and activate the method chew for animals that can chew
     * @see privateutil.ChewerAnimal#makeSound()
     * @see privateutil.RoarerAnimal#makeSound()
     */
    public abstract void makeSound();

    /**
     *
     * @param point the point
     * @return distance traveled
     */
    @Override
    public double move(Point point){
        double distance_traveled = super.move(point);
        setWeight(getWeight()-(distance_traveled * getWeight() * 0.00025));
        return distance_traveled;
    }

    /**
     * Eat boolean.
     * checks if the animal can eat the food , if yes , eat it
     * after eating the animal makes a sound
     * @see MessageUtility#logBooleanFunction(String, String, Object, boolean)
     * @param edible some edible object
     * @return true if the animal could eat, else return false
     */
    public boolean  eat(IEdible edible){
        boolean is_successful = diet.canEat(edible.getFoodtype());
        if(is_successful){
            diet.eat(this, edible);
            this.makeSound();
        }
        MessageUtility.logBooleanFunction(getName(),EAT,edible,is_successful);
        return is_successful;
    }


    /**
     * toString
     * @return "[className]: this.name"
     */
    public String toString(){
        return "[" + this.getClass().getSimpleName() + "]: " + getName();
    }


}
