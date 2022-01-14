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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.util.*;
public class DeThiThu2 extends JFrame {

	private JPanel contentPane;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeThiThu2 frame = new DeThiThu2();
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

	public int CountWord(String text) {
		String[] arr = text.split(" ");
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count = i + 1;
		}
		return count;
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
	public DeThiThu2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp Chu\u1ED7i : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 78, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblThcHin = new JLabel("Th\u1EF1c Hi\u1EC7n : ");
		lblThcHin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThcHin.setBounds(10, 46, 78, 24);
		contentPane.add(lblThcHin);
		
		JLabel lblKtQu = new JLabel("K\u1EBFt Qu\u1EA3 : ");
		lblKtQu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKtQu.setBounds(10, 81, 78, 24);
		contentPane.add(lblKtQu);
		
		text = new JTextField();
		text.setBounds(98, 14, 326, 20);
		contentPane.add(text);
		text.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đếm từ", "Đếm từ trùng lặp", "Đảo chuỗi"}));
		comboBox.setBounds(98, 48, 108, 22);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(98, 82, 326, 168);
		contentPane.add(textArea);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				String str = text.getText();
				if(index == 0) {
					int count = CountWord(str);
					textArea.setText(Integer.toString(count));
				}
				
				if(index == 1) {
					textArea.setText(CountDuplicateWord(str));
				}
				
				if(index == 2) {
					textArea.setText(ReverseString(str));
				}
			}
		});
		btnView.setBounds(39, 272, 89, 23);
		contentPane.add(btnView);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				textArea.setText("");
			}
		});
		btnReset.setBounds(175, 272, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(308, 272, 89, 23);
		contentPane.add(btnExit);
	}
}
