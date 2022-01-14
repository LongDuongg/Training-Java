package Exception;
// NumberFormatException

public class ExceptionTest2 {

	static String time = "2020";
	
	public static void main(String[] args) {
		try {
			System.out.println("Nam den : " + (Integer.parseInt(time) + 1));
		} catch (Exception e) {
			System.out.println("Ban thanh cong doi chuoi thanh so");
		}

	}

}
