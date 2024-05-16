package klassen;
import java.awt.*;
import javax.swing.*;


//imma just play a bit with GUIS for now
public class GUI {

    public static JButton Feld_button (String text) {
        JButton x = new JButton(text);
        x.setOpaque(false);
        x.setContentAreaFilled(false);
        x.setBorderPainted(false);
        return x;
    }


    public static void main (String args []) throws InterruptedException {

    JFrame fenster = new JFrame("Ich bin eine GUI");
    fenster.setSize(800,600);
    fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenster.getContentPane().setBackground(Color.PINK);

    //main panel (borderlayout)
    JPanel panel_border_main = new JPanel();
    panel_border_main.setLayout(new BorderLayout());
    
    //Unterpanele 
    JPanel panel_oben  = new JPanel();
    JPanel panel_links = new JPanel();
    JPanel panel_mitte = new JPanel();
    
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
    panel_links.add(Box.createRigidArea(new Dimension(0,5)));
    panel_links.add(button_links_2);
    panel_links.add(button_links_3);
    panel_links.add(button_links_4);
    panel_oben.add(new JButton("oben" ));
    // panel_mitte.add(new JButton("mitte"));
    


    GridLayout layout_mitte = new GridLayout(11,11);
    panel_mitte.setLayout(layout_mitte);

    JButton sammlung[][] = new JButton[12][12];  
    // for (int i = 0; i<12; i++)  {
    //     for (int j = 0; j<12; j++) {
    //         array[j][i] = (String.valueOf(j) + " | " + String.valueOf(i) );
    //         if (j != 0 && i != 0){
    //         // panel_mitte.add(new JButton(j + " | " + i))  ;
    //         }
    //     }
    // }


    Spielfeld Spielfeld = new Spielfeld();


    
    for (int i = 11; i>0; i--)  {
        for (int j = 0; j<12; j++) {
            if (j != 0 && i != 0){
                JButton x = Feld_button("7");
                if (Spielfeld.array[j][i].nächstes != null){
                    x.setBackground(Color.WHITE);
                    x.setOpaque(false);
                    x.setContentAreaFilled(true);
                    x.setBorderPainted(true);
                }
                sammlung[j][i] = x;
                panel_mitte.add(x);
        }}}

        Würfel würfel = new Würfel();
        Farbe Blau = new Farbe("Blau", Spielfeld, 1,11, Spielfeld.array[1][7]); 
        Figur test = new Figur(Blau, 0, Spielfeld, 1 , 7 );


        for (int i = 11; i>0; i--)  {
            for (int j = 0; j<12; j++) {
                if (Spielfeld.array[j][i].figur != null){
                    sammlung[j][i].setBackground(Color.BLUE);  
                }}}


    //die unterpanele werden dem main panel zugeordnet mit position im borderlayout
panel_border_main.add(panel_mitte, BorderLayout.CENTER);
panel_border_main.add(panel_links, BorderLayout.WEST);
panel_border_main.add(panel_oben, BorderLayout.NORTH);
    

Thread.sleep(1000);

button_links_2.setOpaque(true);

button_links_2.setContentAreaFilled(false);
button_links_2.setBorderPainted(false);

button_links_3.setOpaque(false);
// panel_mitte.setBackground(Color.PINK);
    fenster.setVisible(true);
    fenster.getContentPane().add(panel_border_main);
    
test.alle_felder_ziehen(10);

SwingUtilities.updateComponentTreeUI(fenster);

for (int i = 11; i>0; i--)  {
    for (int j = 0; j<12; j++) {
        if (Spielfeld.array[j][i].figur != null){
            sammlung[j][i].setBackground(Color.BLUE);  
        }}}


}
}
