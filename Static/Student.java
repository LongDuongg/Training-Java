package Static;

public class Student {
	
	int ID;
	String Name;
	static String college = "DHBK";
	
	public Student(int id, String name) {
		this.ID = id;
		this.Name = name;
	}
	
	public void Show() {
		System.out.println("ID: " + ID + ", Name: " + Name + ", Company: " + college);
	}

	public static void main(String[] args) {
		
		Student s1 = new Student(123,"MaiHa"); s1.Show();
		Student s2 = new Student(456,"HaoLong"); s2.Show();

	}

}
