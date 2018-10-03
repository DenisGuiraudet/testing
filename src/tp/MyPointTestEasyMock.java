package tp;

import org.easymock.samples.ClassTested;
import org.easymock.samples.Collaborator;
import org.junit.*;
import static org.junit.Assert.*;

import org.easymock.*;
import static org.easymock.EasyMock.*;

import java.util.Random;

public class MyPointTestEasyMock extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator collaborator; // 1

    @TestSubject
    private ClassTested classUnderTest = new ClassTested(); // 2

    @Test
    public void addDocument() {
        collaborator.documentAdded("New Mock"); // 3
        replayAll(); // 4
        classUnderTest.addDocument("New Mock", "content"); // 5
        verifyAll(); // 6
    }

    private MyPoint myPointEmpty;

    @Before
    public void setUp() {
        myPointEmpty = new MyPoint();
    }

    @After
    public void tearDown() {
        myPointEmpty = null;
    }

    @Test
    public void testSetPoint() {
        replayAll(); // 4
        Random randomX = new Random();
        Random randomY = new Random();
        myPointEmpty.setPoint(randomX, randomY);
        assertEquals(myPointEmpty.getX(), myPointEmpty.getX(), 0.0001);
        assertEquals(myPointEmpty.getY(), myPointEmpty.getY(), 0.0001);
        verifyAll(); // 6
    }

}