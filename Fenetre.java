
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
   
    
    private JTextField entreC = new JTextField();
   
    
    private JTextField entreF = new JTextField();
   
    
   
    private JButton btn = new JButton ("Valider");
    private JButton label2 = new JButton("?");//("cliquez sur valider ou la touche Entrer");


    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test2 = new JMenu("A propos");
    private JMenuItem item1 = new JMenuItem("Effacer");
    private JMenuItem item2 = new JMenuItem("Fermer");
    private JMenuItem item3 = new JMenuItem("?");


    
    public Fenetre(){
        this.setTitle("CONVERTISSEUR DE DEGRES 1.0");
        this.setSize(300, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        


       
        
        initcomposant();
       
        btn.addActionListener(new BoutonListener());
        entreC.addKeyListener(new ClavierListener());
        entreF.addKeyListener(new ClavierListener());
        
        this.setContentPane(container);
        this.setVisible(true);
    }
   
    public void initcomposant(){
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        JLabel labelC = new JLabel("Celsuis    :");
       

        JLabel labelF = new JLabel("Fahrenheit :");
    
        JPanel entreCPanel = new JPanel(); 

        JPanel entreFPanel = new JPanel(); 
        JPanel btnpanel = new JPanel();


        //les menus
        this.test1.add(item1);
        this.test1.addSeparator();
        this.test1.add(item2);
        this.test2.add(item3);
        label2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                ImageIcon img = new ImageIcon("imge.png");
                String mess = "Apres avoir saisir la valeur de la temperature,\n";
                mess += "cliquez sur le bouton valider ou la touche Entrer de votre clavier \n";
              
                jop.showMessageDialog(null, mess, "Aide",
                JOptionPane.INFORMATION_MESSAGE, img);
            }
        });
        item3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane jop = new JOptionPane();
                ImageIcon img = new ImageIcon("imge.png");
                String mess = "Merci !\n J'espère que mon programme vous a ete utile!\n";
                mess += "Je suis je suis H.joseph\n";
                mess += "\n A la prochaine!!!";
                jop.showMessageDialog(null, mess, "À propos", 
                JOptionPane.INFORMATION_MESSAGE, img);
            }
        });
        item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                entreC.setText("");
                entreF.setText("");
            }
            });
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
            });
        this.menuBar.add(test1);
        this.menuBar.add(test2);
        this.setJMenuBar(menuBar);
        //menos fin



        

        Font police = new Font("Arial", Font.BOLD, 14);
        Dimension irisD = new Dimension(150, 30);

        btnpanel.add(btn);
        //cool
       
        btn.setBackground(Color.white);
        btn.setForeground(Color.BLUE);
        label2.setBackground(Color.white);
        label2.setForeground(Color.ORANGE);
        //cool
        
        entreC.setFont(police);
        entreC.setPreferredSize(irisD);
        entreC.setForeground(Color.RED);

        entreF.setFont(police);
        entreF.setPreferredSize(irisD);
        entreF.setForeground(Color.BLUE);

        entreCPanel.add(labelC);
        entreCPanel.add(entreC );

        entreFPanel.add(labelF);
        entreFPanel.add(entreF);
        entreFPanel.add(btnpanel);

       

        container.add(entreCPanel,  BorderLayout.NORTH);
        container.add(entreFPanel, BorderLayout.CENTER);
        
        container.add(label2, BorderLayout.SOUTH);
       

    }
    public void calcul(){
        
        ///*
            if(entreC.getText() != null){
                try {
                    Double nbr1 = Double.parseDouble(entreC.getText());
                    Double result =celcuisFa(nbr1 );
                    Double resultF = arrondi(result,2);
                    String j = new String();

                    j = j.valueOf(resultF);
                    entreF.setText(j);
                }
                catch(Exception p)
                {
                    entreC.setText("");
                    //entreF.setText("");
                    //System.out.println("erreur");
                    label2.setText("erreur saisie");
                    
                   
                }  
            }
            if(entreF.getText() != null){
                try {
                   
                    
                    Double nbr2 = Double.parseDouble(entreF.getText());
                   
                    Double result1 =faCelcuis(nbr2 );
                    Double resultC = arrondi(result1,2);
                    String f = new String();
                    
                    f = f.valueOf(resultC);
                    entreC.setText(f);
                    
                   
                }
                catch(Exception p)
                {
                    //entreC.setText("");
                    entreF.setText("");
                    label2.setText("erreur saisie");
                    //System.out.println("erreur");
                   
                }
               
                

            }
            //*/
            /*
            if(entreC.getText() != null || entreF.getText() != null) { 
                if (entreC.getText() != null && entreF.getText() == "0")
                    try {
                    
                        Double nbr1 = Double.parseDouble(entreC.getText());
                        Double result =celcuisFa(nbr1 );
                        Double resultF = arrondi(result,2);
                        String j = new String();

                        j = j.valueOf(resultF);
                        entreF.setText(j);
                    
                    }
                    catch(Exception p)
                    {

                        entreC.setText("");
                        try {
                    
                        
                            Double nbr2 = Double.parseDouble(entreF.getText());
                        
                            Double result1 =faCelcuis(nbr2 );
                            Double resultC = arrondi(result1,2);
                            String f = new String();
                            
                            f = f.valueOf(resultC);
    
                            entreC.setText(f);
                        
                        }
                        catch(Exception t)
                        {
                            
                            entreF.setText("");
    
                        
                        }
                        
                    
                    }
                else   {
                    try {
                    
                        
                        Double nbr2 = Double.parseDouble(entreF.getText());
                    
                        Double result1 =faCelcuis(nbr2 );
                        Double resultC = arrondi(result1,2);
                        String f = new String();
                        
                        f = f.valueOf(resultC);

                        entreC.setText(f);
                    
                    }
                    catch(Exception p)
                    {
                        
                        entreF.setText("");
                        try {
                    
                            Double nbr1 = Double.parseDouble(entreC.getText());
                            Double result =celcuisFa(nbr1 );
                            Double resultF = arrondi(result,2);
                            String j = new String();
    
                            j = j.valueOf(resultF);
                            entreF.setText(j);
                        
                        }
                        catch(Exception t)
                        {
    
                            entreC.setText("");
                        }

                    
                    }

                }

            }
            */
           // else System.out.println("Rien looo");
           
        //}
    }

    public double celcuisFa(double cel ) {
		
		double result;
		result = ((9.0/5.0)* cel) +32.0;
		return result;
		
	}
	public double faCelcuis(double fah ) {
		double resultCel = ((fah - 32)* 5 )/ 9;
		
		return resultCel;
	}
	
	public  double arrondi(double A, int B) {
		return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10,B);
		}

    class BoutonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            calcul();
        }
    }

    class ClavierListener implements KeyListener{
        public void keyPressed(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {
            //System.out.println("Code touche relâchée : " + event.getKeyCode() + " - caractère touche relâchée : " +event.getKeyChar());
            if(event.getKeyCode() == 10){
                calcul();
           }
         
           
            
        }
        public void keyTyped(KeyEvent event) {
            //System.out.println("Code touche tapée : " + event.getKeyCode() + " - caractère touche tapée : " + event.getKeyChar());
            
            
        }
        }
}