package klassen;

public class Figur {
	// public int x_koordinate; //wenn nötig
	// public int y_koordinate; //wenn nötig
	public String farbe; // Farbe zum abgleichen fürs rausschmeissen oder ob besetzt von gleicher Farbe
	public boolean geparkt = false; // wenn alle Figuren einer Farbe geparkt: gewonnen
	public Feld feld; // vielleicht lieber Feld koordinaten in die Feldklasse verlagern
	public Feld aus_feld; // das Feld worauf die Figur das Spiel beginnt und hinkommt wenn sie rausgeschmissen wird
	public int gezogene_felder = 0;	//39 felder gezogen -> parken bei nächstes_parken;
	public Feld start_feld; //erstes Feld falls die Figur mit einer 6 reingewürfelt wird , falls das Startfeld in die Figurenklasse kommt
	public int nummer;

	public Figur(String farbe, int nummer, Spielfeld Spielfeld, int x_koordinate, int y_koordinate){
		this.farbe = farbe;
		this.nummer = nummer;
		this.feld = Spielfeld.array[x_koordinate][y_koordinate];
		this.feld.figur = this;
	}

	// public Figur(String farbe, int x, int y){
	// 	this.farbe = farbe;

	// }

	public void ein_feld_ziehen() { // weiterziehen um ein einzelnes Feld
		if (gezogene_felder < 39) {
		this.feld.figur = null;		//lösen vom feld
		this.feld = this.feld.nächstes; //diese figur zeigt auf das nächste feld
		this.gezogene_felder += 1;
		this.feld.figur = this; //das neue feld dieser figur zeigt zurück auf diese figur 
		} else {
			this.feld = this.feld.nächstes_parken;
		}
	
	}

	public void alle_felder_ziehen(int Anzahl) { // Loop für Anzahl der "Felder" um die man einen "Schritt_macht"
		for (int i = 0; i < Anzahl; i++ ) {
			this.ein_feld_ziehen();
		}
	}

	public void einsteigen() { // mit einer 6 rausgewürfelt werden
		this.feld = this.start_feld;
	}

	public void rausfliegen() { // von einer Figur rausgeschmissen werden
		this.gezogene_felder = 0;
		this.feld = this.aus_feld;
	}
}
