package klassen;
import GUI.*;



public class start {

	public Spielfeld sf;

	public static void main(String args[]) {
		Wuerfel wuerfel = new Wuerfel();
		Spielfeld sf = new Spielfeld(wuerfel);
		Guitest Gui = new Guitest(sf);

		System.out.println(Gui.sf.Farbe_am_Zug.farbe + " hat gewonnen!");
		System.out.println("Danke fürs spielen! Bitte alles schließen.");
	}
	
}
