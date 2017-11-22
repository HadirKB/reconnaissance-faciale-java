package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class login extends JPanel{
	JTextField name = new JTextField(10);
	JTextField pass = new JPasswordField(10);
	Icon n=new ImageIcon("/home/hadour/workspace/Projet/img/bt.png");
	JButton bconn = new JButton(n);
	HashMap<String, String> m=new HashMap<String, String>();
public login() {
	// TODO Auto-generated constructor stub
	name.setText("ali1");
	pass.setText("1234");
	name.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
	        name.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	        // nothing
	    }
	});
	add(name);
	add(pass);
	add(bconn);
	repaint();validate();
	bconn.setBorderPainted(false);
	
	try { 
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	   // setUndecorated(true);
	      
	       
	} catch (Exception e) {
	    e.printStackTrace();
	}
	setBorder(null);
	repaint();validate();
	chargerm();
	repaint();validate();
	bconn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {if ((m.get(name.getText())).equals(pass.getText())) 
			{
				setVisible(false);
				app.user=name.getText();
				app.phasechoix();
				revalidate();repaint();
			}
			else JOptionPane.showMessageDialog(null,"wrong password");
			}catch(NullPointerException ee){//ee.printStackTrace();
			JOptionPane.showMessageDialog(null,"wrong username");
			} 
		}
	}); 
	
} //3306
void chargerm(){
		String u = "root";
		String url = "jdbc:mysql://127.0.0.1:3307/issatso";
		String pw = "19111993";
		try {
			// connexion
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cnx = DriverManager.getConnection(url,
					u, pw);
			java.sql.Statement st = cnx.createStatement();
			String query = "Select pseudo,code from policier;";
			ResultSet rs = st.executeQuery(query);
			// organization des donn�es
			while(rs.next()) {
			 m.put(rs.getString(1),rs.getString(2));} 
			rs.close();
			cnx.close();
		} catch (Exception e) { 
			// to see problems
			e.printStackTrace();
		}
	}
}
