package GUI;
import javax.swing.*;
import java.awt.*;


public class Spielbrett_Panel extends JPanel {

    int breite = 880;   //faktor von 11 weil 11x11 feld
    int hoehe = 880;
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
        for (int i = 1; i < 12; i++) {
            if (i!=3 && i!= 4 && i != 8 && i != 9){
                g2D.fillOval((breite/11)*i, (hoehe / 11), 60, 60); }}
        for (int i = 1; i < 12; i++) {
            if (i!=3 && i!= 4 && i != 8 && i != 9){
                g2D.fillOval((breite/11)*i, hoehe, 60, 60); }}     
        for (int j=1; j < 12; j++){
            if (j!= 3 && j!= 4 && j!= 8 && j != 9)
            g2D.fillOval((hoehe/11), (breite / 11)*j, 60, 60);}
        for (int j=1; j < 12; j++){
            if (j!= 3 && j!= 4 && j!= 8 && j != 9)
                g2D.fillOval((hoehe), (breite / 11)*j, 60, 60);}
        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.fillOval((breite/11)*k, (hoehe/11)*i, 60, 60);
                 } } }
        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.fillOval((breite/11)*i, (hoehe/11)*k, 60, 60);
                } } }

        
        //gelbe Felder
        g2D.setPaint(Color.YELLOW);
        g2D.fillOval(80, 80, 60 , 60);
        g2D.fillOval(160, 80, 60 , 60);
        g2D.fillOval(80, 160, 60 , 60);
        g2D.fillOval(160, 160, 60 , 60);
        g2D.fillOval(80, 400, 60 , 60); //startfeld gelb
        for (int i = 2; i<6; i++) {g2D.fillOval(80*i, 6*80, 60 , 60);}

        //grüne Felder
        g2D.setPaint(new Color(24,143,0));
        g2D.fillOval(800, 80, 60 , 60);
        g2D.fillOval(880, 80, 60 , 60);
        g2D.fillOval(800, 160, 60 , 60);
        g2D.fillOval(880, 160, 60 , 60);
        g2D.fillOval(560, 80, 60 , 60); //startfeld grün
        for (int i = 2; i<6; i++) {g2D.fillOval(480, 80*i, 60 , 60);}

        //blaue Felder
        g2D.setPaint(new Color(8,96,200));
        g2D.fillOval(80, 800, 60 , 60);
        g2D.fillOval(80, 880, 60 , 60);
        g2D.fillOval(160, 800, 60 , 60);
        g2D.fillOval(160, 880, 60 , 60);
        g2D.fillOval(400, 880, 60 , 60); //startfeld
        for (int i = 7; i<11; i++) {g2D.fillOval(480, 80*i, 60 , 60);}

        //rote Felder
        g2D.setPaint(new Color(220,40,40));
        g2D.fillOval(800, 800, 60 , 60);
        g2D.fillOval(800, 880, 60 , 60);
        g2D.fillOval(880, 800, 60 , 60);
        g2D.fillOval(880, 880, 60 , 60);
        g2D.fillOval(880, 560, 60 , 60); //startfeld
        for (int i = 7; i<11; i++) {g2D.fillOval(80*i, 6*80, 60 , 60);}



        g2D.setPaint(Color.BLACK);
        for (int i = 1; i < 12; i++) {
            if (i!=3 && i!= 4 && i != 8 && i != 9){
                g2D.drawOval((breite/11)*i, (hoehe / 11), 60, 60); }}
                

        for (int i = 1; i < 12; i++) {
            if (i!=3 && i!= 4 && i != 8 && i != 9){
                g2D.drawOval((breite/11)*i, hoehe, 60, 60); }}
        
                
        for (int j=1; j < 12; j++){
            if (j!= 3 && j!= 4 && j!= 8 && j != 9)
            g2D.drawOval((hoehe/11), (breite / 11)*j, 60, 60);}

        for (int j=1; j < 12; j++){
            if (j!= 3 && j!= 4 && j!= 8 && j != 9)
                g2D.drawOval((hoehe), (breite / 11)*j, 60, 60);}

        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.drawOval((breite/11)*k, (hoehe/11)*i, 60, 60);
                    }
                }
            }
        for (int k = 5; k<8; k++){
            for (int i = 1; i < 12; i++){
                if (i != 6){
                    g2D.drawOval((breite/11)*i, (hoehe/11)*k, 60, 60);
                    }
                }
            }
            g2D.drawOval(160, 160, 60, 60);
            g2D.drawOval(800, 800, 60, 60);
            g2D.drawOval(160, 800, 60, 60);
            g2D.drawOval(800, 160, 60, 60);


        }
    }



// 1 2     5 6 7     10 11
//     3 4       8 9 