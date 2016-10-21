/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
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
public class TallennusTest {

    public TallennusTest() {
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
     * Test of tallenna method, of class Tallennus.
     */
    @Test
    public void testTallenna() throws Exception {

        Scanner lukija = new Scanner(System.in);

        Tallennus instance = new Tallennus();
        String teksti = "testi";
        String kokoTeksti = "";
        String uusiTiedosto = "testi.txt";
        File tiedosto = new File(uusiTiedosto);

        instance.tallenna(teksti, uusiTiedosto);

        lukija = new Scanner(tiedosto);

        while (lukija.hasNext()) {
            kokoTeksti += lukija.nextLine();
            System.out.println(kokoTeksti);
        }

        assertEquals(kokoTeksti, teksti);

    }

}
