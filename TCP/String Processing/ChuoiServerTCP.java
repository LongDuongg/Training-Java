package TCP;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChuoiServerTCP {
	
	synchronized static public String toUpperCase(String s) {
        char c;
        String st = "";
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
                st += c;
            } else {
                st += c;
            }

        }
        return st;
    }

    synchronized static public String toLowerCase(String s) {
        char c;
        String st = "";
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
                st += c;
            } else {
                st += c;
            }
        }
        return st;
    }

    synchronized static public String toUpper_LowerCase(String s) {
        char c;
        String st = "";
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            } else {
                c = (char)(c + 32);
            }
            st += c;
        }
        return st;
    }

    synchronized static public int Count(String m) {
        int numberOfWord = 0;
        String[] words = m.split(" ");
        for(String word : words) {
            if(word.length() == 0) {
                continue;
            } else {
                numberOfWord += 1;
            }
        }
        return numberOfWord;
    }

	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(8000);
			System.out.println("Server is started");
			
			Socket client1 = server.accept(); // client 1
			MultiClient mc1 = new MultiClient(client1);
			mc1.start();
			
			Socket client2 = server.accept(); // client 2
			MultiClient mc2 = new MultiClient(client2);
			mc2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MultiClient extends Thread {
	private DataOutputStream dos = null;
	private DataInputStream din = null;
	private Socket socket = null;
	
	public MultiClient(Socket socket) {
		try {
			this.socket = socket;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			while (true) {
				din = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				String clientRequest = din.readUTF();
				System.out.println(clientRequest);
				ChuoiServerTCP cs = new ChuoiServerTCP();
				String serverResponce = "";
				serverResponce += "Chuoi Hoa : " + cs.toUpperCase(clientRequest) + "\n";
				serverResponce += "Chuoi thuong : " + cs.toLowerCase(clientRequest) + "\n";
				serverResponce += "Chuoi vua Hoa vua thuong : " + cs.toUpper_LowerCase(clientRequest) + "\n";
				serverResponce += "So tu trong chuoi : " + cs.Count(clientRequest) + "\n";
				dos.writeUTF(serverResponce);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
