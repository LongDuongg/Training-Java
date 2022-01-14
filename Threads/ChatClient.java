package Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		new ChatClient();
	}

	public ChatClient() {
		try { 
			Scanner sc = new Scanner(System.in);
			Socket soc = new Socket("localhost", 80);
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			System.out.println(dis.readUTF());
			// Nhap ten va gui cho server
			String name = sc.nextLine();
			dos.writeUTF(name);
			new XulyNhan(soc).start(); 
			while (true) {
				// Nhap tin nhan gui server
				String msg = sc.nextLine();
				dos.writeUTF(msg);
			}
		} catch (Exception e) {
		}
	}

}

class XulyNhan extends Thread {
	Socket soc;

	public XulyNhan(Socket soc) {
		this.soc = soc;
	}
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			while (true) {
				System.out.println(dis.readUTF());
			}
		} catch (Exception e) {

		}
	}
}
