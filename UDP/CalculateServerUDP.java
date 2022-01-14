package Calculator;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CalculateServerUDP {

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
	
	public static void main(String[] args) {
		try {
			DatagramSocket server = new DatagramSocket(8080);
			System.out.println("Server is started");
			
			DatagramSocket client1 = new DatagramSocket();
			MultipleClient mc1 = new MultipleClient(server, client1);
			mc1.start();
			
			DatagramSocket client2 = new DatagramSocket();
			MultipleClient mc2 = new MultipleClient(server, client2);
			mc2.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class MultipleClient extends Thread {
	private DatagramSocket server;
	private DatagramSocket client;
	private byte[] sendData;
	private byte[] receiveData;
	private DatagramPacket receivePacket;
	private DatagramPacket sendPacket;
	
	public MultipleClient(DatagramSocket server, DatagramSocket client ) {
		this.server = server;
		this.client = client;
		sendData = new byte[1024];
		receiveData = new byte[1024];
	}
	
	public void run() {
		try {
			while (true) {
				receivePacket = new DatagramPacket(receiveData, receiveData.length);
				server.receive(receivePacket);
				InetAddress ipAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
				
				String clientRequest = new String(receivePacket.getData(), "UTF-8");
				System.out.println("Client request : " + clientRequest);
				
				CalculateServerUDP cs = new CalculateServerUDP();
				String serverResponce = "";
				serverResponce += "Ket qua : " + cs.Evaluate(clientRequest);
				
				sendData = serverResponce.getBytes(StandardCharsets.UTF_8);
				sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
				server.send(sendPacket);
				Thread.sleep(5000);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
