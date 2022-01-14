package training_Java;

public class Student {
	
	int id;
	String name;
	static String college = "Dai Hoc Back Khoa";
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void display() {
		System.out.println(id + " " + name + " " + college);
	}

	public static void main(String[] args) {
		
		Student s1 = new Student(888, "MaiHa");
		Student s2 = new Student(999, "HaoMinh");
		s1.display();
		s2.display();

	}

}
