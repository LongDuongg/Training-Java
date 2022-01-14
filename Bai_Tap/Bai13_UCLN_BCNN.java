package Bai_Tap;

public class Bai13_UCLN_BCNN {

	static int Ucln(int a, int b) {
		if(a % b == 0) return b;
		if(b % a == 0) return a;
		if(a == b) return a;
		else {
			if(a > b) return Ucln(a%b, b);
			else return Ucln(a, b%a);
		}
	}
	
	static int Bcnn(int a, int b) {
		return (a*b) / Ucln(a,b);
	}
	
	public static void main(String[] args) {
		int a = 8, b = 16;
		System.out.println("Uoc Chung lon nhat cua " + a + " va " + b + " la " + Ucln(a,b));
		System.out.println("Boi Chung nho nhat cua " + a + " va " + b + " la " + Bcnn(a,b));
	}

}
