package Chuoi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChuoiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8080);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		Scanner input = new Scanner(System.in);
		System.out.print("Client : ");
		while(true) {
			
			String msg = input.nextLine();
			dos.writeUTF(msg);
			dos.flush();
			
			String st = din.readUTF();
			System.out.println(st);
			input = input.reset();
		}
	}

}
