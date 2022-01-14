package Bai_Tap;

public class Bai17_So_Nguyen_To {

	static Boolean Check(int n) {
		int i;
		if(n < 2) return false;
		for(i = 2; i <= Math.ceil(n/2); i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int i, n = 49;
		for(i = 0; i <= n; i++) {
			if(Check(i)) {
				System.out.println(i);
			}
		}
	}
}
