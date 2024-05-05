package klassen;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class testen extends JPanel {
	public static void main (String args []) throws InterruptedException {

		
		Spielfeld Spielfeld = new Spielfeld();

		// for (int i = 1; i < 11; i++){
		// 	Spielfeld.array[i][1].nächstes = Spielfeld.array[i+1][1];	
		// }

		// for (int i = 1; i < 11; i++){
		// 	Spielfeld.array[11][i].nächstes = Spielfeld.array[11][i+1];	
		// }

		Figur test = new Figur("PINK", 0, Spielfeld, 1 , 7);

		
		Würfel würfel = new Würfel(6);

		int x = würfel.würfeln();
		// test.alle_felder_ziehen(x);

		System.out.println("Du hast eine " + x + " gewürfelt.");

		Spielfeld.verbinde_alle_felder();
		Spielfeld.print_Spielfeld();


		
		for (int i= 0; i<20; i++){
			x = würfel.würfeln();
			test.alle_felder_ziehen(x);

			System.out.print("\033[H\033[2J");  
			System.out.flush();
			
			System.out.println("Du hast eine " + x + " gewürfelt.");
			Spielfeld.print_Spielfeld();  
			Thread.sleep(500);

		}
		

	}}
