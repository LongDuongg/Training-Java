package Application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MinhHoaCacPhepTinh extends JFrame implements ActionListener {
	
	Label lb, lb1, lb2, lb3;
	TextField txta, txtb, txtkq;
	Button Cong, Tru, Nhan, Chia, Exit, Reset;
	Panel pn, pn1, pn2, pn3, pn4;
	
	public void GUI() {
		lb = new Label("Minh hoa cac phep toan");
		lb1 = new Label("Nhap a :");
		lb2 = new Label("Nhap b :");
		lb3 = new Label("Ket qua :");
		
		txta = new TextField();
		txtb = new TextField();
		txtkq = new TextField();
		
		Cong = new Button("Cong");
		Cong.addActionListener(this);
		Tru = new Button("Tru");
		Tru.addActionListener(this);
		Nhan = new Button("Nhan");
		Nhan.addActionListener(this);
		Chia = new Button("Chia");
		Chia.addActionListener(this);
		Exit = new Button("Exit");
		Exit.addActionListener(this);
		Reset = new Button("Reset");
		Reset.addActionListener(this);
		
		pn = new Panel(new GridLayout(4,1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(3,2));
		pn3 = new Panel(new GridLayout(1,4));
		pn4 = new Panel(new GridLayout(1,2));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtkq);
		
		pn3.add(Cong);
		pn3.add(Tru);
		pn3.add(Nhan);
		pn3.add(Chia);
		
		pn4.add(Exit);
		pn4.add(Reset);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		pn.add(pn4);
		
		add(pn);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Exit) 
			System.exit(0);
		
		int a = Integer.parseInt(txta.getText().trim());
		int b = Integer.parseInt(txtb.getText().trim());
		
		if (e.getSource() == Cong) txtkq.setText(Integer.toString(a + b));
		
		if (e.getSource() == Tru) txtkq.setText(Integer.toString(a - b));
		
		if (e.getSource() == Nhan) txtkq.setText(Integer.toString(a * b));
		
		if (e.getSource() == Chia) txtkq.setText(Float.toString((float)a/b));
		
		
		if (e.getSource() == Reset) {
			txta.setText("");
			txtb.setText("");
			txtkq.setText("");
		}
		
		
	}
	
	public MinhHoaCacPhepTinh(String title) {
		super(title);
		GUI();
	}

	public static void main(String[] args) {
		
		new MinhHoaCacPhepTinh("Minh hoa cac phep toan");
		
	}

	

}
