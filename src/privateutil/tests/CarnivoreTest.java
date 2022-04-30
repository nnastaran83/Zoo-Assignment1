package privateutil.tests;

import animals.Animal;
import animals.Elephant;
import animals.Lion;
import diet.Carnivore;
import food.EFoodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarnivoreTest {
    Carnivore carnivore = new Carnivore();

    @Test
    void testCanEat() {
        boolean result = carnivore.canEat(EFoodType.MEAT);
        Assertions.assertTrue(result);
    }

    @Test
    void testEat() {
        Animal lion = new Lion("lio");
        Animal elephant = new Elephant("elep");
        lion.setWeight(100);
        double result = carnivore.eat(lion, elephant);
        Assertions.assertEquals(10, result);
        result = carnivore.eat(elephant,lion);
        Assertions.assertEquals(0,result);
    }

   @Test
   void testReplicate() {
       Carnivore replicated = carnivore.replicate();
       Assertions.assertNotSame(carnivore,replicated);
   }

   @Test
   void testToString() {
       String result = carnivore.toString();
       Assertions.assertEquals("Carnivore", result);
   }
}
