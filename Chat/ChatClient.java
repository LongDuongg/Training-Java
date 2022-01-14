package Chat;
import java.io.*;
import java.util.*;
import java.net.*;

public class ChatClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 8080);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("Client : ");
			String msg = input.nextLine();
			dos.writeUTF("Client : " + msg);
			dos.flush();
			String st = din.readUTF();
			System.out.println(st);
			input = input.reset();
		}
	}

}
