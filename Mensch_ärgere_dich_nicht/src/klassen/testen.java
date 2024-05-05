package klassen;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class testen extends JPanel{
	public static void main (String args []) {
		// JFrame frame = new JFrame("Ich bims 1 Femster");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JButton button = new JButton("Test");
		// button.setBounds(130, 100, 100, 40);

		// frame.add(button);

		// frame.setSize(500, 500);
		// frame.setLayout(null);
		// frame.setVisible(true);

		// Farbe test = new Farbe("Gelb");
		// System.out.println(test.figur_1.farbe);

		Feld [][] array = new Feld[11][11];

		for (int i = 0; i<11; i++)  {
            for (int j = 0; j<11; j++) {
            array[j][i] = new Feld(j+1,i+1);
            }
        }
		
		for (int i = 0; i < 10; i++){
			array[i][0].nächstes = array[i+1][0];	
		}

		for (int i = 0; i < 10; i++){
			array[10][i].nächstes = array[10][i+1];	
		}

		Figur test = new Figur("PINK");
		test.feld = array[0][0];
		array[0][0].figur = test;
		
		Würfel würfel = new Würfel(20);

		int x = würfel.würfeln();
		test.alle_felder_ziehen(x);

		System.out.println("Du hast eine " + x + " gewürfelt.");


        // for (int i = 10; i>=0; i--)  {
		// 	System.out.println();
		// 	for (int j = 0; j<11; j++)  {
		// 		if (array[i][j].figur == null){
		// 		System.out.print(String.format("%02d",(array[i][j].x_koordinate)) + "|" + String.format("%02d",(array[i][j].y_koordinate)) + " "); }
		// 		else {
		// 			System.out.print("xoxo  ");
		// 		}
        // }

		for (int i = 10; i>=0; i--)  {
			System.out.println();
			for (int j = 0; j<11; j++)  {
				if (array[i][j].figur == null){
				System.out.print("◯"); }
				else {
					System.out.print("⬤");
				}
        }


		// ◯ ⬤
}
	
} }
