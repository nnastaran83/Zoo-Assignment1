package privateutil.tests;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import diet.Omnivore;
import food.EFoodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import plants.Cabbage;

class OmnivoreTest {
    Omnivore omnivore = new Omnivore();
    @Test
    void testCanEat() {
        boolean result = omnivore.canEat(EFoodType.MEAT);
        Assertions.assertTrue(result);
        result = omnivore.canEat(EFoodType.VEGETABLE);
        Assertions.assertTrue(result);
        result = omnivore.canEat(EFoodType.NOTFOOD);
        Assertions.assertFalse(result);
    }

    @Test
    void testEat() {
        Animal bear = new Bear("b");
        Animal elephant = new Elephant("elep");
        Cabbage cabbage = new Cabbage();
        bear.setWeight(100);
        double result = omnivore.eat(bear, elephant);
        Assertions.assertEquals(10, result);
        result = omnivore.eat(elephant,bear);
        Assertions.assertEquals(0,result);
        bear.setWeight(100);
        result = omnivore.eat(bear,cabbage);
        Assertions.assertEquals((7/100.0)*100, result);

    }

    @Test
    void testReplicate() {
        Omnivore result = omnivore.replicate();
        Assertions.assertNotSame(new Omnivore(), result);
    }

    @Test
    void testToString() {
        String result = omnivore.toString();
        Assertions.assertEquals("Omnivore", result);
    }
}

