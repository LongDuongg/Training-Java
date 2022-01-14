package Bai_Tap;

public class Bai14_So_Nguyen_To {

	static Boolean Check(int n) {
		int i;
		if(n < 2) return false;
		for(i = 2; i <= Math.ceil(n/2); i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int m = 9;
		if(Check(m)) {
			System.out.println(m + " la so nguyen to");
		} else {
			System.out.println(m + " khong phai la so nguyen to");
		}
	}

}
