package training_Java;

public class Tinh_n_mu_10 {

	public static long TinhNMu10(int m) {
		long tg = 1;
		for(int i = 1; i <= 10; i++) {
			tg *= m;
		}
		return tg;
	}
	
	
	public static void main(String[] args) {
		Tinh_n_mu_10 t = new Tinh_n_mu_10();
		System.out.println("Luy thua 10 cua so la : " + t.TinhNMu10(2));
	}

}
