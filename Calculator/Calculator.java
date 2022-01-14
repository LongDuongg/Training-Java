package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

	public static void main(String[] args) {
		new Calculator();

	}
	
	public void Calculators() {
		
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setSize(300, 400);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());		
		JTextField p1 = new JTextField("0");
		p1.setFont(new Font("arial", Font.BOLD, 50));
		p1.setEditable(false);
		p1.setHorizontalAlignment(JTextField.RIGHT);	
		frame.add(p1, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();		
		frame.add(p2, BorderLayout.CENTER);		
		String nut [][] = new String[][] {
			
			{"CE", "C", "Back", ",", "/"},
			{"7", "8", "9", "x"},
			{"4", "5", "6", "-"},
			{"1", "2", "3", "+"},
			{"+-", "0", ".", "="}
			
		};
		
		p2.setLayout(new GridLayout(5,4));
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				JButton b = new JButton(nut[i][j]);
				b.setBackground(Color.LIGHT_GRAY);
				p2.add(b);
			}
		}	
		
		frame.setVisible(true);
	}
}
