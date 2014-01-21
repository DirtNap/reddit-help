package r.java;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestMovie {

    private String testName;
    private int testRunTime;
    private Movie testMovie;

    @Before
    public void setUp() {
        this.testName = "JUnit Test";
        this.testRunTime = 90;
        this.testMovie = new Movie(this.testName, this.testRunTime);
    }

    @Test
    public void testGetName() {
        assertEquals("Testing that 'name' was correctly set", this.testName,
                this.testMovie.getName());
    }

    @Test
    public void testChangeName() {
        String localTestName = "New Name";
        this.testMovie.changeName(localTestName);
        assertEquals("Testing that 'name' was correctly reset", localTestName,
                this.testMovie.getName());
    }

    @Test
    public void testGetRunTimne() {
        assertEquals("Testing that 'run time' was correctly set", this.testRunTime,
                this.testMovie.getRunTimne());
    }

    @Test
    public void testExtended() {
        int extension = 10;
        this.testMovie.extended(extension);
        assertEquals("Testing that time was extended", extension + this.testRunTime,
                this.testMovie.getRunTimne());
    }
}
