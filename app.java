package MVC;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

public class app extends JFrame{
static JPanel plogin=new login(); //panel de login
static JPanel pajoutp=new ajoutp(); //panel d'ajout d'un police
static JPanel pcherche=new cherche();//panel de recherche d'image
static JPanel pajoutc=new ajoutc();//panel d'ajout des citoyens
static JFrame fchoix=new choix(); //popup de choix
JLabel lrights=new JLabel("(C) ISSATSO-2017"); //signature
static JPanel tjr=new menup();
static String user="";













//and more
public app() {
	// TODO Auto-generated constructor stub
	init();
	phaselogin();
	setLayout(null);
	add(pcherche);
	validate();repaint();
	add(tjr);
	add(pajoutp);
	validate();repaint();
	add(pajoutc);
	validate();repaint();
	
}
static void calmdown(){
	pajoutp.setVisible(false);
	pajoutc.setVisible(false);
	pcherche.setVisible(false);
	plogin.setVisible(false);
}
static void phaseajoutc(){
	pajoutc.setVisible(true);
}
static void phaseajoutp(){
	pajoutp.setVisible(true);
}
static void phaserecherche(){
	pcherche.setVisible(true);
}
static void phasechoix(){
	
	fchoix.setVisible(true);

	
}
void phaselogin(){
	add(plogin);
	 revalidate(); repaint();
	
}
void init(){
	setTitle("Version 1.0");
	ImageIcon img = new ImageIcon("/home/hadour/workspace/Projet/img/bt.png"); //to be changed
	setIconImage(img.getImage());
	setLocation(80,50);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,700);
	setVisible(true);
	try { 
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());     
	} catch (Exception e) {
	    e.printStackTrace();
	}
	try {
		getContentPane().add(new JPanelWithBackground("/home/hadour/workspace/Projet/img/bg.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//repaint(); validate();
	JPanel psouth=new JPanel();
	psouth.add(lrights);
	add(psouth,BorderLayout.SOUTH);
	repaint(); validate();
}

public static void main(String[] args) {
	new app();
}

}
