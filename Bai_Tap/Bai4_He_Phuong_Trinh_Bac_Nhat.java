package Bai_Tap;

public class Bai4_He_Phuong_Trinh_Bac_Nhat {

	public static void main(String[] args) {
		double D, Dx, Dy, x, y;
		int a = 4, b = 3, c = 3, d = 4, e = 5, f = 6 ;
		
		D = a*e - d*b;
		
		Dx = c*e - f*b;
		
		Dy = a*f - d*c;
		
		if(D == 0) {
			if(Dx == 0 && Dy == 0) {
				System.out.println("He phuong trinh co vo so nghiem");
			} else {
				System.out.println("He phuong trinh vo nghiem");
			}
		} else {
			x = Dx/D; y = Dy/D;
			System.out.println("He phuong trinh luon co nghiem duy nhat voi x = " + x + ", y = " + y);
		}

	}

}
