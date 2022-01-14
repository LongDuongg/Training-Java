package Application;
import java.sql.*;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student_Management extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentID;
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtPostcode;
	private JTextField txtTelephone;
	private JTable DataTable;
	
	private static String url = "jdbc:mysql://localhost:3306/student_management";
	private static String username = "root";
	private static String password = "123456";

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	private JTextField txtID;
	
	/*=======================Function=======================*/
	
	public void UpdateDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			pst = con.prepareStatement("Select * From Student");
			
			rs  = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int socot = rsmd.getColumnCount();
			
			DefaultTableModel model = (DefaultTableModel)DataTable.getModel();
			model.setRowCount(0);
			
			while(rs.next()) {
				Vector columnsData = new Vector();
				for(int i = 0; i < socot; i++) {
					columnsData.add(rs.getInt("ID"));
					columnsData.add(rs.getInt("StudentID"));
					columnsData.add(rs.getString("FirstName"));
					columnsData.add(rs.getString("Surname"));
					columnsData.add(rs.getString("Address"));
					columnsData.add(rs.getString("Postcode"));
					columnsData.add(rs.getInt("Telephone"));
				}
				model.addRow(columnsData);
				
			}
			
		} catch(Exception e) {
			
		}
	}
	
	
	
	
	/*=======================Function=======================*/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Management frame = new Student_Management();
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
	public Student_Management() {
		setTitle("Student Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 139, 139), 8));
		panel.setBounds(0, 0, 1039, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 139, 139), 8));
		panel_1.setBounds(816, 136, 201, 539);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					pst = con.prepareStatement("Insert into Student(ID, StudentID, FirstName, Surname, Address, Postcode, Telephone) Values(?, ?, ?, ?, ?, ?, ?);");
					
					pst.setString(1, txtID.getText());
					pst.setString(2, txtStudentID.getText());
					pst.setString(3, txtFirstName.getText());
					pst.setString(4, txtSurname.getText());
					pst.setString(5, txtAddress.getText());
					pst.setString(6, txtPostcode.getText());
					pst.setString(7, txtTelephone.getText());
					
					pst.executeUpdate();
					
					UpdateDB();
					
				} catch(Exception error) {
					
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnAdd.setBounds(20, 113, 160, 56);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					pst = con.prepareStatement("Update Student set StudentID = ?, FirstName = ?, Surname = ?, Address = ?, Postcode = ?, Telephone = ? Where ID = ? ;");
					
					pst.setString(7, txtID.getText());
					pst.setString(1, txtStudentID.getText());
					pst.setString(2, txtFirstName.getText());
					pst.setString(3, txtSurname.getText());
					pst.setString(4, txtAddress.getText());
					pst.setString(5, txtPostcode.getText());
					pst.setString(6, txtTelephone.getText());
					
					pst.executeUpdate();
					
					UpdateDB();
					
				} catch(Exception error) {}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnUpdate.setBounds(20, 202, 160, 56);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					pst = con.prepareStatement("Delete from Student where ID = ?;");
					
					DefaultTableModel model = (DefaultTableModel)DataTable.getModel();
					int selectedRow = DataTable.getSelectedRow();
					
					int ID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
					
					pst.setInt(1, ID);
					
					pst.executeUpdate();
					
					UpdateDB();
					
					txtID.setText("");
					txtStudentID.setText("");
					txtFirstName.setText("");
					txtSurname.setText("");
					txtAddress.setText("");
					txtPostcode.setText("");
					txtTelephone.setText("");
					
				} catch(Exception err) {}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnDelete.setBounds(20, 285, 160, 56);
		panel_1.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtStudentID.setText("");
				txtFirstName.setText("");
				txtSurname.setText("");
				txtAddress.setText("");
				txtPostcode.setText("");
				txtTelephone.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnReset.setBounds(20, 365, 160, 56);
		panel_1.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnExit.setBounds(20, 453, 160, 56);
		panel_1.add(btnExit);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					stmt = con.createStatement();
					
					String query = "Select * From Student;";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						int ID = rs.getInt("ID");
						int StudentID = rs.getInt("StudentID");
						String FirstName = rs.getString("FirstName");
						String Surname = rs.getString("Surname");
						String Address = rs.getString("Address");
						String Postcode = rs.getString("Postcode");
						int Telephone = rs.getInt("Telephone");
						
						DefaultTableModel model = (DefaultTableModel)DataTable.getModel();
						model.addRow(new Object[] {ID, StudentID, FirstName, Surname, Address, Postcode, Telephone});
					}
					rs.close();
					stmt.close();
				} catch(Exception err) {
					
				}
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnShow.setBounds(20, 25, 160, 56);
		panel_1.add(btnShow);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(23, 22, 994, 103);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MySQL Connection");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(210, 11, 590, 73);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 139, 139), 8));
		panel_1_1.setBounds(23, 136, 783, 539);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewL = new JLabel(" Student ID");
		lblNewL.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewL.setBounds(30, 63, 147, 43);
		panel_1_1.add(lblNewL);
		
		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtStudentID.setBounds(205, 69, 551, 31);
		panel_1_1.add(txtStudentID);
		txtStudentID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblFirstName.setBounds(30, 106, 147, 37);
		panel_1_1.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSurname.setBounds(56, 148, 113, 37);
		panel_1_1.add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddress.setBounds(67, 190, 102, 37);
		panel_1_1.add(lblAddress);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPostcode.setBounds(56, 233, 121, 31);
		panel_1_1.add(lblPostcode);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTelephone.setBounds(36, 269, 133, 37);
		panel_1_1.add(lblTelephone);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(205, 109, 551, 31);
		panel_1_1.add(txtFirstName);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtSurname.setColumns(10);
		txtSurname.setBounds(205, 151, 551, 31);
		panel_1_1.add(txtSurname);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAddress.setColumns(10);
		txtAddress.setBounds(205, 193, 551, 31);
		panel_1_1.add(txtAddress);
		
		txtPostcode = new JTextField();
		txtPostcode.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPostcode.setColumns(10);
		txtPostcode.setBounds(205, 233, 551, 31);
		panel_1_1.add(txtPostcode);
		
		txtTelephone = new JTextField();
		txtTelephone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(205, 275, 551, 31);
		panel_1_1.add(txtTelephone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 317, 726, 191);
		panel_1_1.add(scrollPane);
		
		DataTable = new JTable();
		DataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)DataTable.getModel();
				int selectedRow = DataTable.getSelectedRow();
				
				txtID.setText(model.getValueAt(selectedRow, 0).toString());
				txtStudentID.setText(model.getValueAt(selectedRow, 1).toString());
				txtFirstName.setText(model.getValueAt(selectedRow, 2).toString());
				txtSurname.setText(model.getValueAt(selectedRow, 3).toString());
				txtAddress.setText(model.getValueAt(selectedRow, 4).toString());
				txtPostcode.setText(model.getValueAt(selectedRow, 5).toString());
				txtTelephone.setText(model.getValueAt(selectedRow, 6).toString());
			}
		});
		DataTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "StudentID", "FirstName", "SurName", "Address", "Postcode", "Telephone"
			}
		));
		scrollPane.setViewportView(DataTable);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(146, 23, 31, 43);
		panel_1_1.add(lblId);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtID.setColumns(10);
		txtID.setBounds(205, 27, 551, 31);
		panel_1_1.add(txtID);
	}
}
