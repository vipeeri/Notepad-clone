package tekstieditori;

import javax.swing.*; //JFrame
import java.awt.*; //GUI
import java.awt.event.*; //Kuuntelijat
import java.util.Scanner; //Tiedostosta lukeminen
import java.io.*; //Tiedostoon kirjoitus

public class Tekstieditori extends JFrame implements ActionListener {

    private JTextArea tekstiAlue;
    private int laskuri;
    private JMenuBar menuPalkki;
    private JScrollPane scpane;
    private String alkuTxt;
    private JToolBar toolBar;

    public Tekstieditori() {
        super("Tekstieditori - harjoitustyö");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        laskuri = 0;
        alkuTxt = " ";
        tekstiAlue = new JTextArea(); //tekstialue
        
        scpane = new JScrollPane(tekstiAlue); //lisätään tekstialue scrollpaneen
        toolBar = new JToolBar();

        tekstiAlue.setLineWrap(true);
        tekstiAlue.setWrapStyleWord(true);

        


        //näppäinkomentoja

        pane.add(scpane, BorderLayout.CENTER);
        pane.add(toolBar, BorderLayout.SOUTH);


       

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Tekstieditori();
    }
}
