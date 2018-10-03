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
    private MyPoint myPointMock;

    @TestSubject
    private MyPoint myPointTest;

    Random randomX, randomY;

    @Before
    public void setUp() {
        myPointMock = mock(MyPoint.class);
        myPointTest = new MyPoint(myPointMock);
        randomX = new Random();
        randomY = new Random();
    }

    @After
    public void tearDown() {
        myPointMock = null;
        myPointTest = null;
    }

    @Test
    public void testSetPoint() {
        myPointMock.setPoint(randomX, randomY);
        replay(myPointMock);
        myPointTest.setPoint(randomX, randomY);
        verifyAll(); // 6
        assertEquals(myPointMock.getX(), myPointTest.getX(), 0.0001);
        assertEquals(myPointMock.getY(), myPointTest.getY(), 0.0001);
    }

}