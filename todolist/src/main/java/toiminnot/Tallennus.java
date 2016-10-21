package toiminnot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 * Tällä luokalla voidaan tallentaa tuotettu teksti käyttäjän haluamaan
 * sijaintiin
 *
 * @param tallennaNimella tallentaa tiedoston käyttäjän haluamaan hakemistoon
 * @param tallenna tallentaa tiedoston siihen mistä se on avattu
 * @param tarkistajaTallennaVanha hoitaa mahdolliset virhetilanteet ennenkuin kutsuu tallennaVanha-metodia
 * @param tallennaVanha kysyy käyttäjältä tallennetaanko tiedostoa jos käyttäjä
 * sulkee ohjelman tallentamatta
 */
public class Tallennus extends JFrame {

    private Boolean tallennettu;
    
    public Tallennus() {
        tallennettu = false;
    }

    public void tallennaNimella(String teksti) throws IOException {
        JFileChooser save = new JFileChooser();
        int option = save.showSaveDialog(this);

        FileWriter kirjoita = null;

        if (option == JFileChooser.CANCEL_OPTION) {
            save.cancelSelection();
        } else {
            try {
                kirjoita = new FileWriter(save.getSelectedFile(), false);
                kirjoita.write(teksti);
                tallennettu = true;
            } catch (IOException ex) {

                ex.printStackTrace();
            } finally {
                if (kirjoita != null) {
                    kirjoita.close();
                }
            }
        }
    }

    public void tallenna(String teksti, String tiedosto) throws IOException {

        FileWriter kirjoita = null;
        try {
            kirjoita = new FileWriter(tiedosto, false);
            kirjoita.write(teksti);
            tallennettu = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (kirjoita != null) {
                kirjoita.close();
            }
        }
    }

    public void tallennaVanha(String t, String tiedosto) throws IOException {

        if (JOptionPane.showConfirmDialog(this, "Haluatko tallentaa " + " ?", "Tallenna", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (tiedosto == null) {
                tallennaNimella(t);
                if (tallennettu == true) {
                    System.exit(0);
                }
            } else {
                tallenna(t, tiedosto);
                if (tallennettu == true) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }

    }

    public void tarkistajaTallennaVanha(JTextPane p, String path) throws IOException {
        if (p.getText().equals("") && path == null) {
            System.exit(0);
        }
        if (path == null) {
            tallennaVanha(p.getText(), path);
        }
        String teksti = "";
        try {
            Scanner lukija = new Scanner(new FileReader(path));
            while (lukija.hasNext()) {
                teksti += lukija.nextLine();
            }

        } catch (Exception e) {
            return;
        }

        if (!p.getText().equals(teksti)) {
            tallennaVanha(p.getText(), path);
        } else {
            return;
        }
    }
}
