/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import javax.swing.JTextPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vipe
 */
public class RivinumerotTest {

    public RivinumerotTest() {
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
     * Test of paivitaRiviNumerot method, of class Rivinumerot.
     */
    @Test
    public void testPaivitaRiviNumerot() {

        JTextPane jpane = new JTextPane();
        jpane.setText("jee");
        Rivinumerot rivinumero = new Rivinumerot(jpane);

        assertTrue(rivinumero.getRiviNumeroTeksti().contains("1"));

    }

}
