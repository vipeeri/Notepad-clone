package toiminnot;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

<<<<<<< HEAD
    /**
     * Tällä luokalla voidaan vaihtaa JTextArea lihavoiduksi
     * 
     *@param lihavoiTeksti hoitaa tämän
     *@param lisaaTyyli pitäisi lisätä lihavointi-tyyli, jotta se voidaa ottaa käyttöön
     */

=======
/**
 * Tällä luokalla voidaan vaihtaa JTextArea lihavoiduksi
 *
 *
 */
>>>>>>> 1f80ff53faeafb6882faca9f096c14e6bac2cb8f
public class Boldaus {

    public Boldaus() {

    }

//    public boolean vaihdaFontti(JTextArea f) {
//        f.setFont(new Font("", Font.BOLD, 14));
//        return true;
//
//    }
    
    public boolean lihavoiTeksti(StyledDocument t, int mark, int dot) {
        
        t = new DefaultStyledDocument();
        lisaaTyyli(t);
        
            try {
                int length = dot - mark;
                String s = t.getText(mark, length);
                t.remove(mark, length);
                t.insertString(mark, s,
                        t.getStyle("bold"));
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            return true;
        }
    
    private void lisaaTyyli(StyledDocument t) {
        Style def = StyleContext.getDefaultStyleContext().getStyle(
                StyleContext.DEFAULT_STYLE);
        Style s = t.addStyle("bold", def);
        StyleConstants.setBold(s, true);
    }
    

}
