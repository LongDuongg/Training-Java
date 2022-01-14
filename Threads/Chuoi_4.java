package Threads;
import java.io.*;
import java.util.*;

public class Chuoi_4 {

	public String nhapChuoi() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return s;
	}
	
	public String toUpperCase(String m) {
		char c;
		String st = "";
		for(int i = 0; i < m.length(); i++) {
			c = m.charAt(i);
			if(c >= 'a' && c <= 'z') {
				c = (char)(c - 32);
			}
			st += c;
		}
		return st;
	}
	
	public String toLowerCase(String m) {
		char c;
		String st = "";
		for(int i = 0; i < m.length(); i++) {
			c = m.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				c = (char)(c + 32);
			}
			st += c;
		}
		return st;
	}
	
	public void Capitalize(String m) {
		String[] words = m.split(" ");
		String st = "";
		for(String word : words) {
			if(word.length() == 0) {
				continue;
			} else {
				String first = toUpperCase(word.substring(0,1));
				String rest = toLowerCase(word.substring(1));
				st += first + rest;
				st += " ";
			}
		}
		System.out.println("Chuoi hoan chinh : " + st + " ");
	}

	public void PrintWord(String m) {
		String[] words = m.split(" ");
		System.out.println("Cac tu trong chuoi : ");
		for(String word : words) {
			System.out.println(word);
		}
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
		System.out.println("Co " + numberOfWord + " tu trong chuoi");
	}
	
	public static void main(String[] args) {
		Chuoi_4 C = new Chuoi_4();
		String m = "";
		try {
			do {
				System.out.print("Nhap mot chuoi bat ky : ");
				m = C.nhapChuoi();
			} while(m == "");
		} catch(Exception e) {}
		
		C.Capitalize(m);
		
		C.PrintWord(m);
		
		C.PrintVowel(m);
		
		C.Count(m);
	}
}
