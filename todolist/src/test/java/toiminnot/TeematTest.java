/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import java.awt.Color;
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
public class TeematTest {
    
    public TeematTest() {
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
     * Test of punainenTeema method, of class Teemat.
     */
    @Test
    public void testPunainenTeema() {
        
        JTextPane tekstiPane = new JTextPane();
        Teemat instance = new Teemat();
        instance.punainenTeema(tekstiPane);
       
        assertTrue(tekstiPane.getBackground() == Color.red);
            
        
    }

    /**
     * Test of tummaTeema method, of class Teemat.
     */
    @Test
    public void testTummaTeema() {
        JTextPane tekstiPane = new JTextPane();
        Teemat instance = new Teemat();
        instance.tummaTeema(tekstiPane);
       
        assertTrue(tekstiPane.getBackground() == Color.black);
    }
    
}
