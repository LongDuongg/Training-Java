package Threads;
import java.io.*;

public class Bai2_NhapSo {
	
	public int nhapSo() throws IOException {
		InputStreamReader luongvao = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(luongvao);
		String s = br.readLine();
		return Integer.parseInt(s);
	}
	
	public void Sum(int m) {
		int S = 0;
		do {
			
			S = S + (m%10);
			m = m/10;
			
		} while (m > 10);
		
		S = S + (m%10);
		System.out.println("Tổng các chữ số của m là : " + S);
	}

	public int Reverse(int m) {
		int reversed = 0, rem;
		do {
			rem = m % 10;
			reversed = reversed*10 + rem;
			m /= 10;
		} while(m > 0);
		return reversed;
	}
	
	public static int Fibo(int n) {
		if(n == 0 || n == 1) return 1;
		else return Fibo(n-1) + Fibo(n-2);
	}
	
	public void Check(int m) {
		int i, k = 1000;
		for(i = 0; i < k; i++) {
			if(Fibo(i) == m) {
				System.out.println("Có, số " + m + " thuộc vị trí thứ " + i + " của dãy");
				break;
			} else {
				System.out.println("Không, số " + m + " không thuộc dãy số Fibonacci");
				break;
			}
		}
	}
	
	public Boolean DoiXung(int m) {
		int temp, sum = 0, rem;
		for(temp = m; m != 0; m = m/10) {
			rem = m%10;
			sum = sum*10 + rem;
		}
		if(temp == sum) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Bai2_NhapSo b = new Bai2_NhapSo();
		int m = 0;
		try {
			System.out.print("Nhập một số bất kỳ : ");
			m = b.nhapSo();
		} catch (Exception e) {
			e.printStackTrace();
		}

// a) Tổng các chữ số nguyên dương m :
		b.Sum(m);
		
// b) Số đảo ngược của m :
		System.out.println("Số đảo ngược của m là : " + b.Reverse(m));
		
// c) Kiểm tra m có thuộc dãy Fibonaci không : 
		b.Check(m);
		
// d) Kiểm tra đảo ngược của m có phải là số đối xứng không :
		if(b.DoiXung(m)) {
			System.out.println(m + " là số đối xứng");
		} else {
			System.out.println(m + " không phải là số đối xứng");
		}
	}

}
