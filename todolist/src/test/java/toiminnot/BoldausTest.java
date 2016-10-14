package toiminnot;

import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoldausTest {

    public BoldausTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of vaihdaFontti method, of class Boldaus.
     */
    @Test
    public void testVaihdaFontti() {

        JTextArea f = new JTextArea();
        Boldaus instance = new Boldaus();

        assertTrue(instance.vaihdaFontti(f));

        
    }

}
