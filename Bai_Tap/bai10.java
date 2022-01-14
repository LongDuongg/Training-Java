package Bai_Tap;

public class bai10 {

	static int Giai_Thua(int n) {
		if(n == 0 || n == 1) return 1;
		int giai_thua = 1;
		int i;
		for(i = 2; i < n+1; i++) {
			giai_thua = giai_thua * i;
		}
		return giai_thua;
	}
	
	public static void main(String[] args) {
		double S = 0;
		int n = 6, i;
		for(i = 1; i <= n; i++) {
			S += (double)1/(Giai_Thua(2*i-1));
		}
		System.out.println("S = " + S);
	}

}
