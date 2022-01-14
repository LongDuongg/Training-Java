package Bai_Tap;

public class Bai15_So_Chinh_Phuong {

	static Boolean Check(int m) {
		if (m < 2) return true;
		for(int i = 2; i <= m; i++) {
			if(i == Math.sqrt(m)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int m = 1;
		if(Check(m)) {
			System.out.println(m + " la so chinh phuong");
		} else {
			System.out.println(m + " khong phai la so chinh phuong");
		}
	}

}
