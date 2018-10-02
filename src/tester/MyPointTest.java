package tester;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MyPointTest {

    private MyPoint myPointEmpty, myPointFilled;

    @BeforeEach
    void setUp() {
        myPointEmpty = new MyPoint();
        myPointFilled = new MyPoint(11.1, 12.2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetEmpty() {
        assertEquals(0d, myPointEmpty.getX());
        assertEquals(0d, myPointEmpty.getY());
    }

    @Test
    void testGetFilled() {
        assertEquals(11.1, myPointFilled.getX());
        assertEquals( 12.2, myPointFilled.getY());
    }

    @Test
    void testSetGetX() {
        myPointEmpty.setX(13.3);
        assertEquals(13.3, myPointEmpty.getX());
    }

    @Test
    void testSetGetY() {
        myPointEmpty.setY(14.4);
        assertEquals(14.4, myPointEmpty.getY());
    }

    @Test
    void testDoubleNaN() {
        myPointEmpty.setX(Double.NaN);
        assertNotEquals(Double.NaN, myPointEmpty.getX());
    }

    @Test
    void testScale() {
        int factor = 7;
        MyPoint myNewPoint = myPointFilled.scale(factor);
        assertEquals(myPointFilled.getX() * factor,
                myNewPoint.getX());
        assertEquals(myPointFilled.getY() * factor,
                myNewPoint.getY());
    }

    @Test
    void testHorizontalSymmetry() {
        MyPoint myNewPoint = myPointFilled.horizontalSymmetry(myPointEmpty);
        assertEquals((myPointFilled.getX() + myPointEmpty.getX()) / 2,
                myNewPoint.getX());
    }

    @Test
    void testCentralSymmetryNULL () {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    MyPoint myNewPoint = new MyPoint(10, 20).centralSymmetry(null);
                });
        ;
    }

}