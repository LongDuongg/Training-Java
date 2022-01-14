package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SoNguyenTo extends JFrame implements ActionListener {
	
	Label lb, lb1, lb2;
	TextField txtn, txtkq;
	Button Tim, Reset, Exit;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("Cac so nguyen to <= n");
		lb1 = new Label("Nhap n :");
		lb2 = new Label("Ket qua :");
		
		txtn = new TextField();
		txtkq = new TextField();
		
		Tim = new Button("Tim");
		Tim.setSize(30, 30);
		Tim.addActionListener(this);
		Reset = new Button("Reset");
		Reset.setSize(30, 30);
		Reset.addActionListener(this);
		Exit = new Button("Exit");
		Exit.setSize(30, 30);
		Exit.addActionListener(this);
		
		pn = new Panel(new GridLayout(3,1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(2,2));
		pn3 = new Panel(new GridLayout(1,3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txtn);
		pn2.add(lb2);
		pn2.add(txtkq);
		
		pn3.add(Tim);
		pn3.add(Reset);
		pn3.add(Exit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		
		add(pn);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	static Boolean Check(int n) {
		if(n < 2) return false;
		for(int i = 2; i <= Math.ceil(n/2); i++) {
			if (n % i == 0) 
				return false;
		}
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Tim) {
			int n = Integer.parseInt(txtn.getText().trim());
			String s = "";
			for(int i = 0; i <= n; i++) {
				if(Check(i)) {
					s += i;
					s += " ";
				}
				txtkq.setText(s);
			}
		}
		
		if (e.getSource() == Reset) {
			txtn.setText("");
			txtkq.setText("");
		}
		
		if (e.getSource() == Exit) 
			System.exit(0);
	}
	
	public SoNguyenTo(String title) {
		super(title);
		GUI();
	}

	public static void main(String[] args) {
		new SoNguyenTo("Tim so nguyen to");
	}

}
