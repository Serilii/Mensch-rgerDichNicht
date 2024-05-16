package klassen;


public class Spielfeld {    //Klasse für das gesamte Spielfeld

    public Feld[][] array;

    public Spielfeld(){ //wenn das Spielfeld mit default generiert wird soll direkt das normale Spielfeld generiert werden
    
        this.array = new Feld[12][12];   // initialisiere ein 11x11 Array und jeder Eintrag ist ein Feld mit den richtigen koordinaten
        for (int i = 0; i<12; i++)  {
            for (int j = 0; j<12; j++) {
            array[j][i] = new Feld(j,i);    //die +1 machen, dass die Koordinaten nicht bei 0 sondern 1 anfangen
            }
        }
        //bestimme die Startfelder der 4 Spieler
        Feld Startfeld_links = this.array[1][7];
        Feld Startfeld_oben = this.array[7][11];
        Feld Startfeld_recht = this.array[11][5];
        Feld Startfeld_unten = this.array[5][1];

        //generiere jede Farbe , jede Farbe generiert automatisch 4 Figuren (ohne Startfeld bis jetzt)
        Farbe Blau = new Farbe("Blau", this, 1,11, Startfeld_links);
        Farbe Gelb = new Farbe("Gelb", this,10, 11 , Startfeld_oben);
        Farbe Rot = new Farbe("Rot", this, 1, 2, Startfeld_recht);
        Farbe Grün = new Farbe("Grün",this, 10, 2, Startfeld_unten);
        

        this.verbinde_alle_felder();

    } //Spielfeld Constructor ende
    
    

    public void print_Spielfeld(){      //konsolenausgabe für ein erstelltes Spielfeld
        for (int i = 11; i>=1; i--)  {
			System.out.println();
			for (int j = 1; j<12; j++)  {
                if (this.array[j][i].figur != null){
                    System.out.print("🔵");
                }
                else if (this.array[j][i].nächstes != null) {
                    System.out.print("🔴");
                }
                else if (this.array[j][i].nächstes_parken != null) {
                    System.out.print("🟢");
                }
				else if (this.array[j][i].figur == null){
				System.out.print("⚪"); 
                }
				 
                //falss ich das Feld mal mit Koordinaten ausgeben will: 		// 		System.out.print(String.format("%02d",(array[i][j].x_koordinate)) + "|" + String.format("%02d",(array[i][j].y_koordinate)) + " "); }

            }
        }
    }

    public void print_Spielfeld_koordinaten(){
    for (int i = 11; i>=1; i--)  {
        System.out.println();
        for (int j = 1; j<12; j++)  {
            if (this.array[j][i].figur == null){
            System.out.print(String.format("%02d",(this.array[i][j].x_koordinate)) + "|" + String.format("%02d",(this.array[i][j].y_koordinate)) + " "); }
            else {
                System.out.print("xoxo  ");
            }}}}

public void verbinde_alle_felder(){ //ja trauriger weise war es einfacher alles per copy paste und vorzeichen-ändern per hand zu lösen als eine unnötig komplizierte schleife für genau das hier auszudenken sorry
    Feld momentan = this.array[1][7];

    for (int i = 0; i < 4; i++ ) {
         momentan.nächstes = this.array[momentan.x_koordinate+1 ][momentan.y_koordinate];
         momentan = momentan.nächstes;
        }
        for (int j = 0; j < 4; j++ ) {
            momentan.nächstes = this.array[momentan.x_koordinate][momentan.y_koordinate +1 ];
            momentan = momentan.nächstes;
           }
        for (int j = 0; j < 2; j++ ) {
        momentan.nächstes = this.array[momentan.x_koordinate+1 ][momentan.y_koordinate];
        momentan = momentan.nächstes;
        }

        for (int i = 0; i < 4; i++ ) {
            momentan.nächstes = this.array[momentan.x_koordinate ][momentan.y_koordinate-1];
            momentan = momentan.nächstes;
           }
           for (int j = 0; j < 4; j++ ) {
               momentan.nächstes = this.array[momentan.x_koordinate +1][momentan.y_koordinate];
               momentan = momentan.nächstes;
              }
           for (int j = 0; j < 2; j++ ) {
           momentan.nächstes = this.array[momentan.x_koordinate][momentan.y_koordinate -1];
           momentan = momentan.nächstes;
           }
           for (int i = 0; i < 4; i++ ) {
            momentan.nächstes = this.array[momentan.x_koordinate -1 ][momentan.y_koordinate];
            momentan = momentan.nächstes;
           }
           for (int j = 0; j < 4; j++ ) {
               momentan.nächstes = this.array[momentan.x_koordinate][momentan.y_koordinate-1];
               momentan = momentan.nächstes;
              }
           for (int j = 0; j < 2; j++ ) {
           momentan.nächstes = this.array[momentan.x_koordinate -1 ][momentan.y_koordinate];
           momentan = momentan.nächstes;
           }

           for (int i = 0; i < 4; i++ ) {
            momentan.nächstes = this.array[momentan.x_koordinate ][momentan.y_koordinate+1 ];
            momentan = momentan.nächstes;
           }
           for (int j = 0; j < 4; j++ ) {
               momentan.nächstes = this.array[momentan.x_koordinate - 1][momentan.y_koordinate];
               momentan = momentan.nächstes;
              }
           for (int j = 0; j < 2; j++ ) {
           momentan.nächstes = this.array[momentan.x_koordinate ][momentan.y_koordinate +1 ];
           momentan = momentan.nächstes;
           }

           momentan = this.array[1][6];
           for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.array[momentan.x_koordinate + 1][momentan.y_koordinate ];
            momentan = momentan.nächstes_parken;
            }
            momentan = this.array[6][11];
            for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.array[momentan.x_koordinate][momentan.y_koordinate -1 ];
            momentan = momentan.nächstes_parken;
            }
            momentan = this.array[11][6];
            for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.array[momentan.x_koordinate-1][momentan.y_koordinate ];
            momentan = momentan.nächstes_parken;
            }
            momentan = this.array[6][1];
            for (int j = 0; j < 4; j++ ) {
            momentan.nächstes_parken = this.array[momentan.x_koordinate][momentan.y_koordinate +1 ];
            momentan = momentan.nächstes_parken;
            }
        }


}
