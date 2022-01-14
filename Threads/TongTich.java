package Threads;
import java.io.*;

public class TongTich {
	
	public int NhapSo()throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public void TongtichcacChuSo(int m) {
		int S = 0, P = 1;
		while(m!= 0) {
			S += m%10;
			P *= m%10;
			m /= 10;
		}
		System.out.println("Tong cac chu so la : " + S);
		System.out.println("Tich cac chu so la : " + P);
	}

	public static void main(String[] args) {
		TongTich tt = new TongTich();
		int m = 0;
		try {
			do {
				System.out.println("Nhap mot so nguyen duong");
				m = tt.NhapSo();
			} while (m <= 0);
			
			
		} catch(Exception e) {
			
		}
		System.out.println("So da nhap la : " + m);
		tt.TongtichcacChuSo(m);
	}

}
