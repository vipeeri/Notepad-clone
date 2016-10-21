package toiminnot;

import javax.swing.JTextArea;
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
        

        JTextPane f = new JTextPane();
        Boldaus instance = new Boldaus();
        
        f.setText("a");
        f.setSelectionStart(0);
        f.setSelectionEnd(1);
        
        instance.lihavoiTeksti(f);
        
        StyledDocument tyyli = (StyledDocument) f.getDocument();
        Element element = tyyli.getCharacterElement(0);
        AttributeSet aS = element.getAttributes();
   
        MutableAttributeSet uusiAs = new SimpleAttributeSet(aS.copyAttributes());

        assertTrue(StyleConstants.isBold(aS));

        
    }

}
