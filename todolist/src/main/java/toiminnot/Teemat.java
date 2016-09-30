/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toiminnot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

/**
 * Jatkossa luokalla pitäisi pystyä vaihtamaan esim. värejä
 *
 *
 */

public class Teemat extends JToolBar {

    Color bgColor = Color.WHITE;

    public void setColor(Color color) {
        bgColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

}
