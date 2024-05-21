package GUI;
import klassen.*;
import javax.swing.*;
import java.awt.*;

public class Guitest {

    public static void main (String args []) throws InterruptedException {
        JFrame fenster = new JFrame("Ich bin eine GUI");
        fenster.setSize(1100,1100);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.getContentPane().setBackground(Color.PINK);
        fenster.setResizable(false);
    
        //main panel (borderlayout)
        JPanel panel_border_main = new JPanel();
        // panel_border_main.setPreferredSize(new Dimension(1100,1100));
        panel_border_main.setBounds(0,0,1100,1100);
        panel_border_main.setLayout(new BorderLayout());
        
        //Unterpanele 
        JPanel panel_oben  = new JPanel();
        // panel_oben.setPreferredSize(new Dimension(880, 120));
        JPanel panel_links = new JPanel();
        // panel_links.setPreferredSize(new Dimension(120, 880));
        // JPanel panel_mitte = new JPanel();
        Spielbrett_Panel panel_mitte = new Spielbrett_Panel();
        
        //buttons 
        JButton button_links_1 = new JButton("Figur 1");
        JButton button_links_2 = new JButton("Figur 2");
        JButton button_links_3 = new JButton("Figur 3");
        JButton button_links_4 = new JButton("Figur 4");
        
        //Layout für Panel links (1,4)
        // GridLayout layout_panel_links = new GridLayout(4,1);
        // panel_links.setLayout(layout_panel_links);
        BoxLayout layout_links = new BoxLayout(panel_links, BoxLayout.Y_AXIS);
        panel_links.setLayout(layout_links);
    
        panel_links.add(button_links_1);
        panel_links.add(Box.createRigidArea(new Dimension(0,5)));           // <--- damit kann man manuel Abstände zwischen Buttons machen
        panel_links.add(button_links_2);
        panel_links.add(button_links_3);
        panel_links.add(button_links_4);
        panel_oben.add(new JButton("oben" ));
        
    
        JLayeredPane layerPane = new JLayeredPane();
        layerPane.setBounds(0,0,1100, 1100);


        //die unterpanele werden dem main panel zugeordnet mit position im borderlayout
        panel_border_main.add(panel_mitte, BorderLayout.CENTER);
        panel_border_main.add(panel_links, BorderLayout.WEST);
        panel_border_main.add(panel_oben, BorderLayout.NORTH);
    
        layerPane.add(panel_border_main, Integer.valueOf(0));

            
        // fenster.pack();
        fenster.add(layerPane);
        fenster.setVisible(true);


        Spielfeld spielfeld = new Spielfeld();

        spielfeld.Blau.figur_1.einsteigen();
        spielfeld.Blau.figur_1.alle_felder_ziehen(45);

        System.out.println("" + spielfeld.Blau.startFeld.x_koordinate);

        for (Farbe farbe : spielfeld.farbenarray) {
            for (Figur figur : farbe.figurenarray){
            JLabel x = new JLabel(new ImageIcon("C:/Users/Serilii/Downloads/blau3.png"));
            x.setBounds(73 + 80 * figur.feld.x_koordinate, 35 + 80 * figur.feld.y_koordinate, 60 ,60 );
            // x.setBackground(new Color(0,0,0,0));
            layerPane.add(x, Integer.valueOf(5));
            }
            }
        
            System.out.println("hello3");

}
}
