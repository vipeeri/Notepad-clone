package toiminnot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Avaa extends JFrame {

    /**
     * Tällä luokalla voidaan avata valitsema tekstitiedosto
     *
     *
     */
    public Avaa() {

    }

    public void avaaTiedosto(JTextArea alue) {

        JFileChooser avaa = new JFileChooser();
        int valinta = avaa.showOpenDialog(this);
        alue.setText("");

        try {
            Scanner lukija = new Scanner(new FileReader(avaa.getSelectedFile().getPath()));
            while (lukija.hasNext()) {
                alue.append(lukija.nextLine() + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
