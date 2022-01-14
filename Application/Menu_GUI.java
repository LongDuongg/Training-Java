package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_GUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_GUI frame = new Menu_GUI();
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
	public Menu_GUI() {
		setBackground(new Color(244, 164, 96));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 69, 19));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitGame.setBackground(new Color(244, 164, 96));
		btnQuitGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuitGame.setBounds(117, 399, 170, 43);
		contentPane.add(btnQuitGame);
		
		JButton btnOption = new JButton("Options");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options_GUI option = new Options_GUI();
				option.setVisible(true);
			}
		});
		btnOption.setBackground(new Color(244, 164, 96));
		btnOption.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOption.setBounds(117, 345, 170, 43);
		contentPane.add(btnOption);
		
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.setForeground(new Color(0, 0, 0));
		btnSinglePlayer.setBackground(new Color(244, 164, 96));
		btnSinglePlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSinglePlayer.setBounds(117, 237, 170, 43);
		contentPane.add(btnSinglePlayer);
		
		JButton btnMultiPlayers = new JButton("MultiPlayers");
		btnMultiPlayers.setBackground(new Color(244, 164, 96));
		btnMultiPlayers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMultiPlayers.setBounds(117, 291, 170, 43);
		contentPane.add(btnMultiPlayers);
		
		JLabel lbLogo_Chess = new JLabel();
		lbLogo_Chess.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbLogo_Chess.setBounds(10, 11, 383, 199);
		contentPane.add(lbLogo_Chess);
		
		ImageIcon image = new ImageIcon(getClass().getResource("logo_Chess.jpg"));
		Image logo = image.getImage();
		Image logoScale = logo.getScaledInstance(lbLogo_Chess.getWidth(), lbLogo_Chess.getHeight(), Image.SCALE_SMOOTH);
		lbLogo_Chess.setIcon(new ImageIcon(logoScale));
	}
}
