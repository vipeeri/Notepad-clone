package toiminnot;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Alleviivaus {

    /**
     * Tällä luokalla voidaan avata valitsema tekstitiedosto.
     *
     *
     *
     *
     */
    public Alleviivaus() {

    }

    /**
     * Metodi alleviivaa käyttäjän valitseman tekstin.
     *
     * @param t JTextPane, joka saadaan GUI:sta, josta teksti valitaan
     */
    public void alleviivaaTeksti(JTextPane t) {

        int alku = t.getSelectionStart();
        int loppu = t.getSelectionEnd();

        if (alku == loppu) {
            return;
        }
        StyledDocument tyyli = (StyledDocument) t.getDocument();
        Element element = tyyli.getCharacterElement(alku);
        AttributeSet aS = element.getAttributes();

        MutableAttributeSet uusiAs = new SimpleAttributeSet(aS.copyAttributes());
        StyleConstants.setUnderline(uusiAs, !StyleConstants.isUnderline(aS));
        tyyli.setCharacterAttributes(alku, t.getSelectedText().length(), uusiAs, true);

    }

}
