package training_Java;

public class Switch_Case {

	public static void main(String[] args) {
		String gender = "boy";
		
		switch(gender) {
			case "boy":
				System.out.print("You are the boy");
				break;
				
			case "girl":
				System.out.print("You are the girl");
				break;
				
			case "":
				System.out.print("We don't know !");
				break;
				
			default :
				System.out.print("We have no idea !");
				break;
		}
		
		System.out.println();
		
		int roll = 3;
		
		switch(roll) {
			case 1:
				System.out.print("I am Pankaj");
				break;
				
			case 2:
				System.out.print("I am Nikhil");
				break;
				
			case 3:
				System.out.print("I am John");
				break;
				
			default :
				System.out.print("We have no student !");
				break;
		}
	}

}
