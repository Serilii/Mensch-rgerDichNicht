package klassen;

public class Figur {
	// public int x_koordinate; //wenn nötig
	// public int y_koordinate; //wenn nötig
	public Farbe farbe; // Oberklasse der Farbe
	public boolean geparkt = false; // wenn alle Figuren einer Farbe geparkt: gewonnen
	public Feld feld; // vielleicht lieber Feld koordinaten in die Feldklasse verlagern
	public Feld aus_feld; // das Feld worauf die Figur das Spiel beginnt und hinkommt wenn sie rausgeschmissen wird
	public int gezogene_felder = 0;	//39 felder gezogen -> parken bei nächstes_parken;
	public Feld start_feld; //erstes Feld falls die Figur mit einer 6 reingewürfelt wird , falls das Startfeld in die Figurenklasse kommt
	public int nummer;

	public Figur(Farbe farbe, int nummer, Spielfeld Spielfeld, int x_koordinate, int y_koordinate){
		this.farbe = farbe;
		this.nummer = nummer;
		this.feld = Spielfeld.feldarray[x_koordinate][y_koordinate];
		this.aus_feld = this.feld;
		this.feld.figur = this;
		this.start_feld = this.farbe.startFeld;
		
	}

	// public Figur(String farbe, int x, int y){
	// 	this.farbe = farbe;

	// }

public boolean prüfe_ob_ziel_frei(int Anzahl){
	Feld check = this.feld;
	int check_gezogene_felder = this.gezogene_felder;
		for (int i = 0; i < Anzahl; i++) {
				if (check_gezogene_felder < 39){
				check = check.nächstes;
				check_gezogene_felder += 1;
				} else if (check_gezogene_felder < 43){
					check= check.nächstes_parken;
					check_gezogene_felder+=1;
				} else if (check_gezogene_felder == 43) {
					;
				}
		}
		if (check.figur != null  && check.figur.farbe == this.farbe) {	//wenn das Zielfeld mit einer Figur dieser Farbe besetzt ist: nix
			return false;
		}	else if (check.figur!= null && check.figur.farbe != this.farbe) { //wenn das Zielfeld mit einer Figur einer anderen Farbe besetzt ist: rauswerfen und hinlaufen
			check.figur.rausfliegen();
			return true;			// wenn das Feld leer ist( also ausschlussverfahren ) dann grünes Licht und lets go
		}	else {
			return true;
		}

}


	public void ein_feld_ziehen() { // weiterziehen um ein einzelnes Feld
		if (gezogene_felder >=43){		
			;
		}
		else if (gezogene_felder < 39) {
		
		this.feld = this.feld.nächstes; //diese figur zeigt auf das nächste feld
		this.gezogene_felder += 1;
		
		} 
		else {
			// this.feld.figur = null;		//müssten eigentlich raus diese Zeilen
			this.feld = this.feld.nächstes_parken;
			this.gezogene_felder += 1;
			this.geparkt = true;
			// this.feld.figur = this;	//müssten eigentlich raus diese Zeilen
		}

	}

	public void alle_felder_ziehen(int Anzahl) { // Loop für Anzahl der "Felder" um die man einen "Schritt_macht"
		if (prüfe_ob_ziel_frei(Anzahl)) {
			this.feld.figur = null;		//lösen vom feld
			for (int i = 0; i < Anzahl; i++ ) {
				this.ein_feld_ziehen();
				}
				this.feld.figur = this; //das neue feld dieser figur zeigt zurück auf diese figur 
		}
		else {
			; //pass
		}
	}


	public void einsteigen() { // (mit z.B. einer 6) eingewürfelt werden
		this.feld.figur = null;
		this.feld = this.start_feld;
		this.feld.figur = this;
	}


	public void rausfliegen() { // von einer Figur rausgeschmissen werden
		this.gezogene_felder = 0;
		this.feld.figur = null;
		this.feld = this.aus_feld;
		this.feld.figur = this;
	}
}
