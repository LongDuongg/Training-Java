package Chat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class ChatServerTCP {

	static Vector<MultiClient> clients = new Vector<MultiClient>();

	public static void main(String args[]) {
		try {
			ChatServerTCP cs = new ChatServerTCP();
			
			ServerSocket server = new ServerSocket(8000);
			System.out.println("Server is started");
			
			Socket client1 = server.accept(); // client 1
			MultiClient mc1 = new MultiClient(client1, cs);
			clients.add(mc1);
			mc1.start();
			
			Socket client2 = server.accept(); // client 2
			MultiClient mc2 = new MultiClient(client2, cs);
			clients.add(mc2);
			mc2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}

class MultiClient extends Thread {
	private Socket socket = null;
	private ChatServerTCP cs = null;
	
	public MultiClient(Socket socket, ChatServerTCP cs) {
		try {
			this.socket = socket;
			this.cs = cs;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			while (true) {
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				DataInputStream din = new DataInputStream(socket.getInputStream());
				String clientMessage = din.readUTF();
				System.out.println("Client : " +clientMessage);
				
				for (MultiClient client : cs.clients) {
					try {
						DataOutputStream dos1 = new DataOutputStream(client.socket.getOutputStream());
						dos1.writeUTF("Client : " +clientMessage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}