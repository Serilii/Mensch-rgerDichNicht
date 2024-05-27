package klassen;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import GUI.*;



public class main {

	
	public static void main(String args[]) {
		Wuerfel wuerfel = new Wuerfel();
		
		Spielfeld sf = new Spielfeld(wuerfel);
		Guitest Gui = new Guitest(sf);
	
	}
	
}
