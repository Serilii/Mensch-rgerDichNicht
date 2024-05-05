package klassen;

public class Würfel {

	public int min = 1;
	public int max;		//Anzahl der Augen des Würfels

	public Würfel() {				// 6 Seitiger Würfel im default Constructor
		this.max = 6;
	}

	public Würfel(int seiten) {		//überladener constructor falls ich mal nen mega coolen Würfel machen will
		this.max = seiten;		
	}

	public int würfeln() {
		int Augen = (int) (Math.random() * max) + min;		//würfel Funktion returnt Augen als int
		return Augen;

	}
}
