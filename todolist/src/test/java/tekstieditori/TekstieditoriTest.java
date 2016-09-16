package tekstieditori;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TekstieditoriTest {

    public TekstieditoriTest() {
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

    @Test
    public void lueTiedostonTesti() {

        String expected = "koira";
        Tekstieditori teksti = new Tekstieditori();
        String result = teksti.lueTiedosto();
        assertEquals(expected, result);
    }
    
    @Test
    public void tyhjennaTiedostoTesti() throws FileNotFoundException {
        Tekstieditori teksti = new Tekstieditori();
        teksti.tyhjennaTiedosto("D:\\", "kissa.txt");
        
        
        String expected = "";
        String result = teksti.lueTiedosto();
        assertEquals(expected, result);
    }
//
//    @Test
//    public void getSijainti() {
//        Tekstieditori teksti = new Tekstieditori();
//        String expected = "D:\\";
//        assertEquals(expected, teksti.getSijainti());
//
//    }

//    @Test
//    public void getNimi() {
//        Tekstieditori teksti = new Tekstieditori();
//        String expected = "kissa.txt";
//        assertEquals(expected, teksti.getNimi());
//    }

    /**
     * Test of aloita method, of class Tekstieditori.
     */
//    @Test
//    public void testAloita() throws Exception {
//        System.out.println("aloita");
//        Tekstieditori instance = new Tekstieditori();
//        instance.aloita();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of kirjoitaTiedosto method, of class Tekstieditori.
//     */
//    @Test
//    public void testKirjoitaTiedosto() throws Exception {
//        System.out.println("kirjoitaTiedosto");
//        Tekstieditori instance = new Tekstieditori();
//        instance.kirjoitaTiedosto();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of tyhjennaTiedosto method, of class Tekstieditori.
//     */
//    @Test
//    public void testTyhjennaTiedosto() throws Exception {
//        System.out.println("tyhjennaTiedosto");
//        String sijainti = "";
//        String nimi = "";
//        Tekstieditori instance = new Tekstieditori();
//        instance.tyhjennaTiedosto(sijainti, nimi);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of poistaTiedosto method, of class Tekstieditori.
//     */
//    @Test
//    public void testPoistaTiedosto() {
//        System.out.println("poistaTiedosto");
//        Tekstieditori instance = new Tekstieditori();
//        instance.poistaTiedosto();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of lueTiedosto method, of class Tekstieditori.
//     */
//    @Test
//    public void testRead() {
//        System.out.println("lueTiedosto");
//        String fileName = "";
//        String expResult = "";
//        String result = Tekstieditori.lueTiedosto(fileName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
