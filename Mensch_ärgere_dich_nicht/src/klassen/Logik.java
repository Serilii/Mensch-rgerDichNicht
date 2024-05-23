package klassen;
import java.util.Scanner;


public class Logik {

	
	public static void main(String args[]) {
		Wuerfel Würfel = new Wuerfel();
		
		Spielfeld Spielfeld = new Spielfeld(Würfel);
		Spielfeld.print_Spielfeld();


		
	}
	
}
