package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TamGiac extends JFrame implements ActionListener {

	Label lb, lb1, lb2, lb3, lb4;
	TextField txta, txtb, txtc, txtkq;
	Button DienTich, ChuVi, Reset, Exit;
	Panel pn, pn1, pn2, pn3, pn4, pn5, pn6;
	
	public void GUI() {
		
		lb = new Label("Tam Giac");
		lb1 = new Label("Do dai canh a :");
		lb2 = new Label("Do dai canh b :");
		lb3 = new Label("Do dai canh c :");
		lb4 = new Label("Ket qua :");
		
		txta = new TextField();
		txtb = new TextField();
		txtc = new TextField();
		txtkq = new TextField();
		
		DienTich = new Button("DienTich");
		DienTich.addActionListener(this);
		ChuVi = new Button("ChuVi");
		ChuVi.addActionListener(this);
		Reset = new Button("Reset");
		Reset.addActionListener(this);
		Exit = new Button("Exit");
		Exit.addActionListener(this);
		
		pn = new Panel(new GridLayout(6,1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(1,1));
		pn3 = new Panel(new GridLayout(1,1));
		pn4 = new Panel(new GridLayout(1,1));
		pn5 = new Panel(new GridLayout(1,4));
		pn6 = new Panel(new GridLayout(1,1));
		
		pn1.add(lb);
		pn2.add(lb1);
		pn2.add(txta);
		pn3.add(lb2);
		pn3.add(txtb);
		pn4.add(lb3);
		pn4.add(txtc);
		pn5.add(DienTich);
		pn5.add(ChuVi);
		pn5.add(Reset);
		pn5.add(Exit);
		pn6.add(lb4);
		pn6.add(txtkq);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		pn.add(pn5);
		pn.add(pn6);
		
		add(pn);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int a = Integer.parseInt(txta.getText());
		int b = Integer.parseInt(txtb.getText());
		int c = Integer.parseInt(txtc.getText());
		
		if(e.getSource() == DienTich) {
			float p =(float)(a+b+c)/2;
			txtkq.setText(Float.toString((float) Math.sqrt(p*(p-a)*(p-b)*(p-c))));
		}
		
		if(e.getSource() == ChuVi) {
			txtkq.setText(Integer.toString(a + b + c));
		}
		
		if(e.getSource() == Reset) {
			txta.setText("");
			txtb.setText("");
			txtc.setText("");
			txtkq.setText("");
		}
		
		if(e.getSource() == Exit) {
			System.exit(0);
		}
	}
	
	public TamGiac(String title) {
		super(title);
		GUI();
	}
	
	public static void main(String[] args) {
		new TamGiac("Tam giac");
	}

}
