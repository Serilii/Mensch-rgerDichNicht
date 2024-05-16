package klassen;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class testen extends JPanel {
	public static void main (String args []) throws InterruptedException {

		System.out.println("Hallo bitte geben sie was ein");
		Scanner scanner = new Scanner(System.in);
		String stest = scanner.nextLine();
		System.out.println(stest);


		Spielfeld Spielfeld = new Spielfeld();

		Farbe Blau = new Farbe("Blau", Spielfeld, 1,11, Spielfeld.array[1][7]);
		Figur test = new Figur(Blau, 0, Spielfeld, 1 , 7 );
		Figur gegner = new Figur(Blau, 0, Spielfeld, 4, 7 );
		Figur gegner2 = new Figur(Blau, 0, Spielfeld, 5,  10);

		Würfel würfel = new Würfel(6);

		int x = würfel.würfeln();
		// test.alle_felder_ziehen(x);

		// System.out.println("Du hast eine " + x + " gewürfelt.");

		// System.out.print("\033[H\033[2J"); 
		// Spielfeld.verbinde_alle_felder();
		// Spielfeld.print_Spielfeld();

		// test.alle_felder_ziehen(1);

		// Thread.sleep(500);
		// System.out.print("\033[H\033[2J"); 
		// Spielfeld.print_Spielfeld();

		// test.alle_felder_ziehen(5);
		
		// Thread.sleep(500);
		// System.out.print("\033[H\033[2J"); 
		// Spielfeld.print_Spielfeld();

		// test.alle_felder_ziehen(5);

		// Thread.sleep(500);
		// System.out.print("\033[H\033[2J"); 
		// Spielfeld.print_Spielfeld();

		
		
		for (int i= 0; i<20; i++){
			x = würfel.würfeln();
			test.alle_felder_ziehen(x);

			System.out.print("\033[H\033[2J");  
			System.out.flush();
			
			System.out.println("Du hast eine " + x + " gewürfelt.");
			Spielfeld.print_Spielfeld();  
			Thread.sleep(500);

		}
		
		Spielfeld.print_Spielfeld_koordinaten();

	}}
