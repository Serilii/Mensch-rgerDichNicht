package klassen;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class testen extends JPanel{
	public static void main (String args []) {

		
		Spielfeld Spielfeld = new Spielfeld();

		// for (int i = 1; i < 11; i++){
		// 	Spielfeld.array[i][1].nächstes = Spielfeld.array[i+1][1];	
		// }

		// for (int i = 1; i < 11; i++){
		// 	Spielfeld.array[11][i].nächstes = Spielfeld.array[11][i+1];	
		// }

		// Figur test = new Figur("PINK", 0, Spielfeld, 1 , 1);

		
		Würfel würfel = new Würfel(20);

		// int x = würfel.würfeln();
		// test.alle_felder_ziehen(x);

		// System.out.println("Du hast eine " + x + " gewürfelt.");

		Spielfeld.verbinde_alle_felder();
		Spielfeld.print_Spielfeld();

        for (int i = 11; i>=1; i--)  {
			System.out.println();
			for (int j = 1; j<12; j++)  {
				if (Spielfeld.array[j][i].figur == null){
				System.out.print(String.format("%02d",(Spielfeld.array[i][j].x_koordinate)) + "|" + String.format("%02d",(Spielfeld.array[i][j].y_koordinate)) + " "); }
				else {
					System.out.print("xoxo  ");
				}
        }

		// for (int i = 11; i>=1; i--)  {
		// 	System.out.println();
		// 	for (int j = 1; j<12; j++)  {
		// 		if (array[i][j].figur == null){
		// 		System.out.print("◯"); }
		// 		else {
		// 			System.out.print("⬤");
		// 		}
        // }


		// ◯ ⬤
}
	
} }
