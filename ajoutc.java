package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.github.sarxos.webcam.WebcamResolution;

public class ajoutc extends JPanel{
	JFrame f=new JFrame();
	JPanel panel_2=new JPanel();
	JPanel panel = new JPanel();
	JButton bs = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/bc.png", 20, 15));
	JButton bc = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/bs.png", 20, 15));
	private JTextField textField_1;
	private JTextField nom;
	private JTextField prenom;
	private JTextField cin;
	private JTextField daten;
	private JTextField occupation;
	private JTextField path;
	private JTextField lnom=new JTextField();
	private JTextField lprenom=new JTextField();
	private JTextField lcin=new JTextField();
	private JTextField ldaten=new JTextField();
	private JTextField loccupation=new JTextField();
	private JTextField lpath=new JTextField();
	JComboBox comboBox = new JComboBox();
	JButton ba = new JButton("annuler");
	JButton bv = new JButton("valider");
public ajoutc() {
	// TODO Auto-generated constructor stub
	JPanel panel_2 = new JPanel();
	panel_2.setLayout(null);
	panel_2.setBounds(22, 55, 371, 325);
	setSize(403, 459);
	setLocation(35, 47);
	
	add(panel_2);
	
	nom = new JTextField();
	lnom.setText("nom");
	nom.setBounds(50, 24, 86, 20);
	lnom.setBounds(0, 24, 46, 20);
	panel_2.add(lnom);
	panel_2.add(nom);
	nom.setColumns(10);
	
	prenom = new JTextField();
	lprenom.setText("prenom");
	prenom.setBounds(50, 69, 86, 20);
	lprenom.setBounds(0, 69, 46, 20);
	panel_2.add(lprenom);
	panel_2.add(prenom);
	prenom.setColumns(10);
	
	cin = new JTextField();
	lcin.setText("C.I.N");
	cin.setBounds(50, 113, 86, 20);
	lcin.setBounds(0, 113, 46, 20);
	panel_2.add(cin);
	panel_2.add(lcin);
	cin.setColumns(10);
	
	daten = new JTextField();
	ldaten.setText("daten");
	daten.setBounds(50, 158, 86, 20);
	panel_2.add(daten);
	ldaten.setBounds(0, 158, 46, 20);
	panel_2.add(ldaten);
	daten.setColumns(10);
	
	occupation = new JTextField();
	loccupation.setText("occupation");
	occupation.setBounds(50, 202, 86, 20);
	panel_2.add(occupation);
	loccupation.setBounds(0, 202, 46, 20);
	panel_2.add(loccupation);
	occupation.setColumns(10);
	
	path = new JTextField();
	lpath.setText("path");
	path.setBounds(220, 24, 106, 20);
	panel_2.add(path);
	lpath.setBounds(171, 24, 46, 20);
	panel_2.add(lpath);
	path.setColumns(20);
	
	
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"NOM", "OUI"}));
	comboBox.setBounds(240, 69, 48, 20);
	panel_2.add(comboBox);
	textField_1 = new JTextField("Recherch�?");
	
	textField_1.setBounds(171, 69, 62, 20);
	panel_2.add(textField_1);
	
	
	setLayout(null);
	JTextField lblNewLabel = new JTextField("Ajouter un citoyen:");
	lblNewLabel.setBounds(172, 11, 158, 33);
	add(lblNewLabel);
	

	JPanel panel_1 = new JPanel();
	panel_1.setBounds(24, 402, 369, 34);
	add(panel_1);
	
	
	panel_1.add(ba);
	
	
	panel_1.add(bv);
	repaint(); validate();
	
	setVisible(false);
	ba.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			cin.setText("");
			nom.setText("");
			prenom.setText("");
			daten.setText("");
			comboBox.setSelectedIndex(0);
			path.setText("");
			occupation.setText("");
			
			
			
		}
	});
	bv.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				String user = "root";
				String url = "jdbc:mysql://127.0.0.1:3307/issatso";
				String pw = "19111993";
				try {
					// connexion
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection cnx = DriverManager.getConnection(url,
							user, pw);
					java.sql.Statement st = cnx.createStatement();
					String query = "Select grade from policier where pseudo='"+app.user+"' ;";
					ResultSet rs = st.executeQuery(query);
					// organization des donn�es
					String s="";
					System.out.println(nom);
						if(rs.next()) {s=rs.getString(1);} 
					rs.close();
					cnx.close();
					if(s.equals("A3")==false) {JOptionPane.showMessageDialog(null,"vs n'avez pas le droit");}
					else{
					query = "INSERT INTO `personne`(`nom`, `prenom`, `cin`, `datenai`,`occupation`,`recherchee`,`pathorigin`) VALUES('"+(nom.getText())+"','"+(prenom.getText())+"','"+(cin.getText())+"','"+(daten.getText())+"','"+(occupation.getText())+"','"+(comboBox.getSelectedItem())+"','"+(path.getText())+"')";
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection cn = DriverManager.getConnection(url,
							user, pw);
					try {java.sql.Statement stt = cn.createStatement();
					stt.executeUpdate(query);
				       //cn.commit();
					JOptionPane.showMessageDialog(null,"l'ajout es confirm�");
				    } catch (SQLException ex) {
				    	JOptionPane.showMessageDialog(null,"CIN d�ja existe!");
				    } finally {
				        try {
				            cn.close();
				        } catch (SQLException ee) {
				        	JOptionPane.showMessageDialog(null,"SQL ERREUR!");
				        }
				    }
					
					} 
					 
					
				} catch (Exception ee) { 
					// to see problems
					ee.printStackTrace();
				}
			}
		
	});
	bc.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			cherche.c.init();
			cherche.c.start();
			f.pack(); f.add(cherche.c.panel);
			f.setLocation(450,300);
			f.setSize(WebcamResolution.QVGA.getSize());
			f.setVisible(true);
			f.addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			      f.dispose();
			      cherche.c.stop();
			      path.setText(cherche.c.a);
			        }
			    }
			);
			
	
		}
	});
	bc.setBounds(280, 180, 70, 23);
	add(bc);
	bs.setBounds(195, 180, 70, 23);
	add(bs);
	bs.addActionListener(new ActionListener() {
		
		  public void actionPerformed(ActionEvent e) {
		        
	          JFileChooser file = new JFileChooser();
	       //   file.setCurrentDirectory(new File(System.getProperty("user.home")));
	          file.setCurrentDirectory(new File("/home/hadour/Images"));
	          //filter the files
	          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
	          file.addChoosableFileFilter(filter);
	          int result = file.showSaveDialog(null);
	           //if the user click on save in Jfilechooser
	          if(result == JFileChooser.APPROVE_OPTION){
	              File selectedFile = file.getSelectedFile();
	             String p=selectedFile.getAbsolutePath();
	             path.setText(p);
	             try {
	     			add(new JPanelWithBackground("/home/hadour/workspace/Projet/img/bg.png"));
	     		} catch (IOException e1) {
	     			// TODO Auto-generated catch block
	     			e1.printStackTrace();
	     		}
	             try { 
	     		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	     		   // setUndecorated(true);
	     		      
	     		       
	     		} catch (Exception ek) {
	     		    ek.printStackTrace();
	     		}
	              
	          }
	           //if the user click on save in Jfilechooser
	          else if(result == JFileChooser.CANCEL_OPTION){
	              System.out.println("No File Select");
	          }
	          repaint();validate();
	        }
	    });
}
}
