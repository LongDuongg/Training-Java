package Application;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class XuLyCoso extends JFrame implements ActionListener {

	Label lb, lb1, lb2, lb3, lb4;
	Button Ok, Reset, Exit;
	TextField txta, txtb, txtc, txtd;
	Panel pn, pn1, pn2, pn3;
	
	public void GUI() {
		Ok = new Button("Ok");
		Ok.addActionListener(this);
		Reset = new Button("Reset");
		Reset.addActionListener(this);
		Exit = new Button("Exit");
		Exit.addActionListener(this);
		
		txta = new TextField();
		txtb = new TextField();
		txtc = new TextField();
		txtd = new TextField();
		
		lb = new Label("Xu ly co so");
		lb1 = new Label("Nhap so nguyen duong");
		lb2 = new Label("He nhi phan");
		lb3 = new Label("He bat phan");
		lb4 = new Label("He thap luc phan");
		
		pn = new Panel(new GridLayout(3,1));
		pn1 = new Panel(new FlowLayout());
		pn2 = new Panel(new GridLayout(4,2));
		pn3 = new Panel(new GridLayout(1, 3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtc);
		pn2.add(lb4);
		pn2.add(txtd);
		
		pn3.add(Ok);
		pn3.add(Reset);
		pn3.add(Exit);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		
		add(pn);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
	public int HeNhiPhan(int dec) {
		int rem, i = 1, sum = 0;
		do {
			rem = dec % 2;
			sum += i*rem;
			dec = dec / 2;
			i *= 10;
		} while(dec > 0);
		return sum;
	}
	
	public int HeBatPhan(int dec) {
		int rem, i = 1, sum = 0;
		do {
			rem = dec % 8;
			sum += i*rem;
			dec /= 8;
			i *= 10;
		} while (dec > 0);
		return sum;
	}
	
	public String HeThapLucPhan(int dec) {
		int i = 0, j = 0;
		int a[] = new int[20];
		String result = "";
		
		do {
			a[j] = dec % 16;
			dec /= 16;
			j++;
		} while(dec > 0);
		
		for(i = j; i >= 0; i--) {
			if(a[i] < 10) {
				result += Integer.toHexString(a[i]);
			} else {
				switch(a[i]) {
					case 10 :
						result += 'A';
						break;
					case 11 :
						result += 'B';
						break;
					case 12 :
						result += 'C';
						break;
					case 13 :
						result += 'D';
						break;
					case 14 :
						result += 'E';
						break;
					case 15 :
						result += 'F';
						break;
				}
			}
		}
		
		return result;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Ok) {
			int a = Integer.parseInt(txta.getText());
			txtb.setText(Integer.toString(HeNhiPhan(a)));
			txtc.setText(Integer.toString(HeBatPhan(a)));
			txtd.setText(HeThapLucPhan(a));
		}
		
		if(e.getSource() == Reset) {
			txta.setText("");
			txtb.setText("");
			txtc.setText("");
			txtd.setText("");
		}
		
		if(e.getSource() == Exit) {
			System.exit(0);
		}
	}
	
	public XuLyCoso(String title) {
		super(title);
		GUI();
	}
	
	public static void main(String[] args) {
		new  XuLyCoso("Xu ly co so");

	}
}
