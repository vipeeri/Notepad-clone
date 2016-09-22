package toiminnot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Tallennus extends JFrame {

    //Tallenna nimellä
    public void tallennaNimella() {
        JFileChooser save = new JFileChooser(); 
        int option = save.showSaveDialog(this);
    }

// Tallenna
    private void tallenna(File filename) {

    }

}

