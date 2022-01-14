package Bai_Tap;

public class Bai16_So_Doi_Xung {

	static Boolean Check(String m) {
		if(m == "" || m.length() == 1) return true;
		for(int i = 0; i < Math.floor(m.length() - 1)/2; i++) {
			if(m.charAt(i) == m.charAt(m.length() - 1 - i)) return true;
		}
		return false;
	}
	
	static Boolean Check2(int num) {
		int temp, r, sum = 0;
		for(temp = num; num != 0; num = num/10) {
			r = num%10;
			sum = sum*10 + r;
		}
		if(temp == sum) return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		String m = "78987";
		
		if(Check(m)) {
			System.out.println(m + " la so doi xung");
		} else {
			System.out.println(m + " khong phai la so doi xung");
		}
		
		int n = 1991;
		if(Check2(n)) {
			System.out.println(n + " la so doi xung");
		} else {
			System.out.println(n + " khong phai la so doi xung");
		}
	}

}
