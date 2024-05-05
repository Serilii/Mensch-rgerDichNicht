package klassen;

public class Feld {
	public int x_koordinate;		
	public int y_koordinate;			
	public Feld nächstes = null;			//nächstes Feld in der Reihelfolge wenn Mittelfeld, sonst : None
	public Feld nächstes_parken = null;	//falls man ganz durch ist: dann parken feld.  sonst :  None
	public Figur figur;

	public Feld(){
		//default Constructor
	}
	
	public Feld(int x , int y){
		this.x_koordinate = x;
		this.y_koordinate = y;
	}

	

	//39 felder gezogen -> parken bei nächstes_parken;
} 
