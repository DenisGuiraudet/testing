package tp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MyPointTestMockito {

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
        assertEquals(0d, myPointEmpty.getX(), 0.0001);
        assertEquals(0d, myPointEmpty.getY(), 0.0001);
    }

    @Test
    void testGetFilled() {
        assertEquals(11.1, myPointFilled.getX(), 0.0001);
        assertEquals( 12.2, myPointFilled.getY(), 0.0001);
    }

    @Test
    void testSetGetX() {
        myPointEmpty.setX(13.3);
        assertEquals(13.3, myPointEmpty.getX(), 0.0001);
    }

    @Test
    void testSetGetY() {
        myPointEmpty.setY(14.4);
        assertEquals(14.4, myPointEmpty.getY(), 0.0001);
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
                myNewPoint.getX(), 0.0001);
        assertEquals(myPointFilled.getY() * factor,
                myNewPoint.getY(), 0.0001);
    }

    @Test
    void testHorizontalSymmetry() {
        MyPoint myNewPoint = myPointFilled.horizontalSymmetry(myPointEmpty);
        assertEquals((myPointFilled.getX() + myPointEmpty.getX()) / 2,
                myNewPoint.getX(), 0.0001);
    }

    @Test
    void testCentralSymmetryNULL () {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    MyPoint myNewPoint = new MyPoint(10, 20).centralSymmetry(null);
                });
        ;
    }

    @Test
    void testSetPoint() {
        Random mockService = mock(Random.class);
        Random mockService2 = mock(Random.class);
        when(mockService.nextInt()).thenReturn(2);
        when(mockService2.nextInt()).thenReturn(4);
        MyPoint point = new MyPoint(2,2);
        point.setPoint(mockService,mockService2);
        assertEquals(2,point.getX());
        assertEquals(4,point.getY());
    }

    @Test
    void testSetPointZero() {
        Random mockService = mock(Random.class);
        Random mockService2 = mock(Random.class);
        when(mockService.nextInt()).thenReturn(0);
        when(mockService2.nextInt()).thenReturn(0);
        MyPoint point = new MyPoint(2,2);
        point.setPoint(mockService,mockService2);
        assertEquals(0,point.getX());
        assertEquals(0,point.getY());
    }

}