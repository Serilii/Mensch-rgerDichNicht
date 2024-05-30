package GUI;
import java.awt.*;
import javax.swing.*;

import klassen.*;
// import GUI.*;

public class WuerfelPanel extends JPanel {
    
    Spielfeld sf;

    Color fillingfarbe = Color.white;
    
    public WuerfelPanel(Spielfeld sf){
        this.setSize(new Dimension(200,200));
        this.sf = sf;
        this.setOpaque(false);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics gd = (Graphics2D) g;

        fillingfarbe = sf.Farbe_am_Zug.colour;

        Color shade = new Color(
            ((int)((this.fillingfarbe.getRed())/1.5)), 
            ((int)((this.fillingfarbe.getGreen())/1.5)), 
            ((int)((this.fillingfarbe.getBlue())/1.5)),
            ((int)((this.fillingfarbe.getAlpha() * 1)) ));


        int augen = sf.wuerfel.aktuelle_Zahl;

        gd.setColor(shade);
        gd.fillRoundRect(0, 0, 50, 50, 23, 23);
        gd.setColor(fillingfarbe);
        gd.fillRoundRect(0, 0, 48, 47, 23, 23);

        gd.setColor(Color.black);
        if (augen == 1){
        gd.fillOval(18, 18, 10, 10);
        }
        if (augen == 2){
            gd.fillOval(7, 30, 10, 10);
            gd.fillOval(30, 6, 10, 10);
        }
        if (augen == 3){
            gd.fillOval(7, 30, 10, 10); //unten links
            gd.fillOval(29, 6, 10, 10); //oben rechts
            gd.fillOval(18, 18, 10, 10); //mitte
        }
        if (augen == 4){
            gd.fillOval(7, 30, 10, 10); //unten links
            gd.fillOval(29, 6, 10, 10); //oben rechts
            gd.fillOval(7, 6, 10, 10); //oben links
            gd.fillOval(29,30,10,10); //oben rechts
        }

        if (augen == 5){
            gd.fillOval(7, 30, 10, 10); //unten links
            gd.fillOval(29, 6, 10, 10); //oben rechts
            gd.fillOval(7, 6, 10, 10); //oben links
            gd.fillOval(29,30,10,10); //oben rechts
            gd.fillOval(18, 18, 10, 10); //mitte
        }        
        if (augen == 6){
            gd.fillOval(7, 30, 10, 10); //unten links
            gd.fillOval(29, 6, 10, 10); //oben rechts
            gd.fillOval(7, 6, 10, 10); //oben links
            gd.fillOval(29,30,10,10); //oben rechts
            gd.fillOval(7, 18, 10, 10); //mitte links
            gd.fillOval(29,18,10,10); //mitte rechts
        }

    }

public static void main (String[] args) {
    Wuerfel wf = new Wuerfel();
    wf.aktuelle_Zahl = 5;

    Spielfeld sf = new Spielfeld(wf);

sf.Farbe_am_Zug = sf.Grün;
    WuerfelPanel hans = new WuerfelPanel(sf);
    JFrame fenster = new JFrame("Ich bin eine GUI");
    fenster.setSize(60,150);
    fenster.getContentPane().setBackground(Color.cyan);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenster.setResizable(true);
    hans.setBackground(Color.green);
    hans.setOpaque(false);
    fenster.add(hans);
    fenster.setVisible(true);

    sf.print_Spielfeld();
}

}