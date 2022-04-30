package zoo;
import animals.*;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static privateutil.MyStrings.MOVE;

/**
 * the class ZooActions
 * this class includes the main method
 * @author Nastaran Motiee - 329022727
 * @campus Ashdod
 * @version 1.0 April 02,22
 */
public class ZooActions {
    private static  List<Animal> animals = new ArrayList<>();
    private static int array_size = 0;
    private static final Scanner input = new Scanner(System.in); // create an object of Scanner

    public static void main(String[] args) {

        //Ask user to enter the number of animals
        askToEnterTheNumberOfAnimals();

        for(int i = 0; i < array_size; i++){
            //Ask user to select an animal from the option menu, choose a name for the animal and put it in the zoo (animals list)
            askToChooseNameForAnimal(askToChooseAnimalOptionMenu());
        }

        //Animals movement simulation
        moveSimulation(animals);

        //Eating simulation
        eatSimulation(animals);


    }

//Ask user methods--------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * ask user to choose the number of animals to be at zoo
     * the number has to be greater than 3
     * while the number is less than 3, keep asking
     * changes the array_size value
     */
    public static void  askToEnterTheNumberOfAnimals(){
        // Display menu graphics
        System.out.println("👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇");
        System.out.println("|   Please enter the number of animals to build your zoo  |");
        System.out.println("|      The number of animals has to be greater than 3     |");
        System.out.println("👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇");

        array_size = input.nextInt();//number of animals input

        //while the number is less than 3, keep asking
        while(array_size < 3){
            System.out.println("❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌");
            System.out.println("|            You chose a number less than 3 !!!           |");
            System.out.println("|The number of animals in the zoo has to be greater than 3|");
            System.out.println("|               Please choose another number!             |");
            System.out.println("❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌");
            array_size = input.nextInt();
        }

    }

    /**
     * Asks user to choose an animal from the options
     * the input should be the number of the option
     */
    public static int askToChooseAnimalOptionMenu(){
        System.out.println("👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇");
        System.out.println("     Enter a number from the options to select an animal:  ");
        System.out.println("                                         1.Bear       🐻   ");
        System.out.println("                                         2.Elephant   🐘   ");
        System.out.println("                                         3.Giraffe    🦒   ");
        System.out.println("                                         4.Lion       🦁   ");
        System.out.println("                                         5.Turtle     🐢   ");
        System.out.println("👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇");
        int selected = input.nextInt();
        while (selected < 0 || selected > 5){
            System.out.println("❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌");
            System.out.println("|           Your input is not in the options !!!          |");
            System.out.println("           Please enter a number from the options!        |");
            System.out.println("❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌");
            selected = input.nextInt();

        }
       return selected;
    }

    /**
     * asks the user to choose a name for the animal and builds an object for it
     * @param animal_option the number user entered to select from the options menu
     */
    public static void askToChooseNameForAnimal(int animal_option){
        System.out.println("👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇");
        System.out.println("              Choose a name for this animal:              ");
        System.out.println("👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇👇");
        String animal_name = input.next();
        switch (animal_option) {
            case 1 -> animals.add(new Bear(animal_name));
            case 2 -> animals.add(new Elephant(animal_name));
            case 3 -> animals.add(new Giraffe(animal_name));
            case 4 -> animals.add(new Lion(animal_name));
            case 5 -> animals.add(new Turtle(animal_name));
        }
    }

 //move + moveSimulation-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * this method can get every kind of animal
     * and checks which class the animal belongs to
     * the method checks if the animal move (if the point is inside the legal bounds);
     * if yes, performs a simulation of movement of the animals
     * @see Animal
     * @see mobility.Mobile
     * @param animal animal
     * @param point point
     * @return true if animal could move to point, else return false
     */
    private static boolean move(Object animal, Point point){
        double distance_traveled = 0;
        // actually there is no need to do the conversion here ; but it is required in the assignment
        if(Point.checkBoundaries(point)){
            if(animal instanceof Bear){
                distance_traveled = ((Bear) animal).move(point);
            }else if(animal instanceof Elephant){
                distance_traveled = ((Elephant) animal).move(point);
            }else if(animal instanceof  Giraffe){
                distance_traveled = ((Giraffe)animal).move(point);
            }else if(animal instanceof  Lion){
                distance_traveled = ((Lion) animal).move(point);
            }else if(animal instanceof  Turtle){
                distance_traveled = ((Turtle) animal).move(point);
            }

       }
        if(animal instanceof Animal){
            MessageUtility.logBooleanFunction(((Animal) animal).getName(),MOVE,point,distance_traveled != 0);
        }

        return distance_traveled != 0;
    }

    /**
     * This method performs a simulation of movement of the animals
     * uses random points
     * @param animals animals array list
     */
    private static void moveSimulation(List<Animal> animals){
        System.out.println("🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭");
        System.out.println("                     Movement Simulation                    ");
        System.out.println("🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭🧭");
        Random random_number = new Random();
        int x = random_number.nextInt(800), y = random_number.nextInt(800);
        for (Animal animal : animals) {
            if (animal != null) {
                move(animal, new Point(x, y));
                x = random_number.nextInt(1000);
                y = random_number.nextInt(1000);
            }

        }
    }


//eat + eatSimulation-------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * this method can get every kind of animal
     * and checks which class the animal belongs to
     * the method checks if the animal can eat the food; if yes, eat it
     * @see Animal#eat(IEdible)
     * @param animal animal
     * @param food food
     * @return true if animal could eat the food, else return false
     */
    private static boolean eat(Object animal, IEdible food){
        boolean ate = false;
        // actually there is no need to do the conversion here ; but it is required in the assignment
        if(animal instanceof Bear){
            ate = ((Bear) animal).eat(food);
        }else if(animal instanceof Elephant){
            ate = ((Elephant) animal).eat(food);
        }else if(animal instanceof  Giraffe){
            ate = ((Giraffe)animal).eat(food);
        }else if(animal instanceof  Lion){
            ate = ((Lion) animal).eat(food);
        }else if(animal instanceof  Turtle){
            ate = ((Turtle) animal).eat(food);
        }
        // if(animal instanceof Animal){
        //    ate = ((Animal) animal).eat(food);
        // }
        return ate;
    }

    /**
     * This method performs a simulation of eating
     * each time will pick two random animals and one will eat the other if it can
     * @param animals animals list
     */
    private static void eatSimulation(List<Animal> animals){
        System.out.println("🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲");
        System.out.println("                  Random Eating Simulation                 ");
        System.out.println("🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲🍲");
        int num_of_loops = animals.size() / 2;

        Random random = new Random();
        int eater_index = 0, food_index = 0;
        for(int i = 0; i < num_of_loops; i++){
            eater_index = random.nextInt(animals.size());
            food_index = random.nextInt(animals.size());
            while (eater_index == food_index){
                eater_index = random.nextInt(animals.size());
                food_index = random.nextInt(animals.size());
            }
            if(eat(animals.get(eater_index), animals.get(food_index))){
                animals.remove(food_index);
            }
        }

    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------

}
