package MVC;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.jws.WebParam;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import java.net.*;
import java.nio.channels.FileChannel;
public class cherche extends JPanel {
	
	File fc;
	static JTextField t1= new JTextField("");
	private JTextArea t2= new JTextArea("Info...");;
	JPanel panel_2 = new JPanel();
	JLabel img1 = new JLabel("");
	JLabel img2 = new JLabel("");
	static camera c=new camera();
	JFrame f=new JFrame();
	JButton bide = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/bi.png", 40, 45));
	JButton bs = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/bc.png", 20, 15));
	JButton bc = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/bs.png", 20, 15));
	JButton br = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/ra.png", 30, 30));
	JButton ba = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/ba.png", 30, 30));
	JButton bh = new JButton(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/bh.png", 30, 30));
	public cherche() {
		// TODO Auto-generated constructor stub
		setSize(403, 485);
		setLocation(50, 50);
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		   // setUndecorated(true);
		      
		       
		} catch (Exception ee) {
		    ee.printStackTrace();
		} 
		try {
			add(new JPanelWithBackground("/home/hadour/workspace/Projet/img/bg.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		revalidate(); repaint();
		panel_2.setLayout(null);
		panel_2.setBounds(22, 55, 371, 325);
		add(panel_2);
		
		setLayout(null);
		
		
		t1.setBounds(22, 11, 200, 20);
		add(t1);
		t1.setColumns(10);	
		
		
		bs.setBounds(229, 10, 70, 23);
		add(bs);
		bc.setBounds(315, 10, 70, 23);
		add(bc);
		revalidate(); repaint();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 402, 400, 90);
		
		
		bh.setSize(89, 23);
		panel_1.add(bh);
		
		ba.setSize(89, 23);
		panel_1.add(ba);
		
		br.setSize(89, 23);
		panel_1.add(br);
		
		panel_1.revalidate(); panel_1.repaint();
		add(panel_1);
		
		
		img1.setIcon(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/face.png",120,120));
		img1.setBounds(25, 11, 132, 131);
		panel_2.add(img1);
		img1.setVisible(true);
		
		img2.setIcon(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/face.png",120,120));
		img2.setBounds(25, 153, 138, 131);
		panel_2.add(img2);
		repaint();validate();
		
		t2.setColumns(50);
		t2.setBounds(188, 94, 173, 150);
		panel_2.add(t2);
		
		
		bide.setBounds(237, 30, 89, 50);
		bide.setBorderPainted(false);
		panel_2.add(bide);
		repaint();validate();
		setVisible(false);
		bc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				c.init();
				c.start();
				f.pack(); f.add(c.panel);
				f.setLocation(450,300);
				f.setSize(WebcamResolution.QVGA.getSize());
				f.setVisible(true);
				f.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				      f.dispose();
				      c.stop();
				      t1.setText(c.a);
				        }
				    }
				);
				
		
			}
		});
		bide.addActionListener(new ActionListener() {
																														
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
		
			String[] b=Fonctionalite.connecter(Fonctionalite.recherimg());
				t2.setText(b[0]);
				img1.setIcon(Fonctionalite.ResizeImage(t1.getText(),120,120));
				img2.setIcon(Fonctionalite.ResizeImage(b[1],120,120));
				
				repaint();
				validate(); 
			}
		 });
		
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
		             String path=selectedFile.getAbsolutePath();
		             t1.setText(path);
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
		              img1.setIcon(Fonctionalite.ResizeImage(path,120,120));
		          }
		           //if the user click on save in Jfilechooser
		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
		          repaint();validate();
		        }
		    });
		ba.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				img2.setIcon(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/face.png",120,120));
				img1.setIcon(Fonctionalite.ResizeImage("/home/hadour/workspace/Projet/img/face.png",120,120));
				t2.setText("Info ...");
				t1.setText("");
			}
		});
		bh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Desktop d=Desktop.getDesktop();
				try {
					d.print(fc);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		br.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String info=t2.getText();
				try{
				FileInputStream ff=new FileInputStream(new File("/home/hadour/workspace/Projet/policerapport.jrxml"));
				JasperDesign jd=JRXmlLoader.load(ff);
				JasperReport js=JasperCompileManager.compileReport(jd);
				Map<String, Object> k=new HashMap<String,Object>();
				k.put("Parameter1", info);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				k.put("Parameter2", "Policier responsable: "+app.user+"\n"+dateFormat.format(date));
				JasperPrint jp=JasperFillManager.fillReport(js, k);
				dateFormat = new SimpleDateFormat("dd MM yyyy HH mm ss");
				fc=new File("/home/hadour/Bureau/"+dateFormat.format(date)+".pdf");
				FileOutputStream ff2=new FileOutputStream(fc);
				jp.toString();
				JasperExportManager.exportReportToPdfStream(jp, ff2);
				ff.close();
				ff2.flush();
			
				ff2.close();
				}
				catch(Exception ke){ke.printStackTrace();}
			}
		});
	}

}
