package Bai_Tap;

public class Bai3_Phuong_Trinh_Bac_Hai {

	public static void main(String[] args) {
		double a = 1, b = -5, c = 4, delta, x1, x2;
		
		delta = b*b - 4*a*c;
		
		if(delta > 0) {
			x1 = (-b - Math.sqrt(delta)) / (2*a);
			x2 = (-b + Math.sqrt(delta)) / (2*a);
			System.out.println("Phuong trinh co 2 nghiem phan biet x1 = " + x1 + ", x2 = " + x2);
		} else {
			if(delta == 0) {
				x1 = x2 = (-b) / (2*a);
				System.out.println("Phuong trinh co nghiem kep x1 = x2 = " + x1);
			} else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}		
	}
}

