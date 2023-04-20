package generic_utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method is used to get a random number to name to avoid duplicates in names
	 * @return
	 * @author Harshith
	 */
public int getRandomNum()
{
	Random ran=new Random();
	int RanNum = ran.nextInt(1000);
	return RanNum;
	
}
}
