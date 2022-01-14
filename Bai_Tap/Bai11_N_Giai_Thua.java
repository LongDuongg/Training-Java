package Bai_Tap;

public class Bai11_N_Giai_Thua {

	public static void main(String[] args) {
		int n = 11, p = 1;
		do {
			p *= n;
			n -= 2;
		} while (n > 0);
		
		System.out.println(p);
	}

}
