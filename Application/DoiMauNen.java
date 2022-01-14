package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoiMauNen extends JFrame implements ActionListener {

	Button Green, Blue, Red, Exit;
	
	public void GUI() {
		Green = new Button("Green");
		Green.addActionListener(this);
		Blue = new Button("Blue");
		Blue.addActionListener(this);
		Red = new Button("Red");
		Red.addActionListener(this);
		Exit = new Button("Exit");
		Exit.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		add(Green);
		add(Red);
		add(Blue);
		add(Exit);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Green) 
			getContentPane().setBackground(Color.green);
		
		if(e.getSource() == Red) 
			getContentPane().setBackground(Color.red);
		
		if(e.getSource() == Blue) 
			getContentPane().setBackground(Color.blue);
		
		if(e.getSource() == Exit)
			System.exit(0);
	}
	
	public DoiMauNen(String title) {
		super(title);
		GUI();
	}
	
	public static void main(String[] args) {
		new DoiMauNen("Doi Mau Nen");
	}

}
