package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * Tällä luokalla voidaan vaihtaa teksti lihavoiduksi
 *
 * @param lihavoiTeksti lihavoi tekstin edellisen tyylin perusteella
 *
 *
 */
public class Boldaus {

    public Boldaus() {

    }

    public void lihavoiTeksti(JTextPane t) {

        int alku = t.getSelectionStart();
        int loppu = t.getSelectionEnd();

        if (alku == loppu) {
            return;
        }
        StyledDocument tyyli = (StyledDocument) t.getDocument();
        Element element = tyyli.getCharacterElement(alku);
        AttributeSet aS = element.getAttributes();

        MutableAttributeSet uusiAs = new SimpleAttributeSet(aS.copyAttributes());
        StyleConstants.setBold(uusiAs, !StyleConstants.isBold(aS));
        tyyli.setCharacterAttributes(alku, t.getSelectedText().length(), uusiAs, true);

    }

}
