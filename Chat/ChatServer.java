package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		Scanner input = new Scanner(System.in);
		
		while(true) {
			String st = din.readUTF();
			System.out.println(st);
			System.out.print("Server : ");
			String msg = input.nextLine();
			dos.writeUTF("Server : " + msg);
			dos.flush();
			input = input.reset();
		}
	}

}
