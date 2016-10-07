package toiminnot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Tällä luokalla voidaan tallentaa tuotettu teksti haluamaan sijaintiin
 *
 *
 */
public class Tallennus extends JFrame {

    //Tallenna nimellä
    public void tallennaNimella(String teksti) throws IOException {
        JFileChooser save = new JFileChooser();
        int option = save.showSaveDialog(this);

        FileWriter kirjoita = null;
        try {
            kirjoita = new FileWriter(save.getSelectedFile(), false);
            kirjoita.write(teksti);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (kirjoita != null) {
                kirjoita.close();
            }
        }
    }

    // Tallenna -- path
    public void tallenna(String teksti, String tiedosto) throws IOException {

        FileWriter kirjoita = null;
        try {
            kirjoita = new FileWriter(tiedosto, false);
            kirjoita.write(teksti);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (kirjoita != null) {
                kirjoita.close();
            }
        }
    }

    private void tallennaVanha() {

        if (JOptionPane.showConfirmDialog(this, "Haluatko tallentaa " + " ?", "Tallenna", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

        }

    }
}
