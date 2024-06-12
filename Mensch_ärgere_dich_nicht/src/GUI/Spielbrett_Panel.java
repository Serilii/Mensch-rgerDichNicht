package GUI;
import javax.swing.*;
import java.awt.*;


public class Spielbrett_Panel extends JPanel {

    // int breite = schritt*11;   //faktor von 11 weil 11x11 feld
    // int hoehe = schritt*11;

    int breite = (int) (Guitest.width * 0.8 ) ;
    int hoehe = (int) (Guitest.height * 0.8) ;
    int kreis_durchmesser = (int) (hoehe/11 * 0.75); //60
    int schritt = (int) (hoehe / 11) ; //80

    Color farbe = new Color(232,220,202); //beige


    public Spielbrett_Panel(){
        this.setPreferredSize(new Dimension(breite,hoehe));
        this.setBackground(farbe);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(4));
    
        
        g2D.setPaint(Color.WHITE);
        // for (int i = 1; i < 12; i++) {
        //     if (i!=3 && i!= 4 && i != 8 && i != 9){
        //         g2D.fillOval((breite/11)*i, (hoehe / 11), kreis_durchmesser, kreis_durchmesser); }}
        // for (int i = 1; i < 12; i++) {
        //     if (i!=3 && i!= 4 && i != 8 && i != 9){
        //         g2D.fillOval((breite/11)*i, hoehe, kreis_durchmesser, kreis_durchmesser); }}     
        // for (int j=1; j < 12; j++){
        //     if (j!= 3 && j!= 4 && j!= 8 && j != 9)
        //     g2D.fillOval((hoehe/11), (breite / 11)*j, kreis_durchmesser, kreis_durchmesser);}
        // for (int j=1; j < 12; j++){
        //     if (j!= 3 && j!= 4 && j!= 8 && j != 9)
        //         g2D.fillOval((hoehe), (breite / 11)*j, kreis_durchmesser, kreis_durchmesser);}
        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.fillOval((breite/11)*k, (hoehe/11)*i, kreis_durchmesser, kreis_durchmesser);
                 } } }
        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.fillOval((breite/11)*i, (hoehe/11)*k, kreis_durchmesser, kreis_durchmesser);
                } } }

        
        //gelbe Felder
        g2D.setPaint(Color.YELLOW);
        g2D.fillOval(schritt, schritt, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*2, schritt, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt, schritt*2, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*2, schritt*2, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt, schritt*5, kreis_durchmesser , kreis_durchmesser); //startfeld gelb
        for (int i = 2; i<6; i++) {g2D.fillOval(schritt*i, 6*schritt, kreis_durchmesser , kreis_durchmesser);}

        //grüne Felder
        g2D.setPaint(new Color(24,143,0));
        g2D.fillOval(schritt*10, schritt, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*11, schritt, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*10, schritt*2, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*11, schritt*2, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*7, schritt, kreis_durchmesser , kreis_durchmesser); //startfeld grün
        for (int i = 2; i<6; i++) {g2D.fillOval(schritt*6, schritt*i, kreis_durchmesser , kreis_durchmesser);}

        //blaue Felder
        g2D.setPaint(new Color(8,96,200));
        g2D.fillOval(schritt, schritt*10, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt, schritt*11, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*2, schritt*10, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*2, schritt*11, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*5, schritt*11, kreis_durchmesser , kreis_durchmesser); //startfeld
        for (int i = 7; i<11; i++) {g2D.fillOval(schritt*6, schritt*i, kreis_durchmesser , kreis_durchmesser);}

        //rote Felder
        g2D.setPaint(new Color(220,40,40));
        g2D.fillOval(schritt*10, schritt*10, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*10, schritt*11, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*11, schritt*10, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*11, schritt*11, kreis_durchmesser , kreis_durchmesser);
        g2D.fillOval(schritt*11, schritt*7, kreis_durchmesser , kreis_durchmesser); //startfeld
        for (int i = 7; i<11; i++) {g2D.fillOval(schritt*i, 6*schritt, kreis_durchmesser , kreis_durchmesser);}



        g2D.setPaint(Color.BLACK);
        for (int i = 1; i < 12; i++) {
            if (i!=3 && i!= 4 && i != 8 && i != 9){
                g2D.drawOval((breite/11)*i, (hoehe / 11), kreis_durchmesser, kreis_durchmesser); }}
                

        for (int i = 1; i < 12; i++) {
            if (i!=3 && i!= 4 && i != 8 && i != 9){
                g2D.drawOval((breite/11)*i, hoehe, kreis_durchmesser, kreis_durchmesser); }}
        
                
        for (int j=1; j < 12; j++){
            if (j!= 3 && j!= 4 && j!= 8 && j != 9)
            g2D.drawOval((hoehe/11), (breite / 11)*j, kreis_durchmesser, kreis_durchmesser);}

        for (int j=1; j < 12; j++){
            if (j!= 3 && j!= 4 && j!= 8 && j != 9)
                g2D.drawOval((hoehe), (breite / 11)*j, kreis_durchmesser, kreis_durchmesser);}

        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.drawOval((breite/11)*k, (hoehe/11)*i, kreis_durchmesser, kreis_durchmesser);
                    }
                }
            }
        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.drawOval((breite/11)*i, (hoehe/11)*k, kreis_durchmesser, kreis_durchmesser);
                    }
                }
            }
            g2D.drawOval(schritt*2, schritt*2, kreis_durchmesser, kreis_durchmesser);
            g2D.drawOval(schritt*10, schritt*10, kreis_durchmesser, kreis_durchmesser);
            g2D.drawOval(schritt*2, schritt*10, kreis_durchmesser, kreis_durchmesser);
            g2D.drawOval(schritt*10, schritt*2, kreis_durchmesser, kreis_durchmesser);


        }
    }



// 1 2     5 6 7     10 11
//     3 4       8 9 