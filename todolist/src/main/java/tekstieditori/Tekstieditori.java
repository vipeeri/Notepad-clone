package tekstieditori;

import gui.Gui;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import toiminnot.Avaa;
import toiminnot.Boldaus;
import toiminnot.Fontti;
import toiminnot.Tallennus;
import toiminnot.Teemat;

/**
 *Tekstieditori-luokasta annetaan käskyt toiminnot-paketissa oleviin luokkiin
 *
 *
 */

public class Tekstieditori {

    private String sijainti;
    private String nimi;
    private String teksti;
    private Tallennus tekstinTallennus = new Tallennus();
    private Boldaus lihavoi = new Boldaus();
    private Fontti fontti = new Fontti();
    private Teemat teema = new Teemat();
    private Avaa avaa = new Avaa();

    public Tekstieditori() {
        this.sijainti = "";
        this.nimi = "";
        this.teksti = "";

    }

    public void setSijainti(String sijainti) {
        this.sijainti = sijainti;
        
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getSijainti() {
        return this.sijainti;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void tallennaTiedosto(String teksti) throws IOException {
        //Käytetään Tallenus-luokan tallenna-metodia tekstin tallentamiseen
        tekstinTallennus.tallenna(teksti, this.nimi);
    }
    
    public void tallennaNimellaTiedosto(String teksti) throws IOException {
        tekstinTallennus.tallennaNimella(teksti);
        
    }
    
    public void avaa(JTextArea t) {
        avaa.avaaTiedosto(t);
    }

    public void vaihdaTeema(JMenuBar j, String vari) {
        j.setBackground(Color.green);

    }

    public void lihavoiTeksti(JTextArea t) {
        lihavoi.vaihdaFontti(t);
    }

    public void vaihdaFontti(JTextArea tekstiAlue, String fonttiNimi) {
        if (fonttiNimi.equals("serif")) {
            fontti.vaihdaFonttiSerif(tekstiAlue);
        } else if (fonttiNimi.equals("arial")) {
            fontti.vaihdaFonttiArial(tekstiAlue);
        }
    }

    //Metodilla voidaan tyhjentää olemassaoleva tekstitiedosto
    public void tyhjennaTiedosto(String sijainti, String nimi) throws FileNotFoundException {
        Path polku = Paths.get(sijainti, nimi);
        try (
                final BufferedWriter kirjoittaja = Files.newBufferedWriter(polku,
                        StandardCharsets.UTF_8)) {
            kirjoittaja.write("");
            kirjoittaja.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.nimi + " tyhjennetty.");
    }

    //Metodilla voidaan poistaa koko tekstitiedosto
    public void poistaTiedosto() {
        try {
            File file = new File(this.sijainti + this.nimi);

            if (file.delete()) {
                System.out.println(file.getName() + " poistettu.");
            } else {
                System.out.println("poisto ei onnistunut.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodilla luetaan tekstitiedosto
    public String lueTiedosto(String sijainti, String tiedosto) {

        String filePath = new File(sijainti).getAbsolutePath();

        StringBuilder tiedostonSisalto = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath + tiedosto));

            String kokoteksti;
            while ((kokoteksti = reader.readLine()) != null) {

                tiedostonSisalto.append(kokoteksti);
//                tiedostonSisalto.append("\n");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tiedostonSisalto.toString();
    }

}
