package privateutil.tests;

import mobility.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void testCheckBoundaries() {
        boolean result = Point.checkBoundaries(new Point(1000, 1000));
        Assertions.assertFalse(result);
        result = Point.checkBoundaries(new Point(5, 5));
        Assertions.assertTrue(true);
    }

    @Test
    void testReplicate() {
        Point point = new Point(2,2);
        Point clone = point.replicate();
        Assertions.assertNotSame(point, clone);
        Assertions.assertEquals(2,clone.getX());
        Assertions.assertEquals(2,clone.getY());

    }

}

