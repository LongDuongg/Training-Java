package Exception;
import java.net.*;
public class ExceptionTest7 {
// MalformedURLException
	public static void main(String[] args) throws MalformedURLException {
		try {
			URL url = new URL("http://mail.yahoo.com");
		} catch(Exception e) {
			System.out.println("Invalide URL");
			throw e;
		}

	}

}
