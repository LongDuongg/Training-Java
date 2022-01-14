package Bai_Tap;

public class Bai2_Phuong_Trinh_Bac_Nhat {

	public static void main(String[] args) {
		double a = 2.0, b = 4.0, x;
		if(a == 0) {
			if(b == 0) {
				System.out.println("Phuong trinh co vo so nghiem");
			} else {
				System.out.println("Phuong trinh vo nghiem");
			}
		} else {
			x = (double) (-b) / a;
			System.out.println("Phuong trinh co nghiem duy nhat x = " + x);
		}
	}

}
