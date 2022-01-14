package OOP;

class Bike1{
	int speed = 70;
}

public class Harley extends Bike1 {

	int speed = 120;
	
	public static void main(String[] args) {
		Bike1 obj = new Harley();
		System.out.println(obj.speed);//70
	}

}
