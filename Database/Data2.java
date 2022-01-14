package Database;
import java.sql.*;
import javax.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Data2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInfo;
	private JTextField txtQuery;
	private JTable table;
	private JTable table_1;
	private JTable DataTable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data2 frame = new Data2();
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
	public Data2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input Information");
		lblNewLabel.setBounds(73, 11, 145, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblSql = new JLabel("SQL :");
		lblSql.setBounds(171, 44, 47, 21);
		lblSql.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblSql);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(228, 14, 308, 20);
		contentPane.add(txtInfo);
		txtInfo.setColumns(10);
		
		txtQuery = new JTextField();
		txtQuery.setBounds(228, 47, 308, 20);
		txtQuery.setColumns(10);
		contentPane.add(txtQuery);
		
		table = new JTable();
		table.setBounds(10, 358, 683, -225);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(217, 305, 289, -84);
		contentPane.add(table_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 78, 663, 286);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(636, 11, 17, 248);
		panel.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(0, 258, 634, 17);
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		panel.add(scrollBar_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 589, -216);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 634, 259);
		panel.add(scrollPane_1);
		
		DataTable = new JTable();
		DataTable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		DataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Address", "Total"
			}
		));
		scrollPane_1.setViewportView(DataTable);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = txtInfo.getText();
					String username = "root";
					String password = "123456";
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stmt = con.createStatement();
					
					String query = txtQuery.getText();
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						int id = rs.getInt("Id");
						String name = rs.getString("Name");
						String address = rs.getString("Address");
						int total = rs.getInt("Total");
						DefaultTableModel model = (DefaultTableModel)DataTable.getModel();
						model.addRow(new Object[] {
								id, name, address, total
						});
					}
					rs.close();
					stmt.close();
				} catch(Exception exception) {
					
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSubmit.setBounds(30, 371, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setText("");
				txtQuery.setText("");
				DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
				int rowCount = model.getRowCount();
				for(int i = rowCount - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnReset.setBounds(292, 374, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.setBounds(604, 374, 89, 23);
		contentPane.add(btnCancel);
	}
}
