package toiminnot;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Tässä luokassa otetaan talteen käyttäjän valitsema tekstipätkä
 *@param caretUpdate hoitaa tämän asian
 *
 */

public class Tekstinvalinta implements CaretListener {

    private int mark;
    private int dot;

    @Override
    public void caretUpdate(CaretEvent event) {
        dot = event.getDot();
        mark = event.getMark();
        if (dot != mark) {
            if (dot < mark) {
                int temp = dot;
                dot = mark;
                mark = temp;
            }
        }
    }

    public int getMark() {
        return this.mark;
    }

    public int getDot() {
        return this.dot;
    }

}
