package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeThiThamKhao extends JFrame {

	private JPanel contentPane;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtc;
	private JTextField kq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeThiThamKhao frame = new DeThiThamKhao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeThiThamKhao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1ED9 d\u00E0i c\u1EA1nh a : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 98, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblDiCnh = new JLabel("\u0110\u1ED9 d\u00E0i c\u1EA1nh b : ");
		lblDiCnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiCnh.setBounds(10, 54, 98, 32);
		contentPane.add(lblDiCnh);
		
		JLabel lblDiCnh_1 = new JLabel("\u0110\u1ED9 d\u00E0i c\u1EA1nh c : ");
		lblDiCnh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiCnh_1.setBounds(10, 97, 98, 32);
		contentPane.add(lblDiCnh_1);
		
		txta = new JTextField();
		txta.setBounds(118, 19, 139, 20);
		contentPane.add(txta);
		txta.setColumns(10);
		
		txtb = new JTextField();
		txtb.setColumns(10);
		txtb.setBounds(118, 62, 139, 20);
		contentPane.add(txtb);
		
		txtc = new JTextField();
		txtc.setColumns(10);
		txtc.setBounds(118, 105, 139, 20);
		contentPane.add(txtc);
		
		JButton btnCircumference = new JButton("T\u00EDnh Chu Vi");
		btnCircumference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				int c = Integer.parseInt(txtc.getText());
				int circumference = a + b + c;
				kq.setText(Integer.toString(circumference));
			}
		});
		btnCircumference.setBounds(118, 147, 139, 23);
		contentPane.add(btnCircumference);
		
		JButton btnArea = new JButton("T\u00EDnh Di\u1EC7n T\u00EDch");
		btnArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(txta.getText());
				int b = Integer.parseInt(txtb.getText());
				int c = Integer.parseInt(txtc.getText());
				float p = (float) (a+b+c)/3;
				kq.setText(Float.toString((float)Math.sqrt(p*(p-a)*(p-b)*(p-c))));
			}
		});
		btnArea.setBounds(118, 192, 139, 23);
		contentPane.add(btnArea);
		
		kq = new JTextField();
		kq.setColumns(10);
		kq.setBounds(118, 234, 139, 20);
		contentPane.add(kq);
		
		JLabel lblDiCnh_1_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblDiCnh_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiCnh_1_1.setBounds(10, 226, 98, 32);
		contentPane.add(lblDiCnh_1_1);
	}
}
