package Application;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class My_JLabel extends JLabel {

	My_JLabel(){
		
		ImageIcon image = new ImageIcon("logo.jpg");
		
		JFrame frame = new JFrame();
		frame.setTitle("JLabel Goes Here");
		frame.setResizable(true);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
		JLabel label = new JLabel(); // create a label
		label.setText("Bro, do you even code ?"); // set text of label
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of ImageIcon
		label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of ImageIcon
		label.setVerticalAlignment(JLabel.CENTER); // set vertical position of text + icon within label 
		label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of text + icon within label
		label.setForeground(Color.GREEN); // change color of text
		label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // change font, size of text
		label.setIconTextGap(-25); // set gap of text to image
		
		label.setBackground(Color.black); // set background color
		label.setOpaque(true); // display background color
				
		Border border = BorderFactory.createLineBorder(Color.GREEN, 3); // set border line of windows
		label.setBorder(border); // display border line of windows
				
		frame.setLayout(null);
		label.setBounds(100, 100, 350, 350); // set x, y position within frame as well as dimension
		
		frame.add(label);
		frame.pack();
	}
	
}
