package klassen;

public class Spielfeld {    //Klasse für das gesamte Spielfeld

    public Spielfeld(){ //wenn das Spielfeld mit default generiert wird soll direkt das normale Spielfeld generiert werden
    
        Feld [][] array = new Feld[11][11];   // initialisiere ein 11x11 Array und jeder Eintrag ist ein Feld mit den richtigen koordinaten
        for (int i = 0; i<11; i++)  {
            for (int j = 0; j<11; j++) {
            array[i][j] = new Feld(i + 1,j + 1);    //die +1 machen, dass die Koordinaten nicht bei 0 sondern 1 anfangen
            }
        }


        //generiere jede Farbe , jede Farbe generiert automatisch 4 Figuren (ohne Startfeld bis jetzt)
        Farbe Blau = new Farbe("Blau");
        Farbe Gelb = new Farbe("Gelb");
        Farbe Rot = new Farbe("Rot");
        Farbe Grün = new Farbe("Grün");
        

    }
    
}
