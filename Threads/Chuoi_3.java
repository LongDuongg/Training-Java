package Threads;
import java.io.*;

public class Chuoi_3 {

	public String nhapChuoi() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	
	public void Revered(String s) {
		char c;
		String st = "";
		for(int i = s.length() - 1; i >= 0 ; i--) {
			c = s.charAt(i);
			st += c;
		}
		System.out.println("Chuoi dao la : " + st);
	}
	
	public void toUpperCase(String s) {
		char c;
		String st = "";
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c >= 'a' && c <= 'z') {
				c = (char)(c - 32);
				st += c;
			}
		}
		System.out.println("Chuoi viet hoa la : " + st);
	}

	public void toLowerCase(String s) {
		char c;
		String st = "";
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				c = (char)(c + 32);
				st += c;
			}
		}
		System.out.print("Chuoi viet thuong la : " + st);
	}
	
	public void toUpper_LowerCase(String s) {
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
		System.out.print("Chuoi vua hoa vua thuong la : " + st);
	}
	
	public static void main(String[] args) {
		Chuoi_3 C = new Chuoi_3();
		String m = "";
		try {
			do {
				System.out.print("Nhap mot chuoi bat ky : ");
				m = C.nhapChuoi();
			} while(m == "");
			
		} catch(Exception e) {}
		
		C.Revered(m);
		
		for(int i = 0; i < m.length(); i++) {
			if(m.charAt(i) >= 'a' && m.charAt(i) <= 'z') {
				C.toUpperCase(m);
				break;
			} else {
				C.toLowerCase(m);
				break;
			}
		}
		
		C.toUpper_LowerCase(m);
	}

} 
