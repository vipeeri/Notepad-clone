package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import tekstieditori.Tekstieditori;
import toiminnot.Tallennus;
import toiminnot.Teemat;

public class Gui extends JFrame implements ActionListener {

    private JTextArea tekstiAlue;
    private int laskuri;
    private JMenuBar menuPalkki;
    private JMenu tiedostoMenu;
    private JMenu muokkaaMenu;
    private JMenu muotoileMenu;
    private JMenuItem tallennaOsa;
    private JMenuItem boldaus;
    private JMenuItem fontti;
    private JMenuItem serifFontti;
    private JMenuItem arialFontti;
    private JMenu teema;
    private JMenuItem vihreaTeema;
    private JScrollPane scpane;
    private String alkuTxt;
    private JToolBar toolBar;
    private Tekstieditori tEditori = new Tekstieditori();
    private Teemat teemat = new Teemat();

    public Gui() {

        super("Tekstieditori - harjoitustyö");

        /**
         * GUI-luokka tarjoaa nimensä mukaan graafisen käyttöliittymän
         * tekstieditorille
         *
         * Asetetaan alkuun editorin koko ja layout
         *
         */
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        /**
         *
         * Luodaan menuvalikot
         *
         */
        laskuri = 0;
        alkuTxt = " ";
        //menu-palkki
        menuPalkki = new JMenuBar();
        //JMenut
        tiedostoMenu = new JMenu("Tiedosto"); //tiedosto menu-palkkiin
        muokkaaMenu = new JMenu("Muokkaa");
        muotoileMenu = new JMenu("Muotoile");
        teema = new JMenu("Teema");
        //Teemat JMenuun

        vihreaTeema = new JMenuItem("Vihrea");
        //Tallennus tiedosto JMenuun
        tallennaOsa = new JMenuItem("Tallenna"); //tiedosto
        //Lihavointi ja fontit muotoile submenuun
        boldaus = new JMenuItem("Lihavoi"); //muotoile
        fontti = new JMenu("Fontti"); //muotoile
        serifFontti = new JMenuItem("Serif"); //submenu muotoile-fontti
        arialFontti = new JMenuItem("Arial"); //submenu muotoile-fontti
        //tekstialue
        tekstiAlue = new JTextArea();
        //lisätään tekstialue scrollpaneen
        scpane = new JScrollPane(tekstiAlue);
        toolBar = new JToolBar();

        tekstiAlue.setLineWrap(true);
        tekstiAlue.setWrapStyleWord(true);
        
        /**
         *
         * Ladataan koira.txt textAreaan
         *
         */
        
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader("koira.txt"));
            String tekstit;
            while ((tekstit = buff.readLine()) != null) {
                tekstiAlue.append("" + tekstit);
            }
        } catch (IOException e) {
        } finally {
            try {
                in.close();
            } catch (Exception ex) {
            }
        }

        //Luodaan editorin menu-palkki
        setJMenuBar(menuPalkki);

        //valikot menu-palkkiin
        menuPalkki.add(tiedostoMenu);
        menuPalkki.add(muokkaaMenu);
        menuPalkki.add(muotoileMenu);

        //Tiedosto-valikkoon tallenna 
        tiedostoMenu.add(tallennaOsa);
        //Muotoile-valikkoon lihavointi ja fontti
        muotoileMenu.add(boldaus);
        muotoileMenu.add(fontti);
        muotoileMenu.add(teema);
        //Fontti
        teema.add(vihreaTeema);

        fontti.add(serifFontti);
        fontti.add(arialFontti);
        //Muokkaa valikkoon tulossa leikkaa/liitä

        pane.add(scpane, BorderLayout.CENTER);
        pane.add(toolBar, BorderLayout.SOUTH);

        //näppäinkomennot tähän, leikkaa liitä kopio
        //kuuntelijat 1. tallenna 2. avaa jnejne
        tallennaOsa.addActionListener(this);
        boldaus.addActionListener(this);
        serifFontti.addActionListener(this);
        arialFontti.addActionListener(this);

        setVisible(true);
    }

    public String getTekstiAlue() {
        return tekstiAlue.getText();
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem choice = (JMenuItem) e.getSource();
        if (choice == tallennaOsa) {

            try {
                tEditori.kirjoitaTiedosto(tekstiAlue.getText());
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (choice == boldaus) {
            tEditori.lihavoiTeksti(tekstiAlue);
        }
        if (choice == arialFontti) {
            tEditori.vaihdaFontti(tekstiAlue, "arial");
        }
        if (choice == serifFontti) {
            tEditori.vaihdaFontti(tekstiAlue, "serif");
        }
        if (choice == vihreaTeema) {
            tEditori.vaihdaTeema(menuPalkki, "vihrea");
        }
    }
}
