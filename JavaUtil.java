package CommonUtils;

import java.util.Random;

public class JavaUtil {
	
	// we are using random constructor bcoz every time we create an orgnization that
	// time we have to change the company name or orgnization name to overcome this
	// problem we use random number.
	
	public int getRandomNumber() {
		
		Random r = new Random();
		int ran = r.nextInt(500);
		return ran;
	}


}
