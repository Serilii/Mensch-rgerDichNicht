package GUI;
import klassen.*;
import javax.swing.*;
import java.awt.*;

public class Guitest {
    JFrame fenster;
    JPanel panel_border_main;
    JPanel panel_oben;
    JPanel panel_links;
    Spielbrett_Panel panel_mitte;
    //JPanel würfelPanel;

    JButton button_links_1;
    JButton button_links_2;
    JButton button_links_3;
    JButton button_links_4;
    JButton button_oben;
    //JButton Spieleranzeige;

    BoxLayout layout_links;

    JLayeredPane layerPane;
    JLayeredPane layerPane_buffer;

    FigurPanel blau_1; 
    FigurPanel blau_2;
    FigurPanel blau_3; 
    FigurPanel blau_4; 
    FigurPanel[] array_FigurPanele_blau ;

    FigurPanel gruen_1; 
    FigurPanel gruen_2;
    FigurPanel gruen_3;
    FigurPanel gruen_4;
    FigurPanel[] array_FigurPanele_gruen ;

    FigurPanel rot_1; 
    FigurPanel rot_2;
    FigurPanel rot_3;
    FigurPanel rot_4;
    FigurPanel[] array_FigurPanele_rot;

    FigurPanel gelb_1; 
    FigurPanel gelb_2;
    FigurPanel gelb_3;
    FigurPanel gelb_4; 
    FigurPanel[] array_FigurPanele_gelb ;

    //es fehlt noch die funktionalität der buttons, ein JLabel oben um zu zeigen wer dran ist, und vielleicht eine würfel animation

    //generiert das Fenster, zeichnet die Figuren rein vom Spielfeld die man übergibt
    public Guitest(Spielfeld sf){
        fenster = new JFrame("Ich bin eine GUI");
        fenster.setSize(1100,1100);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.getContentPane().setBackground(Color.PINK);
        fenster.setResizable(false);
    
        panel_border_main = new JPanel();
        panel_border_main.setBounds(0,0,1100,1100);
        panel_border_main.setLayout(new BorderLayout());
        
        //Unterpanele 
        panel_oben  = new JPanel();
        panel_links = new JPanel();
        panel_mitte = new Spielbrett_Panel();
        panel_mitte.setDoubleBuffered(true);

        //buttons  
        button_links_1 = new JButton("Figur 1");
        button_links_2 = new JButton("Figur 2");
        button_links_3 = new JButton("Figur 3");
        button_links_4 = new JButton("Figur 4");
        button_oben = new JButton("oben" );

        layout_links = new BoxLayout(panel_links, BoxLayout.Y_AXIS);

        // panel_links.add(Box.createRigidArea(new Dimension(0,5)));           // <--- damit kann man manuel Abstände zwischen Buttons machen
    
        layerPane = new JLayeredPane(); 
        layerPane.setBounds(0,0,1100, 1100);
        layerPane.setDoubleBuffered(true);

        layerPane_buffer = new JLayeredPane(); 
        layerPane_buffer.setBounds(0,0,1100, 1100);
        layerPane.setDoubleBuffered(true);

        //erstelle die FigurenPanele, verbinde sie hin undzurück mit den übergebenen Figuren, und packe sie in arrays zum iterieren
        blau_1 = new FigurPanel(sf.Blau.figur_1);
        blau_2 = new FigurPanel(sf.Blau.figur_2);
        blau_3 = new FigurPanel(sf.Blau.figur_3);
        blau_4 = new FigurPanel(sf.Blau.figur_4);
        array_FigurPanele_blau = new FigurPanel[] {blau_1, blau_2,  blau_3, blau_4};

        gruen_1 = new FigurPanel(sf.Grün.figur_1);
        gruen_2= new FigurPanel(sf.Grün.figur_2);
        gruen_3= new FigurPanel(sf.Grün.figur_3);
        gruen_4= new FigurPanel(sf.Grün.figur_4);
        array_FigurPanele_gruen = new FigurPanel[] { gruen_1,  gruen_2,   gruen_3,  gruen_4};

        rot_1 = new FigurPanel(sf.Rot.figur_1);
        rot_2 = new FigurPanel(sf.Rot.figur_2);
        rot_3 = new FigurPanel(sf.Rot.figur_3);
        rot_4 = new FigurPanel(sf.Rot.figur_4);
        array_FigurPanele_rot = new FigurPanel[] {rot_1, rot_2,  rot_3, rot_4};

        gelb_1 = new FigurPanel(sf.Gelb.figur_1);
        gelb_2 = new FigurPanel(sf.Gelb.figur_2);
        gelb_3 = new FigurPanel(sf.Gelb.figur_3);
        gelb_4 = new FigurPanel(sf.Gelb.figur_4);
        array_FigurPanele_gelb = new FigurPanel[] {gelb_1, gelb_2,  gelb_3, gelb_4};

        //ich schmeisse alle arrays[] in ein array[][] damit der code schöner aussieht bei 4 Iterationen hintereinander
        FigurPanel[][] array_alle_FigurenPanel_arrays_lol = new FigurPanel[][] {array_FigurPanele_blau, array_FigurPanele_gelb, array_FigurPanele_gruen, array_FigurPanele_rot};

        //iteriere die arrays[] in der liste der arrays[][]  ///was man nicht alles tut für Übersichtlichkeit
        for (FigurPanel[] array: array_alle_FigurenPanel_arrays_lol) {
        for (FigurPanel panel : array){
            panel.setBounds(76 + 80 * panel.figur.feld.x_koordinate, 0 + 80 * panel.figur.feld.y_koordinate, panel.getHeight() ,panel.getHeight() );
            layerPane.add(panel, Integer.valueOf(5));
            }
        }

        fenster.add(layerPane);
        fenster.setVisible(true);
    }

    //nur zum bugfixen, kann später raus
    public void testbewegung(){
        blau_1.figur.alle_felder_ziehen(2);
        blau_1.setBounds(76 + 80 * blau_1.figur.feld.x_koordinate, 0 + 80 * blau_1.figur.feld.y_koordinate, blau_1.getHeight() ,blau_1.getHeight() );

        gruen_1.figur.alle_felder_ziehen(1);
        gruen_1.setBounds(76 + 80 * gruen_1.figur.feld.x_koordinate, 0 + 80 * gruen_1.figur.feld.y_koordinate, gruen_1.getHeight() ,gruen_1.getHeight() );
        layerPane.repaint();
        layerPane.revalidate();
    }

    //verschiebt das Panel der übergebenen Figur
    public void bewege_figur_bild(Figur figur) {
        figur.figurpanel.setBounds(76 + 80 * figur.feld.x_koordinate, 0 + 80 * figur.feld.y_koordinate, figur.figurpanel.getHeight() ,figur.figurpanel.getHeight() );  
        layerPane.repaint();
        layerPane.revalidate();
    }

    //zeichnet 
    public void zeichne_Gui(){
           
        panel_links.setLayout(layout_links);
        panel_links.add(button_links_1);
        panel_links.add(button_links_2);
        panel_links.add(button_links_3);
        panel_links.add(button_links_4);
        panel_oben.add(button_oben);

        panel_border_main.add(panel_mitte, BorderLayout.CENTER);
        panel_border_main.add(panel_links, BorderLayout.WEST);
        panel_border_main.add(panel_oben, BorderLayout.NORTH);
        layerPane.add(panel_border_main, Integer.valueOf(0));

        blau_1.figur.einsteigen();
        gruen_1.figur.einsteigen();

        layerPane.repaint();
        layerPane.revalidate();
    }

    //vielleicht später nützlich zum bugfixen
    public void redraw(){            
            layerPane.repaint();
            layerPane.revalidate();
    }

    public static void main (String args []) throws InterruptedException {

        Spielfeld sf = new Spielfeld();
        Guitest Gui = new Guitest(sf);

        Gui.zeichne_Gui();

                for (int i = 0; i < 50; i++ ){
                    Thread.sleep(100);
                    Gui.testbewegung();
                    }
                }}
        

                


