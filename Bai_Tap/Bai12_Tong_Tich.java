package Bai_Tap;

public class Bai12_Tong_Tich {

	
	public static void main(String[] args) {
		int m = 789, S = 0, P = 1;
		do {
			
			S = S + (m%10);
			P = P * (m%10);
			m = m/10;
			
		} while (m > 10);
		
		S = S + (m%10);
		P = P * (m%10);
		
		System.out.println("Tong cac chu so cua m la " + S);
		System.out.println("Tich cac chu so cua m la " + P);
	}

}
