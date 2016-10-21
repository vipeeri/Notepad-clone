package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import tekstieditori.Tekstieditori;
import toiminnot.Rivinumerot;
import toiminnot.Tallennus;
import toiminnot.Teemat;

public class Gui extends JFrame implements ActionListener, WindowListener {

    private JTextPane tekstiPane;
    private JTextArea tekstiAlue;
    private StyledDocument styledDocument;
    private int laskuri;
    private JMenuBar menuPalkki;
    private JMenu tiedostoMenu, muokkaaMenu, muotoileMenu, teema;
    private JMenuItem tallennaOsa, tallennaNimella, avaaOsa, boldaus, fontti, serifFontti, arialFontti, tummaTeema, punainenTeema, kopioi,
            liita, leikkaa, alleViivaa;
    private JScrollPane scpane;
    private String alkuTxt;
    private JToolBar toolBar;
    private Tekstieditori tEditori = new Tekstieditori();
    private Teemat teemat = new Teemat();
    private Rivinumerot rivinumerotTextPane;

    public Gui() throws BadLocationException {

        super("Tekstieditori - harjoitustyö");
        super.addWindowListener(this);

        /**
         * GUI-luokka tarjoaa nimensä mukaan graafisen käyttöliittymän
         * tekstieditorille
         *
         * Asetetaan alkuun editorin koko ja layout
         *
         */
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

        //Tiedosto, Muokkaa ja Muotoile-JMenut
        tiedostoMenu = new JMenu("Tiedosto");
        muokkaaMenu = new JMenu("Muokkaa");
        muotoileMenu = new JMenu("Muotoile");
        teema = new JMenu("Teema");

        //Teemat JMenuun
        punainenTeema = new JMenuItem("Punainen");
        tummaTeema = new JMenuItem("Tumma");

        //Tiedosto-menuun kuuluvat JMenuItemit
        avaaOsa = new JMenuItem("Avaa...");
        tallennaOsa = new JMenuItem("Tallenna");
        tallennaNimella = new JMenuItem("Tallenna nimellä...");

        //Lihavointi, alleviivaus ja fontit muotoile submenuun
        boldaus = new JMenuItem("Lihavoi");
        fontti = new JMenu("Fontti");
        alleViivaa = new JMenuItem("Alleviivaa");

        //Submenut Fontille:
        serifFontti = new JMenuItem("Serif");
        arialFontti = new JMenuItem("Arial");

        this.styledDocument = new DefaultStyledDocument();
        tekstiPane = new JTextPane(styledDocument);
        scpane = new JScrollPane(tekstiPane);
        toolBar = new JToolBar();

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

        //Muotoile-valikkoon lihavointi, fontti, teema ja alleviivaus
        muotoileMenu.add(boldaus);
        muotoileMenu.add(fontti);
        muotoileMenu.add(teema);
        muotoileMenu.add(alleViivaa);

        //Teema-valikkoon punainen ja tumma teema
        teema.add(punainenTeema);
        teema.add(tummaTeema);

        //Fontti-valikkoon Seriff ja Arial-fontit
        fontti.add(serifFontti);
        fontti.add(arialFontti);

        //Muokkaa-valikkoon leikkaa/liitä/kopioi
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

        //kuuntelijat 1. tallenna 2. avaa jnejne
        avaaOsa.addActionListener(this);
        tallennaOsa.addActionListener(this);
        tallennaNimella.addActionListener(this);
        boldaus.addActionListener(this);
        serifFontti.addActionListener(this);
        arialFontti.addActionListener(this);
        tummaTeema.addActionListener(this);
        punainenTeema.addActionListener(this);
        alleViivaa.addActionListener(this);

        rivinumerotTextPane = new Rivinumerot(tekstiPane);
        scpane.setRowHeaderView(rivinumerotTextPane);

        tekstiPane.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                rivinumerotTextPane.paivitaRiviNumerot();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                rivinumerotTextPane.paivitaRiviNumerot();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                rivinumerotTextPane.paivitaRiviNumerot();
            }
        });

    }

    public String getTekstiAlue() {
        return tekstiAlue.getText();
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem choice = (JMenuItem) e.getSource();
        if (choice == tallennaOsa) {
            try {
                tEditori.tallennaTiedosto(tekstiPane.getText());
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
            tEditori.vaihdaFontti(tekstiPane, "arial");
        }
        if (choice == serifFontti) {
            tEditori.vaihdaFontti(tekstiPane, "serif");
        }
        if (choice == punainenTeema) {
            tEditori.punainenTeema(tekstiPane);

        }
        if (choice == tummaTeema) {
            tEditori.tummaTeema(tekstiPane);
        }
        if (choice == alleViivaa) {
            tEditori.alleViivaa(tekstiPane);
            
        }
    }

    public void changeHeader(String teksti) {
        setTitle("Tekstieditori - " + teksti);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            tEditori.tallennaVanha(tekstiPane);
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
