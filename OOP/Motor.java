package OOP;

class Bike {
	void Run() {
		System.out.println("Running");
	}
}

public class Motor extends Bike {

	void Run() {
		System.out.println("Running safely");
	}
	
	public static void main(String[] args) {
		Bike obj = new Motor();
		obj.Run();
	}

}
