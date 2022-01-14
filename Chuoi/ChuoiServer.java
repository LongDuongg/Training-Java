package Chuoi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;

public class ChuoiServer {
	
	public String toUpperCase(String s) {
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

	public String toLowerCase(String s) {
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
	
	public String toUpper_LowerCase(String s) {
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

	public int Count(String m) {
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
	
	public Boolean isVowel(char c) {
		if(c == 'u' || c == 'U' || c == 'e' || c == 'E' || c == 'o' || c == 'O' || c == 'a' || c == 'A' || c == 'i' || c == 'I') {
			return true;
		} else {
			return false;
		}
	}
	
	public void PrintVowel(String m) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < m.length(); i++) {
			char c = m.charAt(i);
			if(isVowel(c)) {
				set.add(c);
			}
		}
		System.out.print("Cac nguyen am co trong chuoi la : ");
		for(char character : set) {
			System.out.print(" " + character);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		Scanner input = new Scanner(System.in);
		
		while(true) {
			String clientRequest = din.readUTF();
			System.out.println(clientRequest);
			ChuoiServer cs = new ChuoiServer();
			dos.writeUTF("Chuoi Hoa : " + cs.toUpperCase(clientRequest));
			dos.writeUTF("Chuoi thuong : " + cs.toLowerCase(clientRequest));
			dos.writeUTF("Chuoi vua Hoa vua thuong : " + cs.toUpper_LowerCase(clientRequest));
			dos.writeUTF("So tu trong chuoi : " + cs.Count(clientRequest));
			cs.PrintVowel(clientRequest);
		}
	}

}
