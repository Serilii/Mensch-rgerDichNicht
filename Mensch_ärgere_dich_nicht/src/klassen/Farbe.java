package klassen;

public class Farbe {
    public Figur figur_1;
    public Figur figur_2;
    public Figur figur_3;
    public Figur figur_4;
    public String farbe;
    public Feld startFeld;
    // public Feld start_feld; //erstes Feld falls eine Figur mit einer 6 reingewürfelt wird 

    public Farbe(String farbe, Spielfeld Spielfeld, int x_obenlinks, int y_obenlinks, Feld startFeld) {
        this.figur_1 = new Figur(this, 1, Spielfeld,    x_obenlinks,        y_obenlinks );
        this.figur_2 = new Figur(this, 2, Spielfeld,    x_obenlinks + 1,    y_obenlinks);
        this.figur_3 = new Figur(this, 3, Spielfeld,    x_obenlinks,        y_obenlinks - 1);
        this.figur_4 = new Figur(this, 4, Spielfeld,    x_obenlinks + 1,    y_obenlinks - 1); 
        //jede Farbe die generiert wird generiert 4 Figuren, man übergibt das Feld oben links als x und y Koordinaten und der Construktor tut alle 4 Figuren im Viereck zusammen 
        this.startFeld = startFeld;
        this.farbe = farbe;

    }
}
