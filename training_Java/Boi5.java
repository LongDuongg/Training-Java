package training_Java;
import java.io.*;
public class Boi5 {

	
	public static boolean KiemTraBoi5(int m) {
		if (m%5 != 0) {
//			System.out.println(m + " khong phai la boi cua 5");
			return false;
		} else {
//			System.out.println(m + " la boi cua 5");
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		Boi5 b1 = new Boi5();
		if (b1.KiemTraBoi5(10) == true) System.out.println(true);
		else System.out.println(false);
	}

}
