package privateutil.tests;

import animals.Lion;
import mobility.Mobile;
import mobility.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MobileTest {


    @Test
    void testSetLocation() {
        Mobile mobile = new Lion("lili");
        boolean result = mobile.setLocation(new Point(5, 4));
        Assertions.assertTrue(result);
        double x = mobile.getLocation().getX();
        double y = mobile.getLocation().getY();
        Assertions.assertEquals(5,x);
        Assertions.assertEquals(4,y);

    }

    @Test
    void testSetTotalDistance() {
        Mobile mobile = new Lion("lili");
        boolean result = mobile.setTotalDistance(7);
        double t= mobile.getTotalDistance();
        Assertions.assertTrue(result);
        Assertions.assertEquals(7,t);
    }

    @Test
    void testAddTotalDistance() {
        Mobile mobile = new Lion("lili");
        mobile.setTotalDistance(10);
        mobile.addTotalDistance(2);
        Assertions.assertEquals(12,mobile.getTotalDistance());
    }

    @Test
    void testCalcDistance() {
        Mobile mobile = new Lion("lili");
        mobile.setLocation(new Point(0,10));
        double result = mobile.calcDistance(new Point(0, 5));
        Assertions.assertEquals(5, result);
    }

   @Test
   void testMove() {
       Mobile mobile = new Lion("lili");
       mobile.setLocation(new Point(0,10));
       double result = mobile.move(new Point(0, 0));
       double x = mobile.getLocation().getX();
       double y = mobile.getLocation().getY();
       Assertions.assertEquals(10, result);
       Assertions.assertEquals(0,x);
       Assertions.assertEquals(0,y);
   }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme