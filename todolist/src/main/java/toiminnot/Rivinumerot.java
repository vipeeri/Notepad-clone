package toiminnot;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;

/**
 * Tämä luokka lisää editoriin rivinumerot.
 *
 *
 */
public class Rivinumerot extends JTextPane {

    private JTextPane tekstiPane;

    /**
     * Metodi lisää oman JTextPanen rivinumeroille ohjelmiston vasempaan reunaan
     *
     * @param textPane saadaan GUI:sta
     *
     *
     */
    public Rivinumerot(JTextPane textPane) {
        this.tekstiPane = textPane;
        setBackground(Color.LIGHT_GRAY);
        setEditable(false);
    }

    /**
     * Metodi päivittää rivinumerot.
     *
     *
     */
    public void paivitaRiviNumerot() {
        String riviNumeroTeksti = getRiviNumeroTeksti();
        setText(riviNumeroTeksti);
    }

    /**
     * Metodi tarkistaa mikä on oikea rivinumero, joka sitten palautetaan
     * stringinä.
     *
     * @return palauttaa rivinumeron JTextPaneen
     *
     */
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
