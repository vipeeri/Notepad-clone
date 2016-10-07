package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;

    /**
     * Tällä luokalla voidaan vaihtaa JTextArea lihavoiduksi
     * 
     *
     */

public class Boldaus {
    

    public Boldaus() {

    }

    public void vaihdaFontti(JTextArea f) {
        f.setFont(new Font("", Font.BOLD, 14));

    }

}
