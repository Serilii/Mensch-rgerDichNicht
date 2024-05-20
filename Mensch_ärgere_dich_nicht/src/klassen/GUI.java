package klassen;
import java.awt.*;
import javax.swing.*;

import GUI.MyLayeredPane;
import GUI.MyPanel;
import GUI.Spielbrett_Panel;


//imma just play a bit with GUIS for now
public class GUI {


    public static void main (String args []) throws InterruptedException {

    JFrame fenster = new JFrame("Ich bin eine GUI");
    fenster.setSize(1100,1100);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenster.getContentPane().setBackground(Color.PINK);

    //main panel (borderlayout)
    JPanel panel_border_main = new JPanel();
    panel_border_main.setPreferredSize(new Dimension(1100,1100));
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


    


    // fenster.pack();
    fenster.getContentPane().add(panel_border_main);
    fenster.setVisible(true);
    

}
}
