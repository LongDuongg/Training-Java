package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ChatClientUDP extends JFrame {

	private JPanel contentPane;
	private JTextField txtClientMessage;
	private JTextArea txtServerResponce;
	private DatagramSocket clientSocket;
	private InetAddress ipAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientUDP frame = new ChatClientUDP();
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
	public ChatClientUDP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtClientMessage = new JTextField();
		txtClientMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtClientMessage.setBounds(10, 306, 325, 23);
		contentPane.add(txtClientMessage);
		txtClientMessage.setColumns(10);
		
		JTextArea txtServerResponce = new JTextArea();
		txtServerResponce.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtServerResponce.setBounds(10, 35, 414, 268);
		contentPane.add(txtServerResponce);
		
		try {
			clientSocket = new DatagramSocket();
		    byte[] receiveData = new byte[1024];
	        Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						String clientMessage = "";
						while (true) {
							DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
					        clientSocket.receive(receivePacket);
					        String serverAnswer = new String(receivePacket.getData());
					        clientMessage += serverAnswer + "\n";
					        txtServerResponce.setText(clientMessage);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	        });
	        thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					byte[] sendData = new byte[1024];
					ipAddress = InetAddress.getByName("localhost");
			        String request = txtClientMessage.getText();
			        sendData = request.getBytes(StandardCharsets.UTF_8);
			        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 8080);
			        clientSocket.send(sendPacket); 
			        txtClientMessage.setText("");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSend.setBounds(335, 306, 89, 23);
		contentPane.add(btnSend);
		
		JLabel ChatClient = new JLabel("Chat Client");
		ChatClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ChatClient.setBounds(151, 11, 106, 21);
		contentPane.add(ChatClient);
		
		
	}
}
