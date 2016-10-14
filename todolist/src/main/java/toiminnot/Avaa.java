package toiminnot;

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

public class Avaa extends JFrame {

    /**
     * Tällä luokalla voidaan avata valitsema tekstitiedosto
     *
     *@param avaaTiedosto rakentaa JTextPaneen Stringin tiedostossa olevasta tekstistä
     */
    public Avaa() {

    }

    public void avaaTiedosto(JTextPane alue) {

        StyledDocument tekstiP = alue.getStyledDocument();

        SimpleAttributeSet a = new SimpleAttributeSet();

        JFileChooser avaa = new JFileChooser();
        int valinta = avaa.showOpenDialog(this);
        alue.setText("");

        try {
            Scanner lukija = new Scanner(new FileReader(avaa.getSelectedFile().getPath()));
            while (lukija.hasNext()) {
                // alue.append(lukija.nextLine() + "\n");
                tekstiP.insertString(0, lukija.nextLine() + "\n", a);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
