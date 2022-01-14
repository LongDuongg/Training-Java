package Bai_Tap;

public class Bai18_So_Hoan_Hao {

	public static void main(String[] args) {
		int S;
		int i;
		for(i = 1; i < 10000; i++) {
			S = 0;
			for(int k = 1; k <= i/2; k++) {
				if(i % k == 0) S+= k;
			}
			if (S == i)
				System.out.println(i);
		}
		
	}

}
