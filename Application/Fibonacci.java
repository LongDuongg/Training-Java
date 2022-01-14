package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fibonacci extends JFrame implements ActionListener {
	
	Label lb, lb1, lb2;
	TextField txta, txtkq;
	Button Ok, Reset, Exit;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("Kiem tra a co thuoc day Fibonacci");
		lb1 = new Label("Nhap a :");
		lb2 = new Label("Ket qua :");
		
		txta = new TextField();
		txtkq = new TextField();
		
		Ok = new Button("Tim");
		Ok.setSize(30, 30);
		Ok.addActionListener(this);
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
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtkq);
		
		pn3.add(Ok);
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
	
	static int Fibo(int n) {
		if(n == 0 || n == 1) return 1;
		else return Fibo(n-1) + Fibo(n-2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Ok) {
			int a = Integer.parseInt(txta.getText());
			int i, m = 1000;
			for(i = 0; i < m; i++) {
				if(Fibo(i) == a) {
					txtkq.setText("Co, so " + txta.getText() + " thuoc vi tri thu " + i + " cua day");
					break;
				} else 
					txtkq.setText("Khong, so " + txta.getText() + " khong thuoc day so Fibonacci");
			}
		}
		
		if(e.getSource() == Reset) {
			txta.setText("");
			txtkq.setText("");
		}
		
		if(e.getSource() == Exit)
			System.exit(0);
	}
	
	public Fibonacci(String title) {
		super(title);
		GUI();
	}

	public static void main(String[] args) {
		new Fibonacci("Kiem tra a thuoc fibonacci");
	}

}
