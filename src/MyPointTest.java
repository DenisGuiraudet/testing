import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MyPointTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetEmpty() {
        MyPoint myPoint = new MyPoint();
        assertEquals(0d, myPoint.getX());
        assertEquals(0d, myPoint.getY());
    }

    @Test
    void testGetFilled() {
        MyPoint myPoint = new MyPoint(11.1, 12.2);
        assertEquals(11.1, myPoint.getX());
        assertEquals( 12.2, myPoint.getY());
    }

    @Test
    void testSetGetX() {
        MyPoint myPoint = new MyPoint();
        myPoint.setX(13.3);
        assertEquals(13.3, myPoint.getX());
    }

    @Test
    void testSetGetY() {
        MyPoint myPoint = new MyPoint();
        myPoint.setY(14.4);
        assertEquals(14.4, myPoint.getY());
    }
}