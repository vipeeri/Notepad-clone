package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;

/**
 * Tällä luokalla voidaan vaihtaa JTextArean tekstin fonttia
 *
 *
 */
public class Fontti {

    public Fontti() {

    }

    public void vaihdaFonttiArial(JTextArea f) {
        f.setFont(new Font("Arial", 0, 14));
    }

    public void vaihdaFonttiSerif(JTextArea f) {
        f.setFont(new Font("Serif", 0, 14));
    }

}
