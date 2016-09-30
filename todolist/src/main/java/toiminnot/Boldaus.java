package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;

public class Boldaus {
    
    /**
     * Tällä luokalla voidaan vaihtaa JTextArea lihavoiduksi
     * 
     *
     */

    public Boldaus() {

    }

    public void vaihdaFontti(JTextArea f) {
        f.setFont(new Font("", Font.BOLD, 14));

    }

}
