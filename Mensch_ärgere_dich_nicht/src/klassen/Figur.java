package klassen;

public abstract class Figur {
	// public int x_koordinate; //wenn nötig
	// public int y_koordinate; //wenn nötig
	public String farbe; // Farbe zum abgleichen fürs rausschmeissen oder ob besetzt von gleicher Farbe
	public boolean geparkt; // wenn alle Figuren einer Farbe geparkt: gewonnen
	public Feld feld; // vielleicht lieber Feld koordinaten in die Feldklasse verlagern
	public Feld aus_feld; // das Feld worauf die Figur das Spiel beginnt und hinkommt wenn sie rausgeschmissen wird
	public int gezogene_felder;	//39 felder gezogen -> parken bei nächstes_parken;



	public void ein_feld_ziehen() { // weiterziehen um ein einzelnes Feld
		if (gezogene_felder < 39) {
		this.feld = this.feld.nächstes;
		this.gezogene_felder += 1; 
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

	}

	public void rausfliegen() { // von einer Figur rausgeschmissen werden

	}
}
