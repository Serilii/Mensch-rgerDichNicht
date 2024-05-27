package klassen;

public class Wuerfel {

	public int min = 1;
	public int max;		//Anzahl der Augen des Würfels
	public int aktuelle_Zahl;
	public int versuche;
	
	public Wuerfel() {				// 6 Seitiger Würfel im default Constructor
		this.versuche = 3;
		this.max = 6;
	}

	public Wuerfel(int seiten) {		//überladener constructor falls ich mal nen mega coolen Würfel machen will
		this.versuche = 3;
		this.max = seiten;		
	}



	public void wuerfeln() {
		if (versuche > 0) {
			int Augen = (int) (Math.random() * max) + min;		//würfel Funktion returnt Augen als int
			aktuelle_Zahl = Augen;
			this.versuche -= 1;
		}		
	}

}
