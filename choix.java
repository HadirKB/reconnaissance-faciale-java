package MVC;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class choix extends JFrame {
	int x=70, y=70;
	Icon b1i=Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/b1.png",x,y);
	JButton b1=new JButton(b1i);
	Icon b2i=Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/b2.png",x,y);
	JButton b2=new JButton(b2i);
	Icon b3i=Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/b3.png",x,y);
	JButton b3=new JButton(b3i);
	public choix() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		//setLocation(150,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		   // setUndecorated(true);
		      
		       
		} catch (Exception e) {
		    e.printStackTrace();
		}
		repaint();
		validate();
		setLocation(155,300);
		pack();
		b1.setToolTipText("Ajouter police");
		b2.setToolTipText("Tester une identification");
		b3.setToolTipText("Ajouter des citoyens");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				app.tjr.setVisible(true);
				app.phaserecherche();
				
				dispose();
	}

});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				app.tjr.setVisible(true);
				app.phaseajoutp();
				
				dispose();
				
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				app.tjr.setVisible(true);
				app.phaseajoutc();
				
				dispose();
			}
		});
		
	}
}
