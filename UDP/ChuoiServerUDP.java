package Chuoi;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class ChuoiServerUDP {

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
				
				ChuoiServerUDP cs = new ChuoiServerUDP();
				String serverResponce = "";
				serverResponce += "Chuoi Hoa : " + cs.toUpperCase(clientRequest).trim() + "\n";
				serverResponce += "Chuoi thuong : " + cs.toLowerCase(clientRequest).trim() + "\n";
				serverResponce += "Chuoi vua Hoa vua thuong : " + cs.toUpper_LowerCase(clientRequest).trim() + "\n";
				serverResponce += "So tu trong chuoi : " + cs.Count(clientRequest) + "\n";
				
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
