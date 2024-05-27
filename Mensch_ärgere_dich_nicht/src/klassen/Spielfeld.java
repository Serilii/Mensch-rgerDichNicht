package klassen;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUI.Guitest;

public class Spielfeld {    //Klasse für das gesamte Spielfeld

    public Farbe Blau;
    public Farbe Gelb;
    public Farbe Rot;
    public Farbe Grün;
    public Farbe Farbe_am_Zug;      //Pointer für Farbe die gerade dran ist

    public Wuerfel wuerfel;

    public Color BlueFilling = new Color(0,191,255);
    public Color YellowFilling = new Color(255,191,0);
    public Color RedFilling = new Color(212,96,101);   //ich liebe altrosa <3
    public Color GreenFilling = new Color(55,215,20);

    public Feld[][] feldarray;
    public Farbe[] farbenarray;
    public Feld[] wuerfel_feld_array;

    public Guitest GUI;      //pointer für die GUI

    public int iterator = 0;

    public Spielfeld(Wuerfel wuerfel){ //wenn das Spielfeld mit default generiert wird soll direkt das normale Spielfeld generiert werden
    
        this.wuerfel = wuerfel;

        this.feldarray = new Feld[12][12];   // initialisiere ein 11x11 feldarray und jeder Eintrag ist ein Feld mit den richtigen koordinaten
        for (int i = 0; i<12; i++)  {
            for (int j = 0; j<12; j++) {
            feldarray[i][j] = new Feld(i,j);    
            }
        }
        
        //bestimme die Startfelder der 4 Spieler
        Feld Startfeld_links = this.feldarray[1][5];
        Feld Startfeld_oben = this.feldarray[7][1];
        Feld Startfeld_recht = this.feldarray[11][7];
        Feld Startfeld_unten = this.feldarray[5][11];

        Feld wuerfel_feld_gelb = this.feldarray[3][3];
        Feld wuerfel_feld_gruen = this.feldarray[9][3];
        Feld wuerfel_feld_rot = this.feldarray[9][9];
        Feld wuerfel_feld_blau = this.feldarray[3][9];

        //generiere jede Farbe , jede Farbe generiert automatisch 4 Figuren (ohne Startfeld bis jetzt)
        Blau = new Farbe("Blau", this, 1,11, Startfeld_unten, BlueFilling);
        Gelb = new Farbe("Gelb", this,1, 2 , Startfeld_links, YellowFilling );
        Rot = new Farbe("Rot", this, 10, 11, Startfeld_recht, RedFilling);
        Grün = new Farbe("Grün",this, 10, 2, Startfeld_oben, GreenFilling);
        Farbe_am_Zug = Gelb;


        this.farbenarray = new Farbe[]{Gelb, Grün, Rot, Blau};
        this.wuerfel_feld_array = new Feld[]{wuerfel_feld_gelb, wuerfel_feld_gruen,wuerfel_feld_rot, wuerfel_feld_blau};
        this.verbinde_alle_felder();

    } //Spielfeld Constructor ende
    


    public boolean bewege_figur(int f){
        if (wuerfel.aktuelle_Zahl == 0) {return false;}
        Figur x = this.Farbe_am_Zug.figurenarray[f];
        if (x.Zielfeld_return(wuerfel.aktuelle_Zahl).figur != null && x.Zielfeld_return(wuerfel.aktuelle_Zahl).figur.farbe == x.farbe) {
            return false;
        }
         if (x.feld == x.aus_feld && this.wuerfel.aktuelle_Zahl == 6 ){
            if (x.start_feld.figur != null && x.start_feld.figur.farbe == x.farbe) {return false;}
            x.einsteigen();
            return true;
        } else if (x.feld != x.aus_feld){
            x.alle_felder_ziehen(this.wuerfel.aktuelle_Zahl);
            return true;
        } else {
            return false;
        }
    }



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

    public void runde_beenden(){
        if (pruefe_ob_gewonnen()) {
            // this.GUI.label_farbe_am_zug.setText("Spieler " + this.Farbe_am_Zug.farbe + " hat gewonnen!");
        } else {
            if (this.iterator == 3) {this.iterator = 0;} else {this.iterator += 1;}; //iterator steigt um 1 und ändert den Spieler der dran ist
            this.Farbe_am_Zug = this.farbenarray[iterator];
            runde_beginnen();

            this.wuerfel.aktuelle_Zahl = 0;
            this.GUI.wuerfel_zaehler = 0;

            // this.GUI.Wuerfelanzeige.setText("Spieler muss Würfeln! ");
            // this.GUI.label_farbe_am_zug.setText(this.Farbe_am_Zug.farbe + " ist dran!");        // this.wuerfel.aktuelle_Zahl = 0;
        
        
        } }

    public boolean pruefe_ob_gewonnen() {
        for (Figur figuren : this.Farbe_am_Zug.figurenarray) {
            if (figuren.geparkt == false) { //wenn auch nur eine der Figuren false geparkt ist : return false
                return false; } //wenn keine Figur ungeparkt ist : return true
            }
        return true;    
        }

    public void runde_beginnen() {
        boolean eine_draussen = false;
        for (Figur figuren : this.Farbe_am_Zug.figurenarray) {
            if (figuren.feld != figuren.aus_feld) {         //wenn eine der Figuren ungeparkt ist, eine draussen = true
                eine_draussen = true;}
                
        if (eine_draussen == false)
            {this.wuerfel.versuche = 3;}
        else {this.wuerfel.versuche = 1;}
        }   //bis hier festgelegt ob man normal 1 mal oder 3 mal würfeln darf wenn alle figuren drin sind.


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
        

            //ab hier korrektur-code weil ich das die felder rückwärts verlinkt hab upsi :P


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
