
package tekstieditori;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import toiminnot.Tallennus;

public class Gui  extends JFrame implements ActionListener {

    private JTextArea tekstiAlue;
    private int laskuri;
    private JMenuBar menuPalkki;
    private JMenu tiedostoMenu;
    private JMenuItem tallennaOsa;
    private JScrollPane scpane;
    private String alkuTxt;
    private JToolBar toolBar;

    public Gui() {
        super("Tekstieditori - harjoitustyö");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        laskuri = 0;
        alkuTxt = " ";
        menuPalkki = new JMenuBar(); //menu-palkki
        tiedostoMenu = new JMenu("Tiedosto"); //tiedosto menu-palkkiin
        tallennaOsa = new JMenuItem("Tallenna"); //tallenna optio tiedoston alle
        tekstiAlue = new JTextArea(); //tekstialue
        scpane = new JScrollPane(tekstiAlue); //lisätään tekstialue scrollpaneen
        toolBar = new JToolBar();

        
        
        tekstiAlue.setLineWrap(true);
        tekstiAlue.setWrapStyleWord(true);
        
        //Luodaan editorin menu-palkki
        setJMenuBar(menuPalkki);
        
        //Tiedosto alavalikko menu-palkkiin
        menuPalkki.add(tiedostoMenu);
        
        //Tiedostovalikkoon tallenna
        tiedostoMenu.add(tallennaOsa);

        
        pane.add(scpane, BorderLayout.CENTER);
        pane.add(toolBar, BorderLayout.SOUTH);
        
        //näppäinkomennot tähän, leikkaa liitä kopio
        
        //kuuntelijat 1. tallenna 2. avaa jnejne
        tallennaOsa.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem choice = (JMenuItem) e.getSource();
        if (choice == tallennaOsa) {
            
            Tallennus tallenna = new Tallennus();
            tallenna.tallennaNimella();

        }
    }
}