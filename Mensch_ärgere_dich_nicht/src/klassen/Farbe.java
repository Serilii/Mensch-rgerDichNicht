package klassen;

public class Farbe {
    public Figur figur_1;
    public Figur figur_2;
    public Figur figur_3;
    public Figur figur_4;
    

    public Farbe(String farbe) {
       this.figur_1 = new Figur(farbe);
       this.figur_2 = new Figur(farbe);
       this.figur_3 = new Figur(farbe);
       this.figur_4 = new Figur(farbe); //test
    }
}
