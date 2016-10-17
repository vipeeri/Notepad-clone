package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import tekstieditori.Tekstieditori;
import toiminnot.Tallennus;
import toiminnot.Teemat;
import toiminnot.Tekstinvalinta;

public class Gui extends JFrame implements ActionListener {

    private JTextPane tekstiPane;
    private JTextArea tekstiAlue;
    private StyledDocument styledDocument;
    private int laskuri;
    private JMenuBar menuPalkki;
    private JMenu tiedostoMenu, muokkaaMenu, muotoileMenu, teema;
    private JMenuItem tallennaOsa, tallennaNimella, avaaOsa, boldaus, fontti, serifFontti, arialFontti, vihreaTeema, kopioi,
            liita, leikkaa;
    private JScrollPane scpane;
    private String alkuTxt;
    private JToolBar toolBar;
    private Tekstieditori tEditori = new Tekstieditori();
    private Teemat teemat = new Teemat();
    private Tekstinvalinta tekstinValinta;

    public Gui() throws BadLocationException {

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
        //Tiedosto-menuun kuuluvat JMenuItemit
        avaaOsa = new JMenuItem("Avaa...");
        tallennaOsa = new JMenuItem("Tallenna");
        tallennaNimella = new JMenuItem("Tallenna nimellä...");
        //Lihavointi ja fontit muotoile submenuun
        boldaus = new JMenuItem("Lihavoi"); //muotoile
        fontti = new JMenu("Fontti"); //muotoile
        //Submenut Fontille:
        serifFontti = new JMenuItem("Serif");
        arialFontti = new JMenuItem("Arial");
        //tekstialue

        tekstinValinta = new Tekstinvalinta();
        this.styledDocument = new DefaultStyledDocument();
        tekstiPane = new JTextPane(styledDocument);
        tekstiPane.addCaretListener(tekstinValinta);

        //scpane = new JScrollPane(tekstiAlue);
        scpane = new JScrollPane(tekstiPane);
        toolBar = new JToolBar();

//        tekstiAlue.setLineWrap(true);
//        tekstiAlue.setWrapStyleWord(true);
        //Luodaan editorin menu-palkki
        setJMenuBar(menuPalkki);

        //valikot menu-palkkiin
        menuPalkki.add(tiedostoMenu);
        menuPalkki.add(muokkaaMenu);
        menuPalkki.add(muotoileMenu);

        //Tiedosto-valikkoon tallenna, tallenna nimellä ja avaa
        tiedostoMenu.add(avaaOsa);
        tiedostoMenu.add(tallennaOsa);
        tiedostoMenu.add(tallennaNimella);
        //Muotoile-valikkoon lihavointi, fontti ja teema
        muotoileMenu.add(boldaus);
        muotoileMenu.add(fontti);
        muotoileMenu.add(teema);
        //Fontti TÄMÄ VIELÄ VAIHEESSA*****
        teema.add(vihreaTeema);

        fontti.add(serifFontti);
        fontti.add(arialFontti);

        //Muokkaa valikkoon tulossa leikkaa/liitä/kopioi
        kopioi = new JMenuItem(new DefaultEditorKit.CopyAction());
        kopioi.setText("Kopioi");
        kopioi.setMnemonic(KeyEvent.VK_C);
        liita = new JMenuItem(new DefaultEditorKit.PasteAction());
        liita.setText("Liitä");
        liita.setMnemonic(KeyEvent.VK_V);
        leikkaa = new JMenuItem(new DefaultEditorKit.CutAction());
        leikkaa.setText("Leikkaa");
        leikkaa.setMnemonic(KeyEvent.VK_X);
        muokkaaMenu.add(kopioi);
        muokkaaMenu.add(liita);
        muokkaaMenu.add(leikkaa);

        pane.add(scpane, BorderLayout.CENTER);
        pane.add(toolBar, BorderLayout.SOUTH);

        //näppäinkomennot tähän, leikkaa liitä kopio
        //kuuntelijat 1. tallenna 2. avaa jnejne
        avaaOsa.addActionListener(this);
        tallennaOsa.addActionListener(this);
        tallennaNimella.addActionListener(this);
        boldaus.addActionListener(this);
        serifFontti.addActionListener(this);
        arialFontti.addActionListener(this);
        
        
    }
    

    public String getTekstiAlue() {
        return tekstiAlue.getText();
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem choice = (JMenuItem) e.getSource();
        if (choice == tallennaOsa) {
            try {
                tEditori.tallennaTiedosto(tekstiAlue.getText());
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (choice == tallennaNimella) {
            try {
                tEditori.tallennaNimellaTiedosto(tekstiPane.getText());
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (choice == avaaOsa) {
            tEditori.avaa(tekstiPane);
        }
        if (choice == boldaus) {
            tEditori.lihavoiTeksti(tekstiPane);
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
