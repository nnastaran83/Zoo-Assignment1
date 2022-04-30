package privateutil.tests;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import diet.Herbivore;
import food.EFoodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plants.Cabbage;

class HerbivoreTest {
    Herbivore herbivore = new Herbivore();

    @Test
    void testCanEat() {
        boolean result = herbivore.canEat(EFoodType.MEAT);
        Assertions.assertFalse(result);
        result = herbivore.canEat(EFoodType.VEGETABLE);
        Assertions.assertTrue(result);
        result = herbivore.canEat(EFoodType.NOTFOOD);
        Assertions.assertFalse(result);
    }

    @Test
    void testEat() {
        Animal elephant = new Elephant("elep");
        Animal bear = new Bear("b");
        Cabbage cabbage = new Cabbage();
        elephant.setWeight(100);
        double result = herbivore.eat(elephant, cabbage);
        Assertions.assertEquals((7/100.0)*100, result);
        result = herbivore.eat(elephant,bear);
        Assertions.assertEquals(0,result);
    }

    @Test
    void testReplicate() {
        Herbivore result = herbivore.replicate();
        Assertions.assertNotSame(new Herbivore(), result);
    }

    @Test
    void testToString() {
        String result = herbivore.toString();
        Assertions.assertEquals("Herbivore", result);
    }
}

