package comcast.vtiger.genericUtility;

import java.util.Random;

public class Java_Utility {
	
	/** 
	 * this method is used for Concatenate to Excel data
	 * @author Shilpa
	 */
	public int getRandomNumber()
	{
		Random ran= new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
		
				
	}
}
