package Bai_Tap;

public class Bai7_So_Ngay {
	
	public static void main(String[] args) {
		int month = 4, year = 2020;
		
		switch(month) {
		
			case 1 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
				
			case 2 :
				if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					System.out.println("So ngay trong thang " + month + " la " + 29 + " ngay");
					break;
				} else {
					System.out.println("So ngay trong thang " + month + " la " + 28 + " ngay");
					break;
				}
								
			case 3 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
			
			case 4 :
				System.out.println("So ngay trong thang " + month + " la " + 30 + " ngay");
				break;
				
			case 5 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
				
			case 6 :
				System.out.println("So ngay trong thang " + month + " la " + 30 + " ngay");
				break;
				
			case 7 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
				
			case 8 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
				
			case 9 :
				System.out.println("So ngay trong thang " + month + " la " + 30 + " ngay");
				break;
				
			case 10 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
				
			case 11 :
				System.out.println("So ngay trong thang " + month + " la " + 30 + " ngay");
				break;
				
			case 12 :
				System.out.println("So ngay trong thang " + month + " la " + 31 + " ngay");
				break;
				
		}
	}

}
