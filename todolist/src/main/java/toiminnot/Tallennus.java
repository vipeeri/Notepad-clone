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

/**
 * Tällä luokalla voidaan tallentaa tuotettu teksti haluamaan sijaintiin
 *
 *
 */
public class Tallennus extends JFrame {

    //Tallenna nimellä
    public void tallennaNimella() {
        JFileChooser save = new JFileChooser();
        int option = save.showSaveDialog(this);
    }

    // Tallenna -- path
    public void tallenna(String teksti) throws IOException {

        FileWriter kirjoita = null;
        try {
            kirjoita = new FileWriter("koira.txt", false);
            kirjoita.write(teksti);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (kirjoita != null) {
                kirjoita.close();
            }
        }
//        try (
//                final BufferedWriter kirjoittaja = Files.newBufferedWriter(polku,
//                        StandardCharsets.UTF_8,
//                        StandardOpenOption.CREATE,
//                        StandardOpenOption.APPEND)) {
//            kirjoittaja.write(teksti);
//            kirjoittaja.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }

    }

}
