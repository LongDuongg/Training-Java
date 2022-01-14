package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ChatClientTCP extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField txtMessage;
	private JTextArea txtServerResponce;
	private DataOutputStream dos;
	private DataInputStream dis; 
	private Socket socket;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientTCP frame = new ChatClientTCP();
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
	public ChatClientTCP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtServerResponce = new JTextArea();
		txtServerResponce.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtServerResponce.setBounds(10, 44, 414, 235);
		contentPane.add(txtServerResponce);
		
		txtMessage = new JTextField();
		txtMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMessage.setColumns(10);
		txtMessage.setBounds(10, 279, 319, 26);
		contentPane.add(txtMessage);
		
		try {
			socket = new Socket("localhost", 8000);
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						String clientMessage = "";
						dis = new DataInputStream(socket.getInputStream());
						while (true) {
							clientMessage += dis.readUTF() + "\n";
							txtServerResponce.setText(clientMessage);
						}
						
					} catch (Exception e) {

					}
				}
			});
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dos = new DataOutputStream(socket.getOutputStream());
					String clientMessage = txtMessage.getText();
					dos.writeUTF(clientMessage);
					dos.flush();
					txtMessage.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSend.setBounds(328, 279, 96, 25);
		contentPane.add(btnSend);
		
		JLabel lblChatClient = new JLabel("Chat Client");
		lblChatClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChatClient.setBounds(170, 11, 124, 25);
		contentPane.add(lblChatClient);
	}
}
