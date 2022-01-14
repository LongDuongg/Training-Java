package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class CalculateServerTCP {
	
	synchronized static public String Calculate(String a, String operator, String b) {
		double result = 0;
		
		switch (operator) {
			case "+" :
				result += Double.parseDouble(a) + Double.parseDouble(b);
				break;
			case "-" :
				result +=Double.parseDouble(a) - Double.parseDouble(b);
				break;
			case "*" :
				result += Double.parseDouble(a) * Double.parseDouble(b);
				break;
			case "/" :
				result += Double.parseDouble(a) / Double.parseDouble(b);
				break;
		}
		
		return Double.toString(result);
    }
	
	synchronized static public String Evaluate(String expression) {
		char[] tokens = expression.toCharArray();
	    List<String> list = new ArrayList<>();

	    String s = "";
	    String operator = "";
	    String firstNum = "";
	    String secondNum = "";

	    boolean operationOnQueue = false;

	    for (int i = 0; i < tokens.length; i++) {
	        if (Character.isDigit(tokens[i])) {
	            s += Character.toString(tokens[i]);
	        } else {
	            list.add(s);
	            list.add(Character.toString(tokens[i]));

	            if (operationOnQueue) {
	                operationOnQueue = false;
	                secondNum = s;

	                list.set(list.lastIndexOf(firstNum),  Calculate(firstNum, operator, secondNum));
	                list.remove(list.lastIndexOf(operator));
	                list.remove(list.lastIndexOf(secondNum));
	            }

	            if (tokens[i] == '*' || tokens[i] == '/') {
	                operationOnQueue = true;

	                operator = Character.toString(tokens[i]);
	                firstNum = list.get(list.lastIndexOf(operator) - 1);
	            }

	            s = "";
	        }

	        if (i == tokens.length - 1 && s.length() > 0) {
	            list.add(s);

	            if (list.get(list.size() - 2).equals("*") || list.get(list.size() - 2).equals("/")) {
	                firstNum = list.get(list.size() - 3);
	                operator = list.get(list.size() - 2);
	                secondNum = list.get(list.size() - 1);

	                list.set(list.size() - 3,  Calculate(firstNum, operator, secondNum));
	                list.remove(list.size() - 2);
	                list.remove(list.size() - 1);
	            }
	        }
	    }


	    while (list.size() > 1) {
	        firstNum = list.get(0);
	        operator = list.get(1);
	        secondNum = list.get(2);

	        list.set(0,  Calculate(firstNum, operator, secondNum));
	        list.remove(2);
	        list.remove(1);
	    }

	    return list.get(0);
		
    }

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		System.out.println("Server is started");
		
		Socket client1 = server.accept(); // client 1
		MultiClient mc1 = new MultiClient(client1);
		mc1.start();
		
		Socket client2 = server.accept(); // client 2
		MultiClient mc2 = new MultiClient(client2);
		mc2.start();

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
				
				CalculateServerTCP cs = new CalculateServerTCP();
				String serverResponce = "";
				serverResponce += "Ket qua : " + cs.Evaluate(clientRequest);
				
				dos.writeUTF(serverResponce);
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}