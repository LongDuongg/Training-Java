package Threads;
import java.io.*;

public class DaoNguoc_DoiXung_Fibonacci {

	
	public int nhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public int Reverse(int s) {
		int reversed = 0, rem;
		do {
			rem = s % 10;
			reversed = reversed*10 + rem;
			s /= 10;
		} while(s > 0);
		return reversed;
	}
	
	public Boolean DoiXung(int s) {
		int temp, sum = 0, rem;
		for(temp = s; s != 0; s = s/10) {
			rem = s%10;
			sum = sum*10 + rem;
		}
		if(temp == sum) return true;
		else return false;
	}
	
	public static int Fibo(int n) {
		if(n == 0 || n == 1) return 1;
		else return Fibo(n-1) + Fibo(n-2);
	}
	
	public int Check(int k) {
		int i, m = 10;
		for(i = 0; i < m; i++) 
			if(Fibo(i) == k) 
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		DaoNguoc_DoiXung_Fibonacci ddf = new DaoNguoc_DoiXung_Fibonacci();
		int m = 0, i, n = 1000;
		try {
			do {
				System.out.print("Nhap so nguyen duong m : ");
				m = ddf.nhapSo();
			} while(m <= 0);
		} catch(Exception e) {}
		System.out.println("So nguyen duong m da nhap : " + m);
		
		System.out.println("So dao nguoc cua m la : " + ddf.Reverse(m));
		
		if(ddf.DoiXung(m)) {
			System.out.println(m + " la so doi xung");
		} else {
			System.out.println(m + " khong phai la so doi xung");
		}
		
		System.out.println(ddf.Check(m));
	}
}
