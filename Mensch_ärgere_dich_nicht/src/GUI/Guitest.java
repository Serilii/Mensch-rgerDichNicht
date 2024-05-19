package GUI;
import klassen.*;
import javax.swing.*;
import java.awt.*;

public class Guitest {


    public static void main (String args []){
    
        JFrame fenster = new JFrame("Ich bin eine GUI");
    fenster.setSize(800,600);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //main panel (borderlayout)
    JPanel panel_border_main = new JPanel();
    panel_border_main.setLayout(new BorderLayout());
    
    //Unterpanele 
    JPanel panel_oben  = new JPanel();
    JPanel panel_links = new JPanel();
    JPanel panel_mitte = new MyPanel();
    panel_mitte.setBackground(Color.PINK);
    
    //buttons 
    JButton button_links_1 = new JButton("Figur 1");
    button_links_1.setBackground(Color.BLUE);
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
    
    GridLayout layout_mitte = new GridLayout(11,11);
    panel_mitte.setLayout(layout_mitte);
    
    //die unterpanele werden dem main panel zugeordnet mit position im borderlayout
    panel_border_main.add(panel_mitte, BorderLayout.CENTER);
    panel_border_main.add(panel_links, BorderLayout.WEST);
    panel_border_main.add(panel_oben, BorderLayout.NORTH);
    
    fenster.setVisible(true);
    fenster.getContentPane().add(panel_border_main);
    

}
}
