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
 * Tällä luokalla voidaan tallentaa tuotettu teksti käyttäjän haluamaan
 * sijaintiin
 *
 * @param tallennaNimella tallentaa tiedoston käyttäjän haluamaan hakemistoon
 * @param tallenna tallentaa tiedoston siihen mistä se on avattu
 * @param tallennaVanha kysyy käyttäjältä tallennetaanko tiedostoa jos käyttäjä
 * sulkee ohjelman tallentamatta
 */
public class Tallennus extends JFrame {

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
            System.out.println("Ei vielä toimintoa");
        }
    }
}
