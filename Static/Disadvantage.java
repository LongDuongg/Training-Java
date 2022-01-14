package Static;

public class Disadvantage {
	int a = 4;// none-static
	
	public static void Show() {
		System.out.print(a);
	}
	
	public static void main(String[] args) {
		Disadvantage d1 = new Disadvantage();
		d1.Show();
	}

}
// compile time error
