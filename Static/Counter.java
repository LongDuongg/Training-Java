package Static;

public class Counter {
	
	static int counter = 0;
	
	public void Pt1() {
		counter++;
		System.out.println("Counter : " + counter);
	}

	public static void main(String[] args) {
		Counter c1 = new Counter(); c1.Pt1();
		Counter c2 = new Counter(); c2.Pt1();
		Counter c3 = new Counter(); c3.Pt1();
	}

}
