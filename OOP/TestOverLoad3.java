package OOP;

class Adder{
	static int add(int a, int b) {
		return a + b;
	}
	static double add(int a, int b) {
		return a + b;
	}
}

public class TestOverLoad3 {

	public static void main(String[] args) {
		System.out.println(Adder.add(2, 3))//compile Time Error : method add(int, int) is already defined in class Adder

	}

}
