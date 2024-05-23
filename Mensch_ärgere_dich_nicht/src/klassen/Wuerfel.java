package klassen;

public class Wuerfel {

	public int min = 1;
	public int max;		//Anzahl der Augen des Würfels
	public int aktuelle_Zahl;
	
	public Wuerfel() {				// 6 Seitiger Würfel im default Constructor
		this.max = 6;
	}

	public Wuerfel(int seiten) {		//überladener constructor falls ich mal nen mega coolen Würfel machen will
		this.max = seiten;		
	}

	public void wuerfeln() {
		int Augen = (int) (Math.random() * max) + min;		//würfel Funktion returnt Augen als int
		aktuelle_Zahl = Augen;
		//folgene Zeile ist zum bzgfixen, bitte entfernen später
		System.out.println("Der Würfel zeigt eine " +  this.aktuelle_Zahl);
	}
}
