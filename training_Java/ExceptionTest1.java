package training_Java;
// Error NullPointException

public class ExceptionTest1 {

	static String s;
	public static void main(String[] args) {
		try {
			System.out.println("Chieu dai chuoi la : " + s.length());
			
		} catch (Exception e) {
			
		} finally {
			System.out.println("Chao ban ! Hello !!!!!!!");
		}

	}

}
