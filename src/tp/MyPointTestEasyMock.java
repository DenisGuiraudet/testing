package tp;

import org.junit.*;
import static org.junit.Assert.*;

import org.easymock.*;
import static org.easymock.EasyMock.*;

import java.util.Random;

public class MyPointTestEasyMock extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private MyPoint myPointEmpty, myPointFilled;

    @Before
    void setUp() {
        myPointEmpty = new MyPoint();
        myPointFilled = new MyPoint(11.1, 12.2);
    }

    @After
    void tearDown() {
    }

    @Test
    void testSetPoint() {
        Random randomX = new Random();
        Random randomY = new Random();
        myPointEmpty.setPoint(randomX, randomY);
        assertEquals(randomX.nextDouble(), myPointEmpty.getX(), 0.0001);
        assertEquals(randomY.nextDouble(), myPointEmpty.getY(), 0.0001);
    }

}