package Bai_Tap;

public class Bai20_K_Thuoc_Fibonaci {
	
	static int Fibo(int n) {
		if(n == 0 || n == 1) return 1;
		return Fibo(n-1) + Fibo(n-2);
	}
	
	static int Check(int k) {
		int i, m = 10;
		for(i = 0; i < m; i++) 
			if(Fibo(i) == k) 
				return i;
		return -1;
	}
		
	
	public static void main(String[] args) {
		int k = 10;
		System.out.println(Check(k));
	}
}
