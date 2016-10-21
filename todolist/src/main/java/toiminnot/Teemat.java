package toiminnot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

/**
 * Teemat luokalla voidaan vaihtaa JTextPanen ja siinä olevan tekstin väriä
 *
 * @param punainenTeema vaihtaa backgroundin punaiseksi ja tekstin valkoiseksi
 * @param tummaTeema vaihtaa backgroundin mustaksi ja tekstin valkoiseksi
 *
 */
public class Teemat {

    public void teemat() {

    }

    public void punainenTeema(JTextPane tekstiPane) {
        tekstiPane.setBackground(Color.red);
        tekstiPane.setForeground(Color.white);
    }

    public void tummaTeema(JTextPane tekstiPane) {
        tekstiPane.setBackground(Color.black);
        tekstiPane.setForeground(Color.white);
    }

}
