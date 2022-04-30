package privateutil.tests;

import animals.Bear;
import animals.Elephant;
import animals.Lion;
import food.EFoodType;
import mobility.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BearTest {

    @Test
    void testRoar() {
        Bear bear = new Bear("b");
        bear.roar();
        //TODO: complete this test
    }

    @Test
    void testMakeSound() {
        Bear bear = new Bear("b");
        bear.makeSound();
        //TODO: complete this test
    }

    @Test
    void testSetWeight() {
        Bear bear = new Bear("b");
        boolean result = bear.setWeight(-2);
        Assertions.assertFalse(result);
        result = bear.setWeight(3);
        Assertions.assertTrue(result);
    }

    @Test
    void testGetName() {
        Bear bear = new Bear("b");
        String result = bear.getName();
        Assertions.assertEquals("b", result);
    }

    @Test
    void testGetWeight() {
        Bear bear = new Bear("b");
        double result = bear.getWeight();
        Assertions.assertEquals(308.2, result);
    }

    @Test
    void testGetDiet() {
        Bear bear = new Bear("b");
        String result = bear.getDiet().toString();
        Assertions.assertEquals("Omnivore", result);
    }

    @Test
    void testGetFoodtype() {
        Bear bear = new Bear("b");
        EFoodType result = bear.getFoodtype();
        Assertions.assertEquals(EFoodType.MEAT, result);
    }

    @Test
    void testMove() {
        Bear bear = new Bear("b");
        bear.setLocation(new Point(20,0));
        double result = bear.move(new Point(0, 0));
        Assertions.assertEquals(20, bear.getTotalDistance());
        Assertions.assertEquals(0,bear.getLocation().getX());
        Assertions.assertEquals(0,bear.getLocation().getY());
        result = bear.move(new Point(-1,-1));
        Assertions.assertEquals(0,result);
        Assertions.assertEquals(20, bear.getTotalDistance());
        Assertions.assertEquals(0,bear.getLocation().getX());
        Assertions.assertEquals(0,bear.getLocation().getY());
    }

    @Test
    void testEat() {
        Bear bear = new Bear("b");
        boolean result = bear.eat(new Elephant("e"));
        Assertions.assertEquals(true, result);
        result = bear.eat(new Lion("l"));
        Assertions.assertEquals(false,result);
    }

    @Test
    void testToString() {
        Bear bear = new Bear("b");
        String result = bear.toString();
        Assertions.assertEquals("[Bear]: b", result);
    }

    @Test
    void testSetLocation() {
        Bear bear = new Bear("b");
        boolean result = bear.setLocation(new Point(0, 0));
        Assertions.assertTrue(result);

    }

    @Test
    void testSetTotalDistance() {
        Bear bear = new Bear("b");
        boolean result = bear.setTotalDistance(7);
        Assertions.assertTrue(result);
    }

    @Test
    void testAddTotalDistance() {
        Bear bear = new Bear("b");
        bear.addTotalDistance(-7);
        Assertions.assertEquals(0,bear.getTotalDistance());


    }

    @Test
    void testCalcDistance() {
        Bear bear = new Bear("b");
        bear.setLocation(new Point(0,0));
        double result = bear.calcDistance(new Point(7, 0));
        Assertions.assertEquals(7, result);
    }

    @Test
    void testMove2() {
        Bear bear = new Bear("b");
        double result = bear.move(new Point(-1, -1));
        Assertions.assertEquals(0, result);
    }
}

