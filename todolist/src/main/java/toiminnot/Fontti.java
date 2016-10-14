package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;

/**
 * Tällä luokalla voidaan vaihtaa JTextArean tekstin fonttia
 *@param vaihdaFonttiArial vaihtaa fontin Arialiksi
 * @param vaihdaFonttiSerif vaihtaa fontin Serifiksi
 *
 */
public class Fontti {

    public Fontti() {

    }

    public boolean vaihdaFonttiArial(JTextArea f) {
        f.setFont(new Font("Arial", 0, 14));
        return true;
    }

    public boolean vaihdaFonttiSerif(JTextArea f) {
        f.setFont(new Font("Serif", 0, 14));
        return true;
    }

}
