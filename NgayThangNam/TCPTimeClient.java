package NgayThangNam;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTimeClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8080);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String time = din.readUTF();
		System.out.println(time);
		socket.close();
	}

}
