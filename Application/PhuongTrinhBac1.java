package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PhuongTrinhBac1 extends JFrame implements ActionListener {
	
	Label lb, lb1, lb2, lb3;
	TextField txta, txtb, txtkq;
	Button Tinh, Reset, Thoat;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		lb = new Label("GIAI PHUONG TRINH BAC NHAT");
		lb1 = new Label("Nhap a :");
		lb2 = new Label("Nhap b :");
		lb3 = new Label("Ket qua");
		
		txta = new TextField();
		txtb = new TextField();
		txtkq = new TextField();
		
		Tinh = new Button("Tinh");
		Tinh.addActionListener(this);
		Reset = new Button("Reset");
		Reset.addActionListener(this);
		Thoat = new Button("Thoat");
		Thoat.addActionListener(this);
		
		pn = new Panel(new GridLayout(3,1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(3,2));
		pn3 = new Panel(new GridLayout(1,3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtkq);
		
		pn3.add(Tinh);
		pn3.add(Reset);
		pn3.add(Thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);

		add(pn);
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Tinh) {
			int a = Integer.parseInt(txta.getText());
			int b = Integer.parseInt(txtb.getText());
			if (a != 0)
				txtkq.setText(Float.toString((float)-b/a));
			else
				if (b == 0) txtkq.setText("Phuong trinh co vo so nghiem");
				else txtkq.setText("Phuong trinh vo nghiem");
		}
		
		if (e.getSource() == Reset) {
			txta.setText("");
			txtb.setText("");
			txtkq.setText("");
		}
		
		if (e.getSource() == Thoat)
			System.exit(0);
		
	}
	
	public PhuongTrinhBac1(String title) {
		super(title);
		GUI();
	}
	
	public static void main(String[] args) {
		new PhuongTrinhBac1("Giai Phuong Trinh Bac Nhat");
	}



	
	
}
