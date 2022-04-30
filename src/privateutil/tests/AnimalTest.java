package privateutil.tests;

import animals.*;
import food.EFoodType;
import mobility.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AnimalTest {


    @Test
    void testSetWeight() {
        Animal animal = new Bear("b");
        boolean result = animal.setWeight(-1);
        Assertions.assertFalse(result);
        result = animal.setWeight(1);
        Assertions.assertTrue(result);
    }

    @Test
    void testGetName() {
        Animal animal = new Bear("b");
        String result = animal.getName();
        Assertions.assertEquals("b", result);
    }

    @Test
    void testGetWeight() {
        Animal animal = new Bear("b");
        animal.setWeight(8);
        double result = animal.getWeight();
        Assertions.assertEquals(8, result);
    }

    @Test
    void testGetDiet() {
        Animal animal = new Bear("b");
        String result = animal.getDiet().toString();
        Assertions.assertEquals("Omnivore", result);
    }

    @Test
    void testGetFoodtype() {
        Animal animal = new Bear("b");
        EFoodType result = animal.getFoodtype();
        Assertions.assertEquals(EFoodType.MEAT, result);
    }

    @Test
    void testMove() {
        Animal animal = new Bear("b");
        animal.setLocation(new Point(0,0));
        animal.setWeight(100);
        double result = animal.move(new Point(10, 0));
        Assertions.assertEquals(10, result);
        Assertions.assertEquals(100-(result*100*0.00025),animal.getWeight());
    }

    @Test
    void testEat() {
        Animal animal = new Giraffe("b");
        boolean result = animal.eat(new Elephant("e"));
        Assertions.assertFalse(result);
        animal = new Lion("l");
        result = animal.eat(new Elephant("e"));
        Assertions.assertTrue(result);
    }

    @Test
    void testToString() {
        Animal animal = new Turtle("t");
        String result = animal.toString();
        Assertions.assertEquals("[Turtle]: t", result);
    }

    @Test
    void testSetLocation() {
        Animal animal = new Turtle("t");
        boolean result = animal.setLocation(new Point(1, -1));
        Assertions.assertFalse(result);
        result = animal.setLocation(new Point(2,3));
        Assertions.assertTrue(result);
    }

    @Test
    void testSetTotalDistance() {
        Animal animal = new Turtle("t");
        boolean result = animal.setTotalDistance(100);
        Assertions.assertTrue(result);
        Assertions.assertEquals(100,animal.getTotalDistance());
    }

    @Test
    void testAddTotalDistance() {
        Animal animal = new Turtle("t");
        animal.setTotalDistance(20);
        animal.addTotalDistance(2);
        Assertions.assertEquals(22,animal.getTotalDistance());
    }

    @Test
    void testCalcDistance() {
        Animal animal = new Bear("b");
        animal.setLocation(new Point(0,0));
        double result = animal.calcDistance(new Point(0, 10));
        Assertions.assertEquals(10, result);
    }
}

