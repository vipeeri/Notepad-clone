package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Tällä luokalla voidaan vaihtaa tekstin fonttia.
 *
 *
 *
 */
public class Fontti {

    public Fontti() {

    }

    /**
     * Metodilla käyttäjä voi vaihtaa fontin Arialiksi.
     *
     * @param t JTextPane saadaan GUI:sta, ja jossa fontin vaihto näkyy
     *
     *
     */
    public void vaihdaFonttiArial(JTextPane t) {
        int alku = t.getSelectionStart();
        int loppu = t.getSelectionEnd();

        if (alku == loppu) {
            return;
        }
        StyledDocument tyyli = (StyledDocument) t.getDocument();
        Element element = tyyli.getCharacterElement(alku);
        AttributeSet aS = element.getAttributes();

        MutableAttributeSet uusiAs = new SimpleAttributeSet(aS.copyAttributes());
        StyleConstants.setFontFamily(uusiAs, "Arial");

        tyyli.setCharacterAttributes(alku, t.getSelectedText().length(), uusiAs, true);

    }

    /**
     * Metodilla käyttäjä voi vaihtaa fontin Serifiksi.
     *
     * @param t JTextPane saadaan GUI:sta, ja jossa fontin vaihto näkyy
     *
     *
     */

    public void vaihdaFonttiSerif(JTextPane t) {
        int alku = t.getSelectionStart();
        int loppu = t.getSelectionEnd();

        if (alku == loppu) {
            return;
        }
        StyledDocument tyyli = (StyledDocument) t.getDocument();
        Element element = tyyli.getCharacterElement(alku);
        AttributeSet aS = element.getAttributes();

        MutableAttributeSet uusiAs = new SimpleAttributeSet(aS.copyAttributes());
        StyleConstants.setFontFamily(uusiAs, "Serif");

        tyyli.setCharacterAttributes(alku, t.getSelectedText().length(), uusiAs, true);

    }

}
