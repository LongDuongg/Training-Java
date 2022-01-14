package Threads;
import java.io.*;

public class ChuoiDao_ChuoiHoa {
	
	public String NhapChuoi() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	
	public void toUpperCase(String s) {
		char c ;
		String st = "";
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
			}
			st += c;
		}
		System.out.println("Chuoi hoa la : " + st);
	}
	
	public void toLowerCase(String s) {
		char c;
		String st = "";
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				c = (char)(c+32);
			}
			st += c;
		}
		System.out.println("Chuoi thuong la : " + st);
	}

	public void Reverse(String s) {
		char c ;
		String st = "";
		for(int i = s.length() - 1; i >= 0 ; i--) {
			c = s.charAt(i);
			st += c;
		}
		System.out.println("Chuoi dao la : " + st);
	}
	
	public void SortString(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i].compareTo(arr[j]) < 0) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public void CountDuplicateWord(String s) {
		String[] words = s.split(" ");
		SortString(words);
		String p;
		int i, b;
		p = words[0];
		b = 0;
		for(i = 1; i < words.length; i++) {
			if(!words[i].equals(p)) {
				System.out.println(p + " : " + (i-b) + " lan");
				p = words[i];
				b = i;
			}
		}
		System.out.println(p + " : " + (i-b) + " lan");
	}
	
	public static void main(String[] args) {
		ChuoiDao_ChuoiHoa cc = new ChuoiDao_ChuoiHoa();
		String s = "";
		try {
			do {
				System.out.print("Nhap 1 chuoi bat ky ");
				s = cc.NhapChuoi();
			} while(s == "");
			
		} catch (Exception e) {
			
		}
		System.out.println("Chuoi da nhap la : " + s);
		
		cc.CountDuplicateWord(s);
	}

}
