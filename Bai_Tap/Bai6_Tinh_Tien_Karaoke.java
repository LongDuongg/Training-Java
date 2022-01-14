package Bai_Tap;

public class Bai6_Tinh_Tien_Karaoke {

	public static void main(String[] args) {
		int a = 19, b = 21;
		int tien = 0;
		if(b < 18) {
			tien = 45000 * (b - a);
		}
		
		if(a < 18 && b >= 18) {
			tien = 45000 * (18 - a) + 60000 * (b - 18);
		}
		
		if(a >= 18) {
			tien = 60000 * (b - a);
		}
		System.out.println("So tien phai tra : " + tien);
	}

}
