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
 * Tällä luokalla voidaan tallentaa tuotettu teksti.
 *
 *
 */
public class Tallennus extends JFrame {

    private Boolean tallennettu;

    public Tallennus() {
        tallennettu = false;
    }

    /**
     * Metodilla voidaan tallentaa teksti käyttäjän haluamaan hakemistoon.
     *
     * @param teksti saadaan GUI:n JTextPanessa olevasta Stringistä
     * @throws IOException virhetilanteen käsittely
     */
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

    /**
     * Metodilla voidaan tallentaa teksti suoraan tiedostoon, mistä se on
     * avattu.
     *
     * @param teksti saadaan GUI:n JTextPanessa olevasta Stringistä
     * @param tiedostoNimi saadaan Avaa-luokasta
     * @throws IOException virhetilanteen käsittely
     *
     */
    public void tallenna(String teksti, String tiedostoNimi) throws IOException {

        FileWriter kirjoita = null;
        try {
            kirjoita = new FileWriter(tiedostoNimi, false);
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

    /**
     * Metodi kysyy ohjelmaa suljettaessa, haluaako käyttäjä tallentaa tehdyt
     * muutokset.
     *
     * @param teksti saadaan GUI:n JTextPanessa olevasta Stringistä
     * @param tiedostoNimi saadaan Avaa-luokasta
     * @throws IOException virhetilanteen käsittely
     *
     */
    public void tallennaVanha(String teksti, String tiedostoNimi) throws IOException {

        if (JOptionPane.showConfirmDialog(this, "Haluatko tallentaa " + " ?", "Tallenna", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (tiedostoNimi == null) {
                tallennaNimella(teksti);
                if (tallennettu == true) {
                    System.exit(0);
                }
            } else {
                tallenna(teksti, tiedostoNimi);
                if (tallennettu == true) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }

    }

    /**
     * Metodi käsittelee erilaisia tilanteita, joita ilmaantuu ohjelmaa
     * sulkiessa, ja valitsee sen mukaan tarvittavat toimenpiteet tekstin
     * tallennusta varten.
     *
     * @param p saadaan GUI:sta, ja metodissa tarkistellaan siinä olevaa tekstiä
     * @param tiedostoNimi saadaan Avaa-luokasta, ja metodissa tarkastellaan
     * onko se esim. tyhjä
     * @throws IOException virhetilanteen käsittely
     *
     */
    public void tarkistajaTallennaVanha(JTextPane p, String tiedostoNimi) throws IOException {
        if (p.getText().equals("") && tiedostoNimi == null) {
            System.exit(0);
        }
        if (tiedostoNimi == null) {
            tallennaVanha(p.getText(), tiedostoNimi);
        }
        String teksti = "";
        try {
            Scanner lukija = new Scanner(new FileReader(tiedostoNimi));
            while (lukija.hasNext()) {
                teksti += lukija.nextLine();
            }

        } catch (Exception e) {
            return;
        }

        if (!p.getText().equals(teksti)) {
            tallennaVanha(p.getText(), tiedostoNimi);
        } else {
            return;
        }
    }
}
