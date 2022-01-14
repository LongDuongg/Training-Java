package Bai_Tap;
import java.io.*;
public class Bai1_TimMax {

	public static void main(String[] args) throws IOException {
		
		
		int a = 10, b = 9, c = 15, max;
				
		max = a > b && a > c ? a : (b > c ? b : c);
		
		System.out.println("So lon nhat la : " + max);
		
	}

}
