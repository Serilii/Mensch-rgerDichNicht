package klassen;

public class testen {

	public static void main (String args []) {
	// 	Würfel normal = new Würfel();
	// 	int x = normal.würfeln();
		
	// 	Würfel cool = new Würfel(20);
	// 	int y = cool.würfeln();

	// System.out.println("Der normale Würfel würfelte eine " + x);
	// System.out.println("Der coole Würfel würfelte eine " + y);

		Feld testfeld = new Feld(0,0);
		Feld testfeld_2 = new Feld(10,10);
		testfeld_2.x_koordinate = 17;
		testfeld.nächstes = testfeld_2;
		testfeld_2.x_koordinate = 100;

		System.out.println(testfeld.nächstes.x_koordinate);

}
	
}
