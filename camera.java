package MVC;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;


import javax.swing.JButton;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;


public class camera extends JApplet {

	private static final long serialVersionUID = 3517366452510566924L;
	
	JButton take=new JButton("une photo");
	private Dimension size = WebcamResolution.QVGA.getSize();
	private Webcam webcam = null;
	static WebcamPanel panel = null;
	static String a="";

	public camera() {
		super();
		System.out.println("created");
	}

	@Override
	public void start() {
		super.start();
		webcam = Webcam.getDefault();
		webcam.setViewSize(size);
		
		panel = new WebcamPanel(webcam, false);
		panel.setLayout(new FlowLayout());
		panel.setFPSDisplayed(true);
		panel.add(take);
		add(panel);
		take.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BufferedImage image = webcam.getImage();
				try {
					Random r=new Random();
					a="/home/hadour/Images/"+r.nextInt(1000)+".jpg";
					ImageIO.write(image, "JPG", new File(a));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		if (webcam.isOpen()) {
			webcam.close();
		}

		int i = 0;
		do {
			if (webcam.getLock().isLocked()) {
				System.out.println("Waiting for lock to be released " + i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					return;
				}
			} else {
				break;
			}
		} while (i++ < 3);

		webcam.open(); 		System.out.println("opened");

		panel.start();		System.out.println("start");

	}

	@Override
	public void destroy() {
		webcam.close(); 		System.out.println("closed");

	
	}

	@Override
	public void stop() {
		webcam.close();
	}

	@Override
	public void init() {
		System.out.println("Init...");
	}
}