package Threads;
import java.io.*;

public class UCLN_BCNN {
	
	public int NhapSo() throws Exception {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine(); 
		return Integer.parseInt(s);
	}
	
	public int UCLN(int a, int b) {
		if(a % b == 0) return b;
		if(b % a == 0) return a;
		if(a == b) return a;
		else {
			if(a > b) return UCLN(a%b, b);
			else return UCLN(a, b%a);
		}
	}
	
	public int BCNN(int a, int b) {
		return (a*b)/UCLN(a,b);
	}

	public static void main(String[] args) {
		UCLN_BCNN ub = new UCLN_BCNN();
		int a = 0, b = 0;
		try {
			do {
				System.out.println("Nhap vao 2 so nguyen duong");
				a = ub.NhapSo();
				b = ub.NhapSo();
			} while(a <= 0 && b <= 0);
			
		} catch(Exception e) {
			
		}
		System.out.println("2 so da nhap la : " + a + ", " + b);
		System.out.println("Uoc chung lon nhat la : " + ub.UCLN(a, b));
		System.out.println("Boi chung nho nhat la : " + ub.BCNN(a, b));
	}

}
