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

    JButton button_links_1;
    JButton button_links_2;
    JButton button_links_3;
    JButton button_links_4;
    JButton button_oben;

    BoxLayout layout_links;

    JLayeredPane layerPane;
    JLayeredPane layerPane_buffer;

    Spielfeld sf = new Spielfeld();

    FigurPanel blau_1 = new FigurPanel(sf.Blau.figur_1);
    FigurPanel blau_2 = new FigurPanel(sf.Blau.figur_2);
    FigurPanel blau_3 = new FigurPanel(sf.Blau.figur_3);
    FigurPanel blau_4 = new FigurPanel(sf.Blau.figur_4);

    FigurPanel gruen_1 = new FigurPanel(sf.Grün.figur_1);
    FigurPanel gruen_2= new FigurPanel(sf.Grün.figur_2);
    FigurPanel gruen_3= new FigurPanel(sf.Grün.figur_3);
    FigurPanel gruen_4= new FigurPanel(sf.Grün.figur_4);
    
    FigurPanel rot_1 = new FigurPanel(sf.Rot.figur_1);
    FigurPanel rot_2 = new FigurPanel(sf.Rot.figur_2);
    FigurPanel rot_3 = new FigurPanel(sf.Rot.figur_3);
    FigurPanel rot_4 = new FigurPanel(sf.Rot.figur_4);

    FigurPanel gelb_1 = new FigurPanel(sf.Gelb.figur_1);
    FigurPanel gelb_2 = new FigurPanel(sf.Gelb.figur_2);
    FigurPanel gelb_3 = new FigurPanel(sf.Gelb.figur_3);
    FigurPanel gelb_4 = new FigurPanel(sf.Gelb.figur_4);

    public Guitest(){
        fenster = new JFrame("Ich bin eine GUI");
        fenster.setSize(1100,1100);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.getContentPane().setBackground(Color.PINK);
        fenster.setResizable(false);
    
        //main panel (borderlayout)
        panel_border_main = new JPanel();
        panel_border_main.setBounds(0,0,1100,1100);
        panel_border_main.setLayout(new BorderLayout());
        
        //Unterpanele 
        panel_oben  = new JPanel();
        // panel_oben.setPreferredSize(new Dimension(880, 120));
        panel_links = new JPanel();
        // panel_links.setPreferredSize(new Dimension(120, 880));
        // JPanel panel_mitte = new JPanel();
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

        fenster.add(layerPane);
        fenster.setVisible(true);

    }

    public void testbewegung(){
        blau_1.figur.alle_felder_ziehen(2);
        blau_1.setBounds(76 + 80 * blau_1.figur.feld.x_koordinate, 0 + 80 * blau_1.figur.feld.y_koordinate, blau_1.getHeight() ,blau_1.getHeight() );

        gruen_1.figur.alle_felder_ziehen(1);
        gruen_1.setBounds(76 + 80 * gruen_1.figur.feld.x_koordinate, 0 + 80 * gruen_1.figur.feld.y_koordinate, gruen_1.getHeight() ,gruen_1.getHeight() );
        layerPane.repaint();
        layerPane.revalidate();
    }

    public void bewege_figur_bild(Figur figur) {
        figur.figurpanel.setBounds(76 + 80 * figur.feld.x_koordinate, 0 + 80 * figur.feld.y_koordinate, figur.figurpanel.getHeight() ,figur.figurpanel.getHeight() );  
    }

    public void draw_field(){
           
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


        blau_1.setBounds(76 + 80 * blau_1.figur.feld.x_koordinate, 0 + 80 * blau_1.figur.feld.y_koordinate, blau_1.getHeight() ,blau_1.getHeight() );
        layerPane.add(blau_1, Integer.valueOf(5));
        blau_1.figur.einsteigen();

        layerPane.add(gruen_1, Integer.valueOf(5));
        gruen_1.figur.einsteigen();

        layerPane.repaint();
        layerPane.revalidate();


    }

    public void redraw(){


            
            layerPane.repaint();
            layerPane.revalidate();
    }

    public static void main (String args []) throws InterruptedException {

        Guitest Gui = new Guitest();

        Gui.draw_field();


                for (int i = 0; i < 50; i++ ){
                    Thread.sleep(100);
                    Gui.testbewegung();
                    }
                }}
        

                


