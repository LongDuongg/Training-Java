package Bai_Tap;

public class Bai19_Fibonaci {

	static int Fib(int n) {
		int a = 1, b = 1, c = 1;
		if(n <= 1) return 1;
		for(int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		int n = 10;
		for(int i = 1; i < n; i++) {
			System.out.print(Fib(i) + " ");
		}
	}

}
