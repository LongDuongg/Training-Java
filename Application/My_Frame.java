package Application;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class My_Frame extends JFrame {
	
	My_Frame(){
		
		this.setTitle("JFrame Title Goes Here"); // set the title of this
		this.setSize(500, 420); // set the x-dimension and the y-dimension of this
		this.setResizable(false); // prevent this from being resized
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of the application
		this.setVisible(true); // make this visible
		
		ImageIcon image = new ImageIcon("logo2.png"); // create a ImageIcon image
		this.setIconImage(image.getImage()); // change the icon of this 
		this.getContentPane().setBackground(Color.white); // change the color of background
		this.getContentPane().setBackground(new Color(250,250,250)); // Customize the color of background by RGB
	}
	
	
	    
}
      