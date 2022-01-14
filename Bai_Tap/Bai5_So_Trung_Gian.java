package Bai_Tap;

public class Bai5_So_Trung_Gian {

	public static void main(String[] args) {
		
		int a = 8, b = 5, c = 7, max, min, soTrungGian;
		
		max = a > b && a > c ? a : (b > c ? b : c);
		
		min = a < b && a < c ? a : (b < c ? b : c);
		
		soTrungGian = a + b + c - max - min;
		
		System.out.println("So trung gian la : " + soTrungGian);

	}

}
