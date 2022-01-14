package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

public class ChatServerUDP {

	static Vector<DatagramPacket> packets = new Vector<DatagramPacket>();
	
	public static void main(String[] args) {
		try {
			ChatServerUDP cs = new ChatServerUDP();
			DatagramSocket server = new DatagramSocket(8080);
			System.out.println("Server is started");
			
			byte[] receiveData1 = new byte[1024];
			DatagramPacket packet1 = new DatagramPacket(receiveData1, receiveData1.length);
			packets.add(packet1);
			MultipleClient mc1 = new MultipleClient(server, packet1.getAddress(), packet1.getPort(), cs);
			mc1.start();
			
			byte[] receiveData2 = new byte[1024];
			DatagramPacket packet2 = new DatagramPacket(receiveData2, receiveData2.length);
			packets.add(packet2);
			MultipleClient mc2 = new MultipleClient(server, packet2.getAddress(), packet2.getPort(), cs);
			mc2.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MultipleClient extends Thread {
	private ChatServerUDP cs;
	private DatagramSocket server;
	private InetAddress ipAddress;
	private int port;
	
	public MultipleClient(DatagramSocket server, InetAddress ipAddress, int port, ChatServerUDP cs ) {
		this.server = server;
		this.ipAddress = ipAddress;
		this.port = port;
		this.cs = cs;
	}
	
	public void run() {
		try {
			byte[] Data = new byte[1024];
			while (true) {
				DatagramPacket packet = new DatagramPacket(Data, Data.length);
				server.receive(packet);
				String clientMessage = new String(packet.getData());
	            System.out.println("Client : " + clientMessage);
	            
	            for (DatagramPacket singlePacket : cs.packets) {
	            	InetAddress ipAddress = singlePacket.getAddress();
	                int port = singlePacket.getPort();
	                DatagramPacket sendPacket = new DatagramPacket(Data, Data.length, ipAddress, port);
	                server.send(sendPacket);
	            }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}