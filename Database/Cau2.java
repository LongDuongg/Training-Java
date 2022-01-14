package Database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cau2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cau2 frame = new Cau2();
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
	public Cau2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(204, 26, 275, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add a new Course");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(167, 101, 325, 38);
		contentPane.add(btnNewButton);
		
		JButton btnDisplayAllCourses = new JButton("Display all Courses");
		btnDisplayAllCourses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDisplayAllCourses.setBounds(167, 150, 325, 38);
		contentPane.add(btnDisplayAllCourses);
		
		JButton btnSearchCourseBy = new JButton("Search Course By Course Code");
		btnSearchCourseBy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchCourseBy.setBounds(167, 199, 325, 38);
		contentPane.add(btnSearchCourseBy);
		
		JButton btnExitApplication = new JButton("Exit Application");
		btnExitApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitApplication.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExitApplication.setBounds(167, 248, 325, 38);
		contentPane.add(btnExitApplication);
	}
}
