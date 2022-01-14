package Threads;
import java.io.*;

public class Bai1_NhapChuoi {

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
		System.out.println("Chuỗi đảo là : " + st);
	}
	
	public void toUpperCase(String s) {
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
		System.out.println("Chuỗi viết hoa là : " + st);
	}

	public void toLowerCase(String s) {
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
		System.out.println("Chuỗi viết thường là : " + st);
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
		System.out.println("Chuỗi vừa hoa vừa thường là : " + st);
	}
	
	public void SortString(String[] arr) {
		int i,j;
		for(i = 0; i < arr.length; i++) {
			for(j = i+1; j < arr.length; j++) {
				if(arr[i].compareTo(arr[j]) < 0) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public void Count(String m) {
		int numberOfWord = 0;
		String[] words = m.split(" ");
		for(String word : words) {
			if(word.length() == 0) {
				continue;
			} else {
				numberOfWord += 1;
			}
		}
		System.out.println("Có " + numberOfWord + " từ trong chuỗi");
	}
	
	public String CountDuplicateWord(String s) {
		String[] arr = s.split(" ");
		SortString(arr);
		String str = arr[0];
		String display = ""; 
		int count = 0;
		int b = 0;
		int i;
		for( i = 1; i < arr.length; i++) {
			if( ! arr[i].equals(str) ) {
				display += str + " : " + (i - b) + " lần";
				display += "\n";
				str = arr[i];
				b = i;
			}
		}
		display += str + " : " + (i - b) + " lần";
		return display;
	}
	
	public static void main(String[] args) {
		Bai1_NhapChuoi b = new Bai1_NhapChuoi();
		String m = "";
		try {
			do {
				System.out.print("Nhập một chuỗi bất kỳ : ");
				m = b.nhapChuoi();
			} while(m == "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
// a) Chuỗi đảo ngược :
		b.Revered(m);
		
// b) Chữ hoa :
		b.toUpperCase(m);
		
// c) Chữ thường :
		b.toLowerCase(m);
		
// d) Chuỗi vừa hoa vừa thường :
		b.toUpper_LowerCase(m);
		
// e) Số từ trong chuỗi :
		b.Count(m);
		
// f) Tần số xuất hiện của các từ :
		System.out.println("Bảng tần số xuất hiện của các từ : ");
		System.out.println(b.CountDuplicateWord(m));
	}

}
