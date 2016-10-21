/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
public class AlleviivausTest {

    public AlleviivausTest() {
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
     * Test of alleviivaaTeksti method, of class Alleviivaus.
     */
    @Test
    public void testAlleviivaaTeksti() {
        JTextPane f = new JTextPane();
        Alleviivaus instance = new Alleviivaus();

        f.setText("a");
        f.setSelectionStart(0);
        f.setSelectionEnd(1);

        instance.alleviivaaTeksti(f);

        StyledDocument tyyli = (StyledDocument) f.getDocument();
        Element element = tyyli.getCharacterElement(0);
        AttributeSet aS = element.getAttributes();

        MutableAttributeSet uusiAs = new SimpleAttributeSet(aS.copyAttributes());

        assertTrue(StyleConstants.isUnderline(aS));

    }
}
