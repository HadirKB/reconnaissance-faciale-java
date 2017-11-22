package MVC;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;

public class Fonctionalite {
	public static ImageIcon ResizeImage(String ImagePath,int x,int y) { ImageIcon MyImage = new ImageIcon(ImagePath); 
	Image img = MyImage.getImage();
	Image newImg = img.getScaledInstance(x,y, Image.SCALE_SMOOTH);
	ImageIcon image = new ImageIcon(newImg);
	return image; }
	public static BufferedImage ResizeImage2(String ImagePath,int x,int y) { ImageIcon MyImage = new ImageIcon(ImagePath); 
	Image img = MyImage.getImage();
	Image newImg = img.getScaledInstance(x,y, Image.SCALE_SMOOTH);
	BufferedImage image = (BufferedImage) newImg;
	return image; }
	static String[] connecter(String pp){
		String user = "root";
		String url = "jdbc:mysql://127.0.0.1:3307/issatso";
		String pw = "19111993";
		String[] a=new String[2];
		try {
			// connexion
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cnx = DriverManager.getConnection(url,
					user, pw);
			java.sql.Statement st = cnx.createStatement();
			String query = "Select * from personne where pathorigin='"+pp+"' ;";
			ResultSet rs = st.executeQuery(query);
			// organization des donn�es
			
				if(rs.next()) {
			a[0]="Nom: "+rs.getString(1)+' '+rs.getString(2)+"\nC.I.N: "+rs.getString(3)+"\nDate de naissance:\n "+rs.getString(4)+"\nOccupation: "+rs.getString(5)+"\nRecherch�? "+rs.getString(6);
			a[1]=rs.getString(7);} 
			rs.close();
			cnx.close();
		} catch (Exception e) { 
			// to see problems
			e.printStackTrace();
		}
		return a;
	}
	static String[] connecterA(){
		String user = "root";
		String url = "jdbc:mysql://127.0.0.1:3307/issatso";
		String pw = "19111993";
		String[] a=null;
		try {
			// connexion
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection cnx = DriverManager.getConnection(url,
					user, pw);
			java.sql.Statement st = cnx.createStatement();
			String query = "Select pathorigin from personne;";
			ResultSet rs = st.executeQuery(query);
			// organization des donn�es
			int i=0;
			while (rs.next()){i++;}
			rs.first();
			a=new String[i];
			int j=0;
				do {
			a[j]=rs.getString(1);j++;} while(rs.next());
			rs.close();
			cnx.close();
		} catch (Exception e) { 
			// to see problems
			e.printStackTrace();
		}
		return a;
	}
	public static String recherimg(){
		String [] b=connecterA();
		double min=100;
		int i=0; int indx=0;
		while (i<b.length)
			{double j=compare(b[i]);
			if (min>j) {min=j; indx=i;} 
			
			i++;
			}
		
		
		return (b[indx]);
	}
	public static double compare(String s)
	  {
	    BufferedImage img1 = null;
	    BufferedImage img2 = null;
	    try {
	      File url1 = new File(cherche.t1.getText());
	      File url2 = new File(s);
	      img1 = ImageIO.read(url1);
	      img2 = ImageIO.read(url2);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    int width1 = img1.getWidth(null);
	    int width2 = img2.getWidth(null);
	    int height1 = img1.getHeight(null);
	    int height2 = img2.getHeight(null);
	    if ((width1 != width2) || (height1 != height2)) {
	      System.err.println("Error: Images dimensions mismatch");
	      System.exit(1);
	    }
	    long diff = 0;
	    for (int y = 0; y < height1; y++) {
	      for (int x = 0; x < width1; x++) {
	        int rgb1 = img1.getRGB(x, y);
	        int rgb2 = img2.getRGB(x, y);
	        int r1 = (rgb1 >> 16) & 0xff;
	        int g1 = (rgb1 >>  8) & 0xff;
	        int b1 = (rgb1      ) & 0xff;
	        int r2 = (rgb2 >> 16) & 0xff;
	        int g2 = (rgb2 >>  8) & 0xff;
	        int b2 = (rgb2      ) & 0xff;
	        diff += Math.abs(r1 - r2);
	        diff += Math.abs(g1 - g2);
	        diff += Math.abs(b1 - b2);
	      }
	    }
	    double n = width1 * height1 * 3;
	    double p = diff / n / 255.0;
	    return (p * 100.0);
	  }
		
}
