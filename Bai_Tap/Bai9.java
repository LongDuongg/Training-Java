package Bai_Tap;

public class Bai9 {

	static int Giai_Thua(int n) {
		int giai_thua = 1;
		if(n == 0 || n == 1) 
			return giai_thua;
		
		for(int i = 2; i < n + 1; i++) {
			giai_thua = giai_thua * i;
		}
		
		return giai_thua;
	}
	
	public static void main(String[] args) {
		double S = 15;
		int n = 5;
		
		for(int i = 1; i <= n; i++) {
			S += (double)Math.pow(-1,i) / Giai_Thua(i); 
		}
		System.out.println(S);
		
	}

}
