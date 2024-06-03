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

/*	notizen
 * 	Figuren können in den parkfeldern zu hoch würfeln und trotzdem aufziehen. Regeln nachschauen
 *  Wenn Figuren geparkt sind und alle anderen aus (also keine figur da die man bewegen KÖNNTE) kann man trotzdem nur einmal würfeln -> muss auf 3 und man muss weitergeben können sonst hängt sich das spiel auf weil man nichts bewegen kann lmao
 * 
 */