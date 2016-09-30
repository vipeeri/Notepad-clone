/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import javax.swing.JTextArea;
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
public class FonttiTest {
    
    public FonttiTest() {
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
     * Test of vaihdaFonttiArial method, of class Fontti.
     */
    @Test
    public void testVaihdaFonttiArial() {
        System.out.println("vaihdaFonttiArial");
        JTextArea f = null;
        Fontti instance = new Fontti();
        instance.vaihdaFonttiArial(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vaihdaFonttiSerif method, of class Fontti.
     */
    @Test
    public void testVaihdaFonttiSerif() {
        System.out.println("vaihdaFonttiSerif");
        JTextArea f = null;
        Fontti instance = new Fontti();
        instance.vaihdaFonttiSerif(f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
