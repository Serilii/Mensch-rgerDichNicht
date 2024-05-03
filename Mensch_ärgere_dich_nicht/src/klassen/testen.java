package klassen;

public class testen {

	public static void main (String args []) {
		Würfel normal = new Würfel();
		int x = normal.würfeln();
		
		Würfel cool = new Würfel(20);
		int y = cool.würfeln();
		
		
	System.out.println("Der normale Würfel würfelte eine " + x);
	System.out.println("Der coole Würfel würfelte eine " + y);
	}
	
}
