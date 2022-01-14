package Static;

public class Student1 {
	
	int ID;
	String Name;
	static String college = "Dai Hoc Back Khoa";
	
	public Student1(int id, String name) {
		this.ID = id;
		this.Name = name;
	}
	
	public static void Change() {
		college = "DHBK";
	}
	
	public void Show() {
		System.out.println("ID: " + ID + ", Name: " + Name + ", Company: " + college);
	}

	public static void main(String[] args) {
		
		Student1.Change();
		Student1 s1 = new Student1(123,"MaiHa"); s1.Show();
		Student1 s2 = new Student1(456,"HaoLong"); s2.Show();
		Student1 s3 = new Student1(789,"TrieuVan"); s3.Show();
	}

}
