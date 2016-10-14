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
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;
import toiminnot.Avaa;
import toiminnot.Boldaus;
import toiminnot.Fontti;
import toiminnot.Tallennus;
import toiminnot.Teemat;

/**
 * Tekstieditori-luokasta annetaan käskyt toiminnot-paketissa oleviin luokkiin
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

    public void avaa(JTextPane t) {
        avaa.avaaTiedosto(t);
    }

    public void vaihdaTeema(JMenuBar j, String vari) {
        j.setBackground(Color.green);

    }

    public void lihavoiTeksti(StyledDocument t, int mark, int dot) {
        lihavoi.lihavoiTeksti(t, mark, dot);
    }

    public void vaihdaFontti(JTextArea tekstiAlue, String fonttiNimi) {
        if (fonttiNimi.equals("serif")) {
            fontti.vaihdaFonttiSerif(tekstiAlue);
        } else if (fonttiNimi.equals("arial")) {
            fontti.vaihdaFonttiArial(tekstiAlue);
        }
    }

}
