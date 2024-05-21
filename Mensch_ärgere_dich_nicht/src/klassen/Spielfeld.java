package klassen;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spielfeld {    //Klasse für das gesamte Spielfeld

    public Farbe Blau;
    public Farbe Gelb;
    public Farbe Rot;
    public Farbe Grün;

    public Color BlueFilling = new Color(0,191,255);
    public Color YellowFilling = new Color(255,191,0);
    public Color RedFilling = new Color(212,96,101);   //ich liebe altrosa <3
    public Color GreenFilling = new Color(55,215,20);


    public Feld[][] feldarray;
    public Farbe[] farbenarray;

    public Spielfeld(){ //wenn das Spielfeld mit default generiert wird soll direkt das normale Spielfeld generiert werden
    
        this.feldarray = new Feld[12][12];   // initialisiere ein 11x11 feldarray und jeder Eintrag ist ein Feld mit den richtigen koordinaten
        for (int i = 0; i<12; i++)  {
            for (int j = 0; j<12; j++) {
            feldarray[i][j] = new Feld(i,j);    
            }
        }
        //bestimme die Startfelder der 4 Spieler
        // Feld Startfeld_links = this.feldarray[1][7];
        // Feld Startfeld_oben = this.feldarray[7][11];
        // Feld Startfeld_recht = this.feldarray[11][5];
        // Feld Startfeld_unten = this.feldarray[5][1];

        //bestimme die Startfelder der 4 Spieler
        Feld Startfeld_links = this.feldarray[1][5];
        Feld Startfeld_oben = this.feldarray[7][1];
        Feld Startfeld_recht = this.feldarray[11][7];
        Feld Startfeld_unten = this.feldarray[5][11];

        //generiere jede Farbe , jede Farbe generiert automatisch 4 Figuren (ohne Startfeld bis jetzt)
        Blau = new Farbe("Blau", this, 1,11, Startfeld_unten, BlueFilling);
        Gelb = new Farbe("Gelb", this,1, 2 , Startfeld_links, YellowFilling);
        Rot = new Farbe("Rot", this, 10, 11, Startfeld_recht, RedFilling);
        Grün = new Farbe("Grün",this, 10, 2, Startfeld_oben, GreenFilling);
        

        this.farbenarray = new Farbe[]{Gelb, Grün, Rot, Blau};
        this.verbinde_alle_felder();

    } //Spielfeld Constructor ende
    
    

    public void print_Spielfeld(){      //konsolenausgabe für ein erstelltes Spielfeld
        for (int i = 11; i>=1; i--)  {
			System.out.println();
			for (int j = 1; j<12; j++)  {
                if (this.feldarray[j][i].figur != null){
                    System.out.print("🔵");
                }
                else if (this.feldarray[j][i].nächstes != null) {
                    System.out.print("🔴");
                }
                else if (this.feldarray[j][i].nächstes_parken != null) {
                    System.out.print("🟢");
                }
				else if (this.feldarray[j][i].figur == null){
				System.out.print("⚪"); 
                }
				 
                //falss ich das Feld mal mit Koordinaten ausgeben will: 		// 		System.out.print(String.format("%02d",(feldarray[i][j].x_koordinate)) + "|" + String.format("%02d",(feldarray[i][j].y_koordinate)) + " "); }

            }
        }
    }

    public void print_Spielfeld_koordinaten(){
    for (int i = 11; i>=1; i--)  {
        System.out.println();
        for (int j = 1; j<12; j++)  {
            if (this.feldarray[j][i].figur == null){
            System.out.print(String.format("%02d",(this.feldarray[i][j].x_koordinate)) + "|" + String.format("%02d",(this.feldarray[i][j].y_koordinate)) + " "); }
            else {
                System.out.print("xoxo  ");
            }}}}

public void verbinde_alle_felder(){ //ja trauriger weise war es einfacher alles per copy paste und vorzeichen-ändern per hand zu lösen als eine unnötig komplizierte schleife für genau das hier auszudenken sorry
    Feld momentan = this.feldarray[1][7];

    for (int i = 0; i < 4; i++ ) {
        //los gehts
         momentan.nächstes = this.feldarray[momentan.x_koordinate + 1 ][momentan.y_koordinate];
         momentan = momentan.nächstes;
        }
        for (int j = 0; j < 4; j++ ) {
            momentan.nächstes = this.feldarray[momentan.x_koordinate][momentan.y_koordinate +1 ];
            momentan = momentan.nächstes;
           }
        for (int j = 0; j < 2; j++ ) {
        momentan.nächstes = this.feldarray[momentan.x_koordinate+1 ][momentan.y_koordinate];
        momentan = momentan.nächstes;
        }

        for (int i = 0; i < 4; i++ ) {
            momentan.nächstes = this.feldarray[momentan.x_koordinate ][momentan.y_koordinate-1];
            momentan = momentan.nächstes;
           }
           for (int j = 0; j < 4; j++ ) {
               momentan.nächstes = this.feldarray[momentan.x_koordinate +1][momentan.y_koordinate];
               momentan = momentan.nächstes;
              }
           for (int j = 0; j < 2; j++ ) {
           momentan.nächstes = this.feldarray[momentan.x_koordinate][momentan.y_koordinate -1];
           momentan = momentan.nächstes;
           }
           for (int i = 0; i < 4; i++ ) {
            momentan.nächstes = this.feldarray[momentan.x_koordinate -1 ][momentan.y_koordinate];
            momentan = momentan.nächstes;
           }
           for (int j = 0; j < 4; j++ ) {
               momentan.nächstes = this.feldarray[momentan.x_koordinate][momentan.y_koordinate-1];
               momentan = momentan.nächstes;
              }
           for (int j = 0; j < 2; j++ ) {
           momentan.nächstes = this.feldarray[momentan.x_koordinate -1 ][momentan.y_koordinate];
           momentan = momentan.nächstes;
           }

           for (int i = 0; i < 4; i++ ) {
            momentan.nächstes = this.feldarray[momentan.x_koordinate ][momentan.y_koordinate+1 ];
            momentan = momentan.nächstes;
           }
           for (int j = 0; j < 4; j++ ) {
               momentan.nächstes = this.feldarray[momentan.x_koordinate - 1][momentan.y_koordinate];
               momentan = momentan.nächstes;
              }
           for (int j = 0; j < 2; j++ ) {
           momentan.nächstes = this.feldarray[momentan.x_koordinate ][momentan.y_koordinate +1 ];
           momentan = momentan.nächstes;
           }

           momentan = this.feldarray[1][6];
           for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.feldarray[momentan.x_koordinate + 1][momentan.y_koordinate ];
            momentan = momentan.nächstes_parken;
            }
            momentan = this.feldarray[6][11];
            for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.feldarray[momentan.x_koordinate][momentan.y_koordinate -1 ];
            momentan = momentan.nächstes_parken;
            }
            momentan = this.feldarray[11][6];
            for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.feldarray[momentan.x_koordinate-1][momentan.y_koordinate ];
            momentan = momentan.nächstes_parken;
            }
            momentan = this.feldarray[6][1];
            for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.feldarray[momentan.x_koordinate][momentan.y_koordinate +1 ];
            momentan = momentan.nächstes_parken;
            }
        

            //ab hier korrektur weil ich das die felder falschrum verlinkt hab upsi :P


            List<Feld> korrekturArray = new ArrayList<Feld>();
            momentan = this.feldarray[1][7];


            for (int i = 0; i < 42; i++ ) {
                korrekturArray.add(momentan.nächstes);
                momentan = momentan.nächstes;
            }

            momentan = this.feldarray[1][7];

            for (int i = korrekturArray.size() -1; i > 0; i--){
                momentan.nächstes = korrekturArray.get(i);
                momentan = momentan.nächstes;

            }

            this.feldarray[4][7].nächstes = this.feldarray[3][7]; 
}}
