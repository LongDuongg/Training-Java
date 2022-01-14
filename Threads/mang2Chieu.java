package Threads;
import java.io.*;

public class mang2Chieu {

	private int[][] a = new int[100][100];
	private int[] X = new int[100];
	private static int n;
	private static int m;
	
	public int nhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}

	public void nhapMang() throws IOException {
		try {
			System.out.print("Nhap so dong m : ");
			m = nhapSo();
			System.out.print("Nhap so cot n : ");
			n = nhapSo();
		} catch(Exception e) { }
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("a[" + i + "][" + j + "] = ");
				a[i][j] = nhapSo();
			}
		}
	}
	
	public void xuatMang() {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("a[" + i + "][" + j + "] = " + a[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	public void tichSoBoi3() {
		int multiple = 1;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] % 3 == 0) {
					multiple *= a[i][j];
				}
			}
			break;
		}
		System.out.println("Tich cac so boi 3 trong dong dau tien cua ma tran a : " + multiple);
	}
	
	public void findMaxValue() {
		int max = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 1; j < n; j++) {
				max = a[i][0];
				if(a[i][j] > max) {
					max = a[i][j];
				}
			}
			X[i] = max;
		}
		
		System.out.print("Cac gia tri lon nhat cua mang X : ");
		for(int i = 0; i < m; i++) {
			System.out.print(" X[" + i + "] = " + X[i] + "   ");
		}
		System.out.println();
	}
	
	public void remove(int value) {
		int i = 0;
		do {
			int temp = X[i];
			X[i] = X[i+1];
			X[i+1] = temp;
			i++;
		} while(X[i] == value && i < m-1);
		X[m-1] = 0;
		m -= 1;
		System.out.print("Mang moi sau khi xoa : ");
		for(i = 0; i < m; i++) {
			System.out.print("X[" + i + "] = " + X[i] + "   ");
		}
	}
	
	public static void main(String[] args) {
		mang2Chieu mc = new mang2Chieu();
		
		try {
			do {
				mc.nhapMang();
			} while(m <= 0 && n <= 0);
		} catch(Exception e) { }
		
		mc.tichSoBoi3();
		
		mc.findMaxValue();
		
		mc.remove(3);
	}
}
