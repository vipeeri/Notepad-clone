package toiminnot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import tekstieditori.Tekstieditori;

/**
 * Tällä luokalla voidaan avata valitsema tekstitiedosto.
 *
 *
 */
public class Avaa extends JFrame {

    /* ... */
    private String avattu;

    public Avaa() {
        avattu = null;
    }

    public String getAvattu() {
        return avattu;
    }

    /**
     * Metodi avaa tiedoston JTextPaneen.
     *
     * @param alue GUI:sta tuleva JTextPane
     *
     *
     */
    public void avaaTiedosto(JTextPane alue) {

        StyledDocument tekstiP = alue.getStyledDocument();

        SimpleAttributeSet a = new SimpleAttributeSet();

        JFileChooser avaa = new JFileChooser();
        int valinta = avaa.showOpenDialog(this);
        alue.setText("");

        try {
            Scanner lukija = new Scanner(new FileReader(avaa.getSelectedFile().getPath()));
            String teksti = "";
            while (lukija.hasNext()) {
                teksti = teksti + lukija.nextLine() + "\n";
            }
            tekstiP.insertString(0, teksti, a);
            avattu = avaa.getSelectedFile().getPath();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
