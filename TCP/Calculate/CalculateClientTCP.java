package TCP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculateClientTCP extends JFrame {

	private JPanel contentPane;
	private JTextField txtClient;
	private JTextArea txtServerResponce;
	private DataOutputStream dos;
	private DataInputStream din;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateClientTCP frame = new CalculateClientTCP();
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
	public CalculateClientTCP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 63, 25);
		contentPane.add(lblNewLabel);
		
		txtClient = new JTextField();
		txtClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtClient.setBounds(83, 11, 252, 26);
		contentPane.add(txtClient);
		txtClient.setColumns(10);
		
		JTextArea txtServerResponce = new JTextArea();
		txtServerResponce.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtServerResponce.setBounds(10, 47, 414, 107);
		contentPane.add(txtServerResponce);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket socket = new Socket("localhost", 8000);
					dos = new DataOutputStream(socket.getOutputStream());
					din = new DataInputStream(socket.getInputStream());
					
					
					String clientRequest = txtClient.getText();
					dos.writeUTF(clientRequest);
					dos.flush();
					
					String serverResponce = din.readUTF();
					txtServerResponce.setText(serverResponce);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSend.setBounds(335, 11, 89, 25);
		contentPane.add(btnSend);
	}
}
