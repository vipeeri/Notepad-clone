package toiminnot;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;

/**
 * Tämä luokka lisää editoriin rivinumerot
 *
 * @param paivitaRiviNumerot päivittää numerot tekstikenttään
 * @param getRiviNumeroTeksti appendaa rivinumeron riippuen millä rivillä ollaan
 *
 */

public class Rivinumerot extends JTextPane {

    private JTextPane tekstiPane;

    public Rivinumerot(JTextPane textPane) {
        this.tekstiPane = textPane;
        setBackground(Color.LIGHT_GRAY);
        setEditable(false);
    }

    public void paivitaRiviNumerot() {
        String riviNumeroTeksti = getRiviNumeroTeksti();
        setText(riviNumeroTeksti);
    }

    public String getRiviNumeroTeksti() {

        int caretPosition = tekstiPane.getDocument().getLength();
        Element root = tekstiPane.getDocument().getDefaultRootElement();
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(System.lineSeparator());

        for (int elementIndex = 2; elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++) {
            sb.append(elementIndex).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
