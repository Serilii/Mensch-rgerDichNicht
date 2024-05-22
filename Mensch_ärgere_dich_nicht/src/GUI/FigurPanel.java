package GUI;
import java.awt.*;
import javax.swing.*;
import klassen.*;

public class FigurPanel extends JPanel {
    
Color fillingfarbe;
Figur figur;

public FigurPanel(){
    this.setSize(new Dimension(65,95));
    this.setOpaque(false);
}

//überladung mit einer farbe aus awt
public FigurPanel(Color color){
    this.setSize(new Dimension(60,90));
    this.fillingfarbe = color;
    this.setOpaque(false);
}

//überladung mit einer figureninstanz, zieht sich die farbe aus der figut selbst
public FigurPanel(Figur figur){
    this.setSize(new Dimension(60,90));
    this.figur = figur;
    this.fillingfarbe = figur.farbe.colour;
    this.setOpaque(false);
}

public void paint(Graphics g){
    super.paint(g);
    Graphics g2D = (Graphics2D) g;

    //outer part ("outlines")
    g2D.setColor(Color.BLACK);
    g2D.fillOval(11,0, 30, 30);
     int a[] = {26,0,52 };
     int b[] = {1,70,70 };
    g2D.fillPolygon(a,b,3);
    //          x,  y, width, height, startangle, angle  
    g2D.fillArc(1, 60, 52, 20 , 180, 180);

    //inner part
    if (this.fillingfarbe != null){
        g2D.setColor(fillingfarbe);}
    g2D.fillOval(12, 2, 27, 26);
     int x[] = {26, 2, 48 };
     int y[] = {3, 68, 68 };
    g2D.fillPolygon(x,y,3);
    g2D.fillArc(3, 58, 45, 18 , 180, 180);

    //highlights, cause we love some depth and glamour uwu
        g2D.setColor(Color.white);
        g2D.fillOval(17, 9, 6, 8);
        int u[] = {20, 8, 11 };
        int v[] = {35, 67, 69 };
        g2D.fillPolygon(u,v,3);
    }

public static void main(String[] args) {
    FigurPanel hans = new FigurPanel(Color.pink);
    JFrame fenster = new JFrame("Ich bin eine GUI");
    fenster.setSize(60,150);
    fenster.getContentPane().setBackground(Color.cyan);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenster.setResizable(true);
    hans.setBackground(Color.green);
    hans.setOpaque(false);
    fenster.add(hans);
    fenster.setVisible(true);

}

}
