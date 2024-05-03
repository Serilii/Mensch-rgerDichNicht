package klassen;

public class Würfel {

	public int min = 1;
	public int max;		//Anzahl der AUgen des Würfels

	public Würfel() {
		this.max = 6;
	}

	public Würfel(int seiten) {		//überladener constructor falls ich mal nen mega coolen Würfel machen will
		this.max = seiten;		
	}

	public int würfeln() {
		int Augen = (int) (Math.random() * max) + min;
		return Augen;

	}
}
