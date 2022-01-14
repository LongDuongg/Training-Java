package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cau1 extends JFrame {

	private JPanel contentPane;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cau1 frame = new Cau1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void SortString(String[] arr) {
		int i,j;
		for(i = 0; i < arr.length; i++) {
			for(j = i+1; j < arr.length; j++) {
				if(arr[i].compareTo(arr[j]) < 0) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public String CountWord(String text) {
		String[] arr = text.split(" ");
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count = i + 1;
		}
		return "Tổng số từ trong chuỗi là : " + count;
	}

	public String CountDuplicateWord(String text) {
		String[] arr = text.split(" ");
		SortString(arr);
		String s = arr[0];
		String display = ""; 
		int count = 0;
		int b = 0;
		int i;
		for( i = 1; i < arr.length; i++) {
			if( ! arr[i].equals(s) ) {
				display += s + " : " + (i - b) + " lần";
				display += "\n";
				s = arr[i];
				b = i;
			}
		}
		display += s + " : " + (i - b) + " lần";
		return display;
	}

	public String ReverseString(String text) {
		String[] arr = text.split(" ");
		String reverse = "";
		for(int i = arr.length - 1; i >= 0; i--) {
			reverse += arr[i];
			reverse += " ";
		}
		return reverse;
	}
	
	/**
	 * Create the frame.
	 */
	public Cau1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập Chuỗi : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 27, 81, 24);
		contentPane.add(lblNewLabel);
		
		text = new JTextField();
		text.setColumns(10);
		text.setBounds(98, 30, 326, 20);
		contentPane.add(text);
		
		JLabel lblThcHin = new JLabel("Thực Hiện : ");
		lblThcHin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThcHin.setBounds(10, 62, 78, 24);
		contentPane.add(lblThcHin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đếm từ", "Đếm từ trùng lặp", "Đảo chuỗi"}));
		comboBox.setBounds(98, 64, 108, 22);
		contentPane.add(comboBox);
		
		JLabel lblKtQu = new JLabel("Kết Quả : ");
		lblKtQu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKtQu.setBounds(10, 97, 78, 24);
		contentPane.add(lblKtQu);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(98, 98, 326, 168);
		contentPane.add(textArea);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				String str = text.getText();
				if(index == 0) {
					String count = CountWord(str);
					textArea.setText(count);
				}
				
				if(index == 1) {
					textArea.setText(CountDuplicateWord(str));
				}
				
				if(index == 2) {
					textArea.setText(ReverseString(str));
				}
			}
		});
		btnView.setBounds(86, 302, 89, 23);
		contentPane.add(btnView);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				textArea.setText("");
			}
		});
		btnReset.setBounds(222, 302, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(355, 302, 89, 23);
		contentPane.add(btnExit);
	}
}
