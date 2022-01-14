package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options_GUI frame = new Options_GUI();
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
	public Options_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 326);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 69, 19));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Options");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(92, 11, 195, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Board Color");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 76, 117, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Play Sound");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 126, 111, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Show legal moves");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 181, 170, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Default", "Brown", "Green", "Blue", "Black", "White"}));
		comboBoxColor.setBounds(199, 69, 170, 33);
		contentPane.add(comboBoxColor);
		
		JCheckBox checkSound = new JCheckBox("Turn off");
		checkSound.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					checkSound.setText("Turn on");
				} else {
					checkSound.setText("Turn off");
				}
			}
		});
		checkSound.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkSound.setBounds(199, 121, 170, 36);
		contentPane.add(checkSound);
		
		JCheckBox checkShowMoves = new JCheckBox("Turn off");
		checkShowMoves.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1) {
					checkShowMoves.setText("Turn on");
				} else {
					checkShowMoves.setText("Turn off");
				}
			}
		});
		checkShowMoves.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkShowMoves.setBounds(199, 176, 170, 36);
		contentPane.add(checkShowMoves);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnApply.setBounds(10, 236, 111, 40);
		contentPane.add(btnApply);
		
		JButton btnReset = new JButton("Reset to default");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxColor.setSelectedIndex(0);
				checkSound.setSelected(false); checkSound.setText("Turn off");
				checkShowMoves.setSelected(false); checkShowMoves.setText("Turn off");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(174, 236, 195, 40);
		contentPane.add(btnReset);
	}
}
