package Threads;
import java.io.*;

public class MangA {

	private static int[] a = new int[100];
	private static int n;
	
	public int nhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public void nhapMang() throws IOException {
		System.out.print("Nhap so phan tu cua mang a : ");
		n = nhapSo();
		for(int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = nhapSo();
		}
	}
	
	public void SumOdd() {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(a[i] % 2 == 0) {
				continue;
			} else {
				sum += a[i];
			}
		}
		System.out.println("Tong cac so le trong mang a : " + sum);
	}
	
	public int Search() {
		int k = 0,i;
		try {
			System.out.print("Nhap so k can tim : ");
			k = nhapSo();
		} catch(Exception e) {
			
		}
		
		for(i = 0; i < n; i++) 
			if(a[i] == k) 
				return i;
		return -1;
	}
	
	public void Sort() {
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.print("Mang moi sau khi sort :");
		for(int i = 0; i < n; i++) {
			System.out.print(" a[" + i + "] = " + a[i] + "   ");
		}
		System.out.println();
	}
	
	public void Insert(int p) {
		
		int i = n;
		do {
			a[i] = a[i-1];
			i--;
		} while(a[i-1] > p);
		a[i] = p;
		
		System.out.print("Mang moi sau khi them : ");
		for(i = 0; i <= n; i++) {
			System.out.print("a[" + i + "] = " + a[i] + "    ");
		}
	}
	
	public static void main(String[] args) {
		MangA m = new MangA();
		
		try {
			do {
				m.nhapMang();
			} while(n <= 0);
		} catch(Exception e) {}
		
		m.SumOdd();
		
		System.out.println("K thuoc vi tri " + m.Search() + " trong mang");
		
		m.Sort();
		
		m.Insert(6);
	}
}
