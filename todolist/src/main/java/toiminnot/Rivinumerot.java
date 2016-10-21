package toiminnot;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
/**
 * Tällä luokalla voidaan vaihtaa JTextArean tekstin fonttia
 *
 * @param vaihdaFonttiArial vaihtaa fontin Arialiksi
 * @param vaihdaFonttiSerif vaihtaa fontin Serifiksi
 *
 */

public class Rivinumerot extends JTextPane
{
    private JTextPane textPane;

    public Rivinumerot(JTextPane textPane)
    {
        this.textPane = textPane;
        setBackground(Color.LIGHT_GRAY);
        setEditable(false);
    }

    public void paivitaRiviNumerot()
    {
        String lineNumbersText = getRiviNumeroTeksti();
        setText(lineNumbersText);
    }

    private String getRiviNumeroTeksti()
    {   

        int caretPosition = textPane.getDocument().getLength();
        Element root = textPane.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersTextBuilder = new StringBuilder();
        lineNumbersTextBuilder.append("1").append(System.lineSeparator());

        for (int elementIndex = 2; elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++)
        {
            lineNumbersTextBuilder.append(elementIndex).append(System.lineSeparator());
        }

        return lineNumbersTextBuilder.toString();
    }
}