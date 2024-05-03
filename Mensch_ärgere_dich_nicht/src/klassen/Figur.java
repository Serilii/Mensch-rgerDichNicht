package klassen;

public abstract class Figur {
	// public int x_koordinate; //wenn nötig
	// public int y_koordinate; //wenn nötig
	public String farbe; // Farbe zum abgleichen fürs rausschmeissen oder ob besetzt von gleicher Farbe
	public boolean geparkt; // wenn alle Figuren einer Farbe geparkt: gewonnen
	public Feld feld; // vielleicht lieber Feld koordinaten in die Feldklasse verlagern
	public Feld aus_feld; // das Feld worauf die Figur das Spiel beginnt und hinkommt wenn sie
							// rausgeschmissen wird

	public void schritt_machen() { // weiterziehen um ein einzelnes Feld

	}

	public void bewegen(int Felder) { // Loop für Anzahl der "Felder" um die man einen "Schritt_macht"

	}

	public void einsteigen() { // mit einer 6 rausgewürfelt werden

	}

	public void rausfliegen() { // von einer Figur rausgeschmissen werden

	}
}
