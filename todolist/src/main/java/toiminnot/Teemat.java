package toiminnot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

/**
 * Teemat luokalla voidaan vaihtaa JTextPanen ja siinä olevan tekstin väriä.
 *
 *
 */
public class Teemat {

    public void teemat() {

    }

    /**
     * Metodilla voidaan vaihtaa teema punaiseksi.
     *
     * @param tekstiPane saadaan GUI:sta, joka taas vaihdetaan punaiseksi
     *
     *
     */
    public void punainenTeema(JTextPane tekstiPane) {
        tekstiPane.setBackground(Color.red);
        tekstiPane.setForeground(Color.white);
    }

    /**
     * Metodilla voidaan vaihtaa teema tummaksi.
     *
     * @param tekstiPane saadaan GUI:sta, joka taas vaihdetaan mustaksi.
     *
     *
     */
    public void tummaTeema(JTextPane tekstiPane) {
        tekstiPane.setBackground(Color.black);
        tekstiPane.setForeground(Color.white);
    }

}
