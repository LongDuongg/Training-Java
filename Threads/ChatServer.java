package Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	Vector<Xuly> clients = new Vector<Xuly>();

	public static void main(String args[]) {
		new ChatServer();
	} 

	public ChatServer() {
		try {
			ServerSocket server = new ServerSocket(80);
			while (true) {
				Socket soc = server.accept();
				Xuly x = new Xuly(soc, this);
				clients.add(x);
				x.start();
				
				Socket soc1 = server.accept();
				Xuly x1 = new Xuly(soc1, this);
				clients.add(x1);
				x1.start();
			}
		} catch (Exception e) {

		}
	}
}

class Xuly extends Thread {
	ChatServer cs;
	Socket soc;

	public Xuly(Socket soc, ChatServer cs) {
		this.soc = soc;
		this.cs = cs; 
	}

	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			while (true) {
				// Nhan thong diep
				String mgs = dis.readUTF();
				for (Xuly c : cs.clients) {
					try {
						DataOutputStream dos1 = new DataOutputStream(c.soc.getOutputStream());
						dos1.writeUTF("Client : " + mgs);
					} catch (Exception e1) {
					}
				}
			}
		} catch (Exception e) {
		}
	}
}
