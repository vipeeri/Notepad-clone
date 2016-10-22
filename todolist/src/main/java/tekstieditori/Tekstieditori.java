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
import toiminnot.Alleviivaus;
import toiminnot.Avaa;
import toiminnot.Boldaus;
import toiminnot.Fontti;
import toiminnot.Tallennus;
import toiminnot.Teemat;

/**
 * Tekstieditori-luokasta annetaan käskyt toiminnot-paketissa oleviin luokkiin.
 *
 *
 */
public class Tekstieditori {

    private Tallennus tekstinTallennus = new Tallennus();
    private Boldaus lihavoi = new Boldaus();
    private Fontti fontti = new Fontti();
    private Teemat teema = new Teemat();
    private Avaa avaa = new Avaa();
    private Alleviivaus alleViivaa = new Alleviivaus();

    public Tekstieditori() {

    }

    public void tallennaTiedosto(String teksti) throws IOException {

        if (avaa.getAvattu() != null) {

            System.out.println(avaa.getAvattu());
            tekstinTallennus.tallenna(teksti, avaa.getAvattu());
        } else {
            tallennaNimellaTiedosto(teksti);
        }
    }

    public void tallennaNimellaTiedosto(String teksti) throws IOException {
        tekstinTallennus.tallennaNimella(teksti);
    }

    public void tallennaVanha(JTextPane p) throws IOException {
        tekstinTallennus.tarkistajaTallennaVanha(p, avaa.getAvattu());
    }

    public void avaa(JTextPane t) {
        avaa.avaaTiedosto(t);

    }

    public void tummaTeema(JTextPane j) {
        teema.tummaTeema(j);
    }

    public void punainenTeema(JTextPane j) {
        teema.punainenTeema(j);
    }

    public void lihavoiTeksti(JTextPane t) {
        lihavoi.lihavoiTeksti(t);
    }

    public void vaihdaFontti(JTextPane tekstiPane, String fonttiNimi) {
        if (fonttiNimi.equals("serif")) {
            fontti.vaihdaFonttiSerif(tekstiPane);
        } else if (fonttiNimi.equals("arial")) {
            fontti.vaihdaFonttiArial(tekstiPane);
        }
    }

    public void alleViivaa(JTextPane tekstiPane) {
        alleViivaa.alleviivaaTeksti(tekstiPane);
    }

}
