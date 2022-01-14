package OOP;

class Animal{
	void Eat() {
		System.out.println("Eating");
	}
}

class Cat1 extends Animal{
	void Eat() {
		System.out.println("Eating fish");
	}
}

public class BabyCat extends Cat1 {

	void Eat() {
		System.out.println("Drinking water");
	}
	
	public static void main(String[] args) {
		Animal a1 = new Animal(); a1.Eat();// eating
		Animal a2 = new Cat1(); a2.Eat();// eating fish
		Animal a3 = new BabyCat(); a3.Eat();//drinking water
	}

}
