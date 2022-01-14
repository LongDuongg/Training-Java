package training_Java;
import java.io.*;
public class CanBacHai {

	public static double TinhCanBac2(int m) {
		double n = 0.0;
		n = Math.sqrt(m);
//		System.out.println("Can bac 2 cua " + m + " la " + n);
		return n;
	}
	
	
	public static void main(String[] args) {
		CanBacHai cb1 = new CanBacHai();
		System.out.println("Can bac 2 cua 4 la " + cb1.TinhCanBac2(4));
		CanBacHai cb2 = new CanBacHai();		
		System.out.println("Can bac 2 cua 16 la " + cb2.TinhCanBac2(16));
	}

}
