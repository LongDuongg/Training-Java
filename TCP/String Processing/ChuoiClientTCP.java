package TCP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ChuoiClientTCP extends JFrame {

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
					ChuoiClientTCP frame = new ChuoiClientTCP();
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
	public ChuoiClientTCP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 27, 67, 22);
		contentPane.add(lblNewLabel);
		
		txtClient = new JTextField();
		txtClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtClient.setBounds(73, 23, 368, 31);
		contentPane.add(txtClient);
		txtClient.setColumns(10);
		
		JTextArea txtServerResponce = new JTextArea();
		txtServerResponce.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtServerResponce.setBounds(10, 75, 530, 323);
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
		btnSend.setBounds(451, 23, 89, 31);
		contentPane.add(btnSend);
	}
}
