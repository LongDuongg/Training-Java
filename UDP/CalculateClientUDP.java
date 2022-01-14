package Calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculateClientUDP extends JFrame {

	private JPanel contentPane;
	private JTextField txtClient;
	private JTextArea txtServerResponce;
	private DatagramPacket sendPacket;
	private DatagramPacket receivePacket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateClientUDP frame = new CalculateClientUDP();
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
	public CalculateClientUDP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 203);
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
		txtClient.setColumns(10);
		txtClient.setBounds(83, 11, 252, 26);
		contentPane.add(txtClient);
		
		JTextArea txtServerResponce = new JTextArea();
		txtServerResponce.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtServerResponce.setBounds(10, 47, 414, 107);
		contentPane.add(txtServerResponce);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatagramSocket clientSocket = new DatagramSocket();
			        InetAddress ipAddress = InetAddress.getByName("localhost");
			        byte[] receiveData = new byte[1024];
			        byte[] sendData = new byte[1024];
			        Scanner input = new Scanner(System.in);

			        String request = txtClient.getText();
			        sendData = request.getBytes(StandardCharsets.UTF_8);
			        sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 8080);
			        clientSocket.send(sendPacket);

			        receivePacket = new DatagramPacket(receiveData, receiveData.length);
			        clientSocket.receive(receivePacket);
			        String serverAnswer = new String(receivePacket.getData());
			        txtServerResponce.setText(serverAnswer);
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
